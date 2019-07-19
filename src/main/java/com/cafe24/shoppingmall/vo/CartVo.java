package com.cafe24.shoppingmall.vo;

public class CartVo {
    private int no; //장바구니 번호
    private String id;
    private int quantity; // 상품의 수량
    private int stockNo; //  상품 번호
    private String updateDate;

    private String productName;
    private String thumbImg; // 대표사진

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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getStockNo() {
        return stockNo;
    }

    public void setStockNo(int stockNo) {
        this.stockNo = stockNo;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getThumbImg() {
        return thumbImg;
    }

    public void setThumbImg(String thumbImg) {
        this.thumbImg = thumbImg;
    }

    @Override
    public String toString() {
        return "CartVo{" +
                "no=" + no +
                ", id='" + id + '\'' +
                ", quantity=" + quantity +
                ", stockNo=" + stockNo +
                ", updateDate='" + updateDate + '\'' +
                ", productName='" + productName + '\'' +
                ", thumbImg='" + thumbImg + '\'' +
                '}';
    }
}
