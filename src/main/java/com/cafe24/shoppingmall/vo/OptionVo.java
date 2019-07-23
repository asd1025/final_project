package com.cafe24.shoppingmall.vo;

public class OptionVo {
    private int optionNo;
    private  String optionName;
    private int productNo;

    private int no;
    private String detailName;
    private String detailCode;

    public int getOptionNo() {
        return optionNo;
    }

    public void setOptionNo(int optionNo) {
        this.optionNo = optionNo;
    }

    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }

    public int getProductNo() {
        return productNo;
    }

    public void setProductNo(int productNo) {
        this.productNo = productNo;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getDetailName() {
        return detailName;
    }

    public void setDetailName(String detailName) {
        this.detailName = detailName;
    }

    public String getDetailCode() {
        return detailCode;
    }

    public void setDetailCode(String detailCode) {
        this.detailCode = detailCode;
    }

    @Override
    public String toString() {
        return "OptionVo{" +
                "optionNo=" + optionNo +
                ", optionName='" + optionName + '\'' +
                ", productNo=" + productNo +
                ", no=" + no +
                ", detailName='" + detailName + '\'' +
                ", detailCode='" + detailCode + '\'' +
                '}';
    }
}
