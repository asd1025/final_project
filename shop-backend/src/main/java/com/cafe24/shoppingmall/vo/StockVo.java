package com.cafe24.shoppingmall.vo;

public class StockVo {
    /***
     *
     *  상품의 옵션별 상품을 의미하며, 재고테이블이다.
     *
     */
    private int stockNo;
    private String finalOption; // 최종 옵션을 스트링으로 가지고 있다.  ex) 빨강/90
    private String optionNums; // 최종 옵션을 번호로 표현하여, 스트링으로 가지고 있다. ex) 3/2
    private String instockDate;
    private int amount;
    private boolean isNonStock; // 비재고 여부
    private int purchaseCount; // 구매 횟수
    private double optionPrice; // 추가금액
    private String productCode; // 상품코드

    private int productNo; // 카테고리를 제외한 상품 자체를 의미한다. ex) 나이키 에어맥스90
    private String productName; //상품 이름
    private String thumbImg; // 대표사진 경로

    public int getStockNo() {
        return stockNo;
    }

    public void setStockNo(int stockNo) {
        this.stockNo = stockNo;
    }

    public String getFinalOption() {
        return finalOption;
    }

    public void setFinalOption(String finalOption) {
        this.finalOption = finalOption;
    }

    public String getOptionNums() {
        return optionNums;
    }

    public void setOptionNums(String optionNums) {
        this.optionNums = optionNums;
    }

    public String getInstockDate() {
        return instockDate;
    }

    public void setInstockDate(String instockDate) {
        this.instockDate = instockDate;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public boolean getIsNonStock() {
        return isNonStock;
    }

    public void setIsNonStock(boolean isNonStock) {
        this.isNonStock = isNonStock;
    }

    public int getPurchaseCount() {
        return purchaseCount;
    }

    public void setPurchaseCount(int purchaseCount) {
        this.purchaseCount = purchaseCount;
    }

    public double getOptionPrice() {
        return optionPrice;
    }

    public void setOptionPrice(double optionPrice) {
        this.optionPrice = optionPrice;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public int getProductNo() {
        return productNo;
    }

    public void setProductNo(int productNo) {
        this.productNo = productNo;
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
        return "StockVo{" +
                "stockNo=" + stockNo +
                ", finalOption='" + finalOption + '\'' +
                ", optionNums='" + optionNums + '\'' +
                ", instockDate='" + instockDate + '\'' +
                ", amount=" + amount +
                ", isNonStock=" + isNonStock +
                ", purchaseCount=" + purchaseCount +
                ", optionPrice=" + optionPrice +
                ", productCode='" + productCode + '\'' +
                ", productNo=" + productNo +
                ", productName='" + productName + '\'' +
                ", thumbImg='" + thumbImg + '\'' +
                '}';
    }
}
