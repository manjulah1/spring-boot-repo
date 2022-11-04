package com.cognologix.product.entities;

public class Product {
    private Integer productId;
    private String productName;
    private String batchNo;
    private Double price;
    private Integer noofProduct;

    public Product(){}

    public Product(Integer productId, String productName, String batchNo, Double price, Integer noofProduct) {
        this.productId = productId;
        this.productName = productName;
        this.batchNo = batchNo;
        this.price = price;
        this.noofProduct = noofProduct;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", batchNo='" + batchNo + '\'' +
                ", price=" + price +
                ", noofProduct=" + noofProduct +
                '}';
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getNoofProduct() {
        return noofProduct;
    }

    public void setNoofProduct(Integer noofProduct) {
        this.noofProduct = noofProduct;
    }
}
