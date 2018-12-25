package com.hanxiaocu.mongodb.controller;

import com.hanxiaocu.mongodb.entity.Baike;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.mongodb.core.DbCallback;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

import static org.springframework.data.mongodb.core.query.Query.query;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/28
 */
@Controller
@RequestMapping("/mongo")
public class MongoBaikeController {

    @Autowired
    MongoTemplate mongoTemplate;

    @GetMapping("/addbaike")
    public Baike addBaike(Baike baike) {
        baike.setCreateDate(new Date());
        mongoTemplate.insert(baike, "baike");
        return baike;
    }

    @GetMapping("/baike/{_id}")
    public Baike findUserById(@PathVariable String _id) {
        Baike baike = mongoTemplate.findById(_id, Baike.class);
        return baike;
    }

    @GetMapping("/query/bad/{bad}&{good}")
    public List<Baike> queryBad(@PathVariable int bad, @PathVariable int good) {
        Criteria    gtBad  = Criteria.where("comment.bad").gt(bad);
        Criteria    ltGood = Criteria.where("comment.good").lt(good);
        List<Baike> list   = mongoTemplate.find(query(gtBad.andOperator(ltGood)), Baike.class);
        return list;
    }

    @GetMapping("/baike/tag/{tag}/{pageNum}")
    public List<Baike> findBaike(@PathVariable String tag, @PathVariable int pageNum) {
        Criteria criteria = Criteria.where("tag").in(tag);
        Query    query    = query(criteria);

        long totalCount = mongoTemplate.count(query, Baike.class);

        int  numOfPage = 10;
        long totalPage = totalCount % numOfPage == 0 ? (totalCount / numOfPage) : (totalCount / numOfPage + 1);

        int skip = (pageNum - 1) * numOfPage;

        query.skip(skip).limit(numOfPage);
        List<Baike> list = mongoTemplate.find(query, Baike.class);
        return list;
    }

    @GetMapping("/baike/tag/{tag}")
    public @ResponseBody
    String addOne(@PathVariable String tag) {
        Criteria criteria = Criteria.where("tag").in(tag);

        Update update = new Update();

        //自增
        update.inc("comment.good", 1);

        UpdateResult result = mongoTemplate.updateMulti(query(criteria), update, Baike.class);

        return "成功修改" + result.getModifiedCount();
    }

    @GetMapping("/deletebaike")
    public Baike deleteBaike(String _id) {
        Baike baike = new Baike();
        baike.setId(_id);
        mongoTemplate.remove(baike);
        return baike;
    }

    @GetMapping("/baike/{name}")
    public Baike findUser(@PathVariable String name) {
        final String id = name;
        Baike baike = mongoTemplate.execute(new DbCallback<Baike>() {
            public Baike doInDB(MongoDatabase db) throws MongoException, DataAccessException {
                MongoCollection<Document> collection = db.getCollection("baike");
                Document                  doc        = collection.find(new Document("_id", id)).first();

                Baike baike = new Baike();
                baike.setDesc(doc.getString("desc"));
                Baike.Comment comment    = new Baike.Comment();
                Document      docComment = doc.get("comment", Document.class);
                comment.setBad(docComment.getInteger("bad"));
                comment.setGood(docComment.getInteger("good"));
                baike.setComment(comment);
                return baike;
            }
        });
        return baike;
    }
}
