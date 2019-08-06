package com.cafe24.shoppingmall.vo;

public class OrderDetailVo {
    private int no;
    private int stockNo;
    private String orderDate;
    private int amount;
    private String orderStatus;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public int getStockNo() {
        return stockNo;
    }

    public void setStockNo(int stockNo) {
        this.stockNo = stockNo;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return "OrderDetailVo{" +
                "no=" + no +
                ", stockNo=" + stockNo +
                ", orderDate='" + orderDate + '\'' +
                ", amount=" + amount +
                ", orderStatus='" + orderStatus + '\'' +
                '}';
    }
}
