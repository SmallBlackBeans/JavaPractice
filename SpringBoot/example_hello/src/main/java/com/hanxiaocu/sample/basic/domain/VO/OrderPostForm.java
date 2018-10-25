package com.hanxiaocu.sample.basic.domain.VO;

import com.hanxiaocu.sample.basic.domain.PO.Order;

import java.io.Serializable;
import java.util.List;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/23 4:38 PM
 */

public class OrderPostForm implements Serializable {
    private Order order;
    private  List<OrderDetail> details;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<OrderDetail> getDetails() {
        return details;
    }

    public void setDetails(List<OrderDetail> details) {
        this.details = details;
    }
}
