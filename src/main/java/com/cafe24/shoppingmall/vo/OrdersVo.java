package com.cafe24.shoppingmall.vo;

import org.hibernate.validator.constraints.Length;

public class OrdersVo {
    private int no;
    private String sendName;
    private String sendZipcode;
    private String sendAddress;
    private String sendPhone;
    private String sendEmail;
    private String recipientName;
    private String recipientZipcode;
    private String recipientAddress;
    private String message;

    @Length(min=6, max=10,message="비밀번호는 6자 이상 10자 이하로 입력해야 합니다.")
    private String orderPassword;
    private String id;
     private double totalPurchasePrice;
    private double totalActualPayment;
    private String orderShippingStatus;
    private String orderProcessStatus;
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getSendName() {
        return sendName;
    }

    public void setSendName(String sendName) {
        this.sendName = sendName;
    }

    public String getSendZipcode() {
        return sendZipcode;
    }

    public void setSendZipcode(String sendZipcode) {
        this.sendZipcode = sendZipcode;
    }

    public String getSendAddress() {
        return sendAddress;
    }

    public void setSendAddress(String sendAddress) {
        this.sendAddress = sendAddress;
    }

    public String getSendPhone() {
        return sendPhone;
    }

    public void setSendPhone(String sendPhone) {
        this.sendPhone = sendPhone;
    }

    public String getSendEmail() {
        return sendEmail;
    }

    public void setSendEmail(String sendEmail) {
        this.sendEmail = sendEmail;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getRecipientZipcode() {
        return recipientZipcode;
    }

    public void setRecipientZipcode(String recipientZipcode) {
        this.recipientZipcode = recipientZipcode;
    }

    public String getRecipientAddress() {
        return recipientAddress;
    }

    public void setRecipientAddress(String recipientAddress) {
        this.recipientAddress = recipientAddress;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getOrderPassword() {
        return orderPassword;
    }

    public void setOrderPassword(String orderPassword) {
        this.orderPassword = orderPassword;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getTotalPurchasePrice() {
        return totalPurchasePrice;
    }

    public void setTotalPurchasePrice(double totalPurchasePrice) {
        this.totalPurchasePrice = totalPurchasePrice;
    }

    public double getTotalActualPayment() {
        return totalActualPayment;
    }

    public void setTotalActualPayment(double totalActualPayment) {
        this.totalActualPayment = totalActualPayment;
    }

    public String getOrderShippingStatus() {
        return orderShippingStatus;
    }

    public void setOrderShippingStatus(String orderShippingStatus) {
        this.orderShippingStatus = orderShippingStatus;
    }

    public String getOrderProcessStatus() {
        return orderProcessStatus;
    }

    public void setOrderProcessStatus(String orderProcessStatus) {
        this.orderProcessStatus = orderProcessStatus;
    }

    @Override
    public String toString() {
        return "OrdersVo{" +
                "no=" + no +
                ", sendName='" + sendName + '\'' +
                ", sendZipcode='" + sendZipcode + '\'' +
                ", sendAddress='" + sendAddress + '\'' +
                ", sendPhone='" + sendPhone + '\'' +
                ", sendEmail='" + sendEmail + '\'' +
                ", recipientName='" + recipientName + '\'' +
                ", recipientZipcode='" + recipientZipcode + '\'' +
                ", recipientAddress='" + recipientAddress + '\'' +
                ", message='" + message + '\'' +
                ", orderPassword='" + orderPassword + '\'' +
                ", id='" + id + '\'' +
                ", totalPurchasePrice=" + totalPurchasePrice +
                ", totalActualPayment=" + totalActualPayment +
                ", orderShippingStatus='" + orderShippingStatus + '\'' +
                ", orderProcessStatus='" + orderProcessStatus + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
