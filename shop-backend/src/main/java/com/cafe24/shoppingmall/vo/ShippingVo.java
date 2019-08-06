package com.cafe24.shoppingmall.vo;

public class ShippingVo {
    private int no;
    private  String id;
    private String zipcode;
    private String address;
    private boolean isDefault;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
    }

    @Override
    public String toString() {
        return "ShippingVo{" +
                "no=" + no +
                ", id='" + id + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", address='" + address + '\'' +
                ", isDefault=" + isDefault +
                '}';
    }
}
