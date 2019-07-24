package com.cafe24.shoppingmall.vo;

public class OptionVo {
    private int optionNo;
    private  String optionName;
    private int productNo;

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

    @Override
    public String toString() {
        return "OptionVo{" +
                "optionNo=" + optionNo +
                ", optionName='" + optionName + '\'' +
                ", productNo=" + productNo +
                '}';
    }
}
