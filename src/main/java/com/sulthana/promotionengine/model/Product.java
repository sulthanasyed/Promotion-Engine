package com.sulthana.promotionengine.model;

public class Product {
    private String skuId;
    private int unitPrice;

    public Product(String skuId, int unitPrice) {
        this.skuId = skuId;
        this.unitPrice = unitPrice;
    }

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString(){
        return "Product{" + "sku='" + skuId + '\'' +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
