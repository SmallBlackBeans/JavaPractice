import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/18
 */

public class JsonTest {
    public static void main(String[] args) {
        String jsonStr = "{\"code\":10000,\"message\":null,\"data\":{\"orderPartyList\":[{\"isDefault\":true,\"quantity\":0,\"name\":\"浙杭州D32时尚街区\",\"oid\":2897703784,\"isNew\":false},{\"isDefault\":false,\"quantity\":0,\"name\":\"浙杭州文一物美店\",\"oid\":2897704144,\"isNew\":false},{\"isDefault\":false,\"quantity\":0,\"name\":\"浙杭州西城广场\",\"oid\":2897704232,\"isNew\":false}]}}";
        JSONObject json = JSONObject.parseObject(jsonStr);

        JSONObject data           = (JSONObject) json.get("data");
        JSONArray  orderPartyList = data.getJSONArray("orderPartyList");
        for (Object order : orderPartyList) {
            JSONObject or = (JSONObject) order;
            Boolean    isDefault = or.getBoolean("isDefault");
            if (isDefault) {
                System.out.println(or.get("oid"));
            }
        }
        //JSON.parseObject(dataStr, OrderData.Data.class);
        OrderData d = JSON.toJavaObject(json,OrderData.class);
        System.out.println(d);
    }

}
