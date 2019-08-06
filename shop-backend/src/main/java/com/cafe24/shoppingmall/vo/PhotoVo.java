package com.cafe24.shoppingmall.vo;

public class PhotoVo {
    private int no;
    private String path;
    private int isThumb;
    private int productNo;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getIsThumb() {
        return isThumb;
    }

    public void setIsThumb(int isThumb) {
        this.isThumb = isThumb;
    }

    public int getProductNo() {
        return productNo;
    }

    public void setProductNo(int productNo) {
        this.productNo = productNo;
    }

    @Override
    public String toString() {
        return "PhotoVo{" +
                "no=" + no +
                ", path='" + path + '\'' +
                ", isThumb=" + isThumb +
                ", productNo=" + productNo +
                '}';
    }
}
