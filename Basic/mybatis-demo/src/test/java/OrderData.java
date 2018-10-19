import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/19 10:00 AM
 */

public class OrderData  {
    Data data;

    public OrderData() {
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "OrderData{" +
                "data=" + data +
                '}';
    }

    static class Data  {
        public Data() {
        }

        @Override
        public String toString() {
            return "Data{" +
                    "orderPartyList=" + orderPartyList +
                    '}';
        }

        List<OrderParty> orderPartyList =  new ArrayList<OrderParty>();

        public List<OrderParty> getOrderPartyList() {
            return orderPartyList;
        }

        public void setOrderPartyList(List<OrderParty> orderPartyList) {
            this.orderPartyList = orderPartyList;
        }
    }

    static class OrderParty {
        public OrderParty() {
        }

        boolean isDefault;
        int     quantity;
        String  name;
        String  oid;
        boolean isNew;

        public boolean isDefault() {
            return isDefault;
        }

        public void setDefault(boolean aDefault) {
            isDefault = aDefault;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getOid() {
            return oid;
        }

        public void setOid(String oid) {
            this.oid = oid;
        }

        public boolean isNew() {
            return isNew;
        }

        public void setNew(boolean aNew) {
            isNew = aNew;
        }

        @Override
        public String toString() {
            return "OrderParty{" +
                    "isDefault=" + isDefault +
                    ", quantity=" + quantity +
                    ", name='" + name + '\'' +
                    ", oid='" + oid + '\'' +
                    ", isNew=" + isNew +
                    '}';
        }
    }
}
