package com.cafe24.shoppingmall.vo;

public class ProductVo {
    private int productNo;
    private String name;
    private String content;
    private String regDate;
    private String updateDate;
    private int postWeight;
    private String material;
    private double price;
    private String country;
    private boolean isDisplay;
    private boolean isSale;
    private double wholesalePrice;
    private double actualPrice;
    private int categoryNo;
    private String productCode;

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getProductNo() {
        return productNo;
    }

    public void setProductNo(int productNo) {
        this.productNo = productNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public int getPostWeight() {
        return postWeight;
    }

    public void setPostWeight(int postWeight) {
        this.postWeight = postWeight;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public boolean isDisplay() {
        return isDisplay;
    }

    public void setDisplay(boolean display) {
        isDisplay = display;
    }

    public boolean isSale() {
        return isSale;
    }

    public void setSale(boolean sale) {
        isSale = sale;
    }

    public double getWholesalePrice() {
        return wholesalePrice;
    }

    public void setWholesalePrice(double wholesalePrice) {
        this.wholesalePrice = wholesalePrice;
    }

    public double getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(double actualPrice) {
        this.actualPrice = actualPrice;
    }

    public int getCategoryNo() {
        return categoryNo;
    }

    public void setCategoryNo(int categoryNo) {
        this.categoryNo = categoryNo;
    }

    @Override
    public String toString() {
        return "ProductVo{" +
                "productNo=" + productNo +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", regDate='" + regDate + '\'' +
                ", updateDate='" + updateDate + '\'' +
                ", postWeight=" + postWeight +
                ", material='" + material + '\'' +
                ", price=" + price +
                ", country='" + country + '\'' +
                ", isDisplay=" + isDisplay +
                ", isSale=" + isSale +
                ", wholesalePrice=" + wholesalePrice +
                ", actualPrice=" + actualPrice +
                ", categoryNo=" + categoryNo +
                ", productCode='" + productCode + '\'' +
                '}';
    }
}
