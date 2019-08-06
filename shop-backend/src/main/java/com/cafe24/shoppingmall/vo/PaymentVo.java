package com.cafe24.shoppingmall.vo;

public class PaymentVo {
    private int paymentNo;
    private String paymentMethod;
    private String paymentDate;
    private Double price;
    private String paymentStatus;

    private int no;

    public int getPaymentNo() {
        return paymentNo;
    }

    public void setPaymentNo(int paymentNo) {
        this.paymentNo = paymentNo;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "PaymentVo{" +
                "paymentNo=" + paymentNo +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", paymentDate='" + paymentDate + '\'' +
                ", price=" + price +
                ", paymentStatus='" + paymentStatus + '\'' +
                ", no=" + no +
                '}';
    }
}
