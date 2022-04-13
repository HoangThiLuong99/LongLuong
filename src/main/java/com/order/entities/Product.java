package com.order.entities;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    public int productId;
    @Column(name = "product_name")
    public String productName;
    @Column(name = "price")
    public int price;
    @Column(name = "so_luong")
    public int soluong;
    @Column(name = "category_id")
    public int categoryId;

    public Product() {
    }

    public Product(int productId, String productName, int price, int soluong, int categoryId) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.soluong = soluong;
        this.categoryId = categoryId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", soluong=" + soluong +
                ", categoryId=" + categoryId +
                '}';
    }
}
