package com.gcfd.storage.entity;

import java.io.Serializable;
import java.util.List;

public class OrderInfo implements Serializable {

    private String userSign;
    private Order order;
    private OrderDispatching orderDispatching;
    private OrderPayInfo orderPayInfo;
    private List<OrderProductDetail> orderProductDetailList;
    private List<OrderFeeDetail> orderFeeDetailList;

    public String getUserSign() {
        return userSign;
    }

    public void setUserSign(String userSign) {
        this.userSign = userSign;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public OrderDispatching getOrderDispatching() {
        return orderDispatching;
    }

    public void setOrderDispatching(OrderDispatching orderDispatching) {
        this.orderDispatching = orderDispatching;
    }

    public OrderPayInfo getOrderPayInfo() {
        return orderPayInfo;
    }

    public void setOrderPayInfo(OrderPayInfo orderPayInfo) {
        this.orderPayInfo = orderPayInfo;
    }

    public List<OrderProductDetail> getOrderProductDetailList() {
        return orderProductDetailList;
    }

    public void setOrderProductDetailList(List<OrderProductDetail> orderProductDetailList) {
        this.orderProductDetailList = orderProductDetailList;
    }

    public List<OrderFeeDetail> getOrderFeeDetailList() {
        return orderFeeDetailList;
    }

    public void setOrderFeeDetailList(List<OrderFeeDetail> orderFeeDetailList) {
        this.orderFeeDetailList = orderFeeDetailList;
    }
}
