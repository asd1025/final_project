package com.cafe24.shoppingmall.vo;

public class CartVo {
    private int no; //장바구니 번호
    private String id;
    private int quantity; // 상품의 수량
    private StockVo stockVo; // 상품재고
    private String updateDate;

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

    public StockVo getStockVo() {
        return stockVo;
    }

    public void setStockVo(StockVo stockVo) {
        this.stockVo = stockVo;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public String toString() {
        return "CartVo{" +
                "no=" + no +
                ", id='" + id + '\'' +
                ", quantity=" + quantity +
                ", stockVo=" + stockVo +
                ", updateDate='" + updateDate + '\'' +
                '}';
    }
}
