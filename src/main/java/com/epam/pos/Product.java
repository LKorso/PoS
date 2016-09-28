package com.epam.pos;

public enum Product {
    TEA(25, "Tea"), COFFEE(35, "Coffee"), JUICE(45, "Juice");

    private int price;
    private String description;

    Product(int price, String description) {
        this.price = price;
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }
}
