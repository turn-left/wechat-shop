package com.ethen.wechatshop.cms.vo;

/**
 * 产品分类
 */
public class ProductClass {
//    EPC_ID        NUMBER(10) not null,
//    EPC_NAME      VARCHAR2(20) not null,
//    EPC_PARENT_ID NUMBER(10) not null
    private Integer categoryId;
    private String categoryName;
    private Integer parentId;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        return "ProductClass{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", parentId=" + parentId +
                '}';
    }
}
