package com.ethen.wechatshop.cms.vo;

/**
 * 商品信息
 */
public class Product {
//    EP_ID          NUMBER(10) not null,
//    EP_NAME        VARCHAR2(20) not null,
//    EP_DESCRIPTION VARCHAR2(100),
//    EP_PRICE       NUMBER(10,2) not null,
//    EP_STOCK       NUMBER(10) not null,
//    EPC_ID         NUMBER(10),
//    EPC_CHILD_ID   NUMBER(10),
//    EP_FILE_NAME   VARCHAR2(200)


    private Integer productId;
    private String productName;
    private String description;
    private Double price;
    private Integer stock;
    private String fileName;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", fileName='" + fileName + '\'' +
                '}';
    }
}
