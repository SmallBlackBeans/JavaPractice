package com.hanxiaocu.mongodb.Entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/28
 */

public class Baike {

    private String id;
    private String desc;
    private List<String> tag = new ArrayList<String>();
    private Comment comment = null;
    private Date createDate = null;
    private Date updateDate = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<String> getTag() {
        return tag;
    }

    public void setTag(List<String> tag) {
        this.tag = tag;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public static class Comment {
        int good;
        int bad;

        public int getGood() {
            return good;
        }

        public void setGood(int good) {
            this.good = good;
        }

        public int getBad() {
            return bad;
        }

        public void setBad(int bad) {
            this.bad = bad;
        }
    }
}
