package com.cafe24.shoppingmall.vo;

import java.util.List;

public class OptionVo {
    private int optionNo;
    private  String optionName;
    private int productNo;
    private List<OptionDetailVo> optionDetails;


    public List<OptionDetailVo> getOptionDetails() {
        return optionDetails;
    }

    public void setOptionDetails(List<OptionDetailVo> optionDetails) {
        this.optionDetails = optionDetails;
    }

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
                ", optionDetails=" + optionDetails +
                '}';
    }
}
