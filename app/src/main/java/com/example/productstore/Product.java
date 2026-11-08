package com.example.productstore;

public class Product {
    private final String name;
    private final String category;
    private final String price;
    private final int imageResource;

    public Product(String name, String category, String price, int imageResource) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.imageResource = imageResource;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getPrice() {
        return price;
    }

    public int getImageResource() {
        return imageResource;
    }
}
