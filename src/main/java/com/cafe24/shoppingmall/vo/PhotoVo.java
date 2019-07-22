package com.cafe24.shoppingmall.vo;

public class PhotoVo {
    private int no;
    private String path;
    private boolean isThumb;
    private int ProductNo;

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

    public boolean isThumb() {
        return isThumb;
    }

    public void setThumb(boolean thumb) {
        isThumb = thumb;
    }

    public int getProductNo() {
        return ProductNo;
    }

    public void setProductNo(int productNo) {
        ProductNo = productNo;
    }

    @Override
    public String toString() {
        return "PhotoVo{" +
                "no=" + no +
                ", path='" + path + '\'' +
                ", isThumb=" + isThumb +
                ", ProductNo=" + ProductNo +
                '}';
    }
}
