package com.cafe24.shoppingmall.vo;

public class CategoryVo {
    private int categoryNo;
    private String name;
    private int parentCategory;
    private String categoryCode;

    public int getCategoryNo() {
        return categoryNo;
    }

    public void setCategoryNo(int categoryNo) {
        this.categoryNo = categoryNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(int parentCategory) {
        this.parentCategory = parentCategory;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    @Override
    public String toString() {
        return "CategoryVo{" +
                "categoryNo=" + categoryNo +
                ", name='" + name + '\'' +
                ", parentCategory=" + parentCategory +
                ", categoryCode='" + categoryCode + '\'' +
                '}';
    }
}
