package ru.geekbrains.product;

public class Product {
    private Long id;

    private String productname;
    private Integer price;

    public Product(String productname, Integer price) {
        this.productname = productname;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public String getProductname() {return productname;}

    public void setProductname(String productname) {this.productname = productname;}
}
