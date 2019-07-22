package com.cafe24.shoppingmall.vo;

public class OptionDetailVo {
    private int no;
    private String detailName;
    private int optionNo;
    private String detailCode;

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

    public int getOptionNo() {
        return optionNo;
    }

    public void setOptionNo(int optionNo) {
        this.optionNo = optionNo;
    }

    public String getDetailCode() {
        return detailCode;
    }

    public void setDetailCode(String detailCode) {
        this.detailCode = detailCode;
    }

    @Override
    public String toString() {
        return "OptionDetailVo{" +
                "no=" + no +
                ", detailName='" + detailName + '\'' +
                ", optionNo=" + optionNo +
                ", detailCode='" + detailCode + '\'' +
                '}';
    }
}
