package ru.geekbrains.product;

import java.util.Objects;

public class Product {
    private Long id;

    private String productname;

    public Product() {
    }
    public Product(Long id, String productname) {
        this.id = id;
        this.productname = productname;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getProductname() {return productname;}
    public void setProductname(String productname) {this.productname = productname;}


    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + productname + '\'' +
                '}';
    }
}
