package com.epam.pos;

public class SalesLineItem {
    private int quantity;
    private Product product;

    public SalesLineItem(int quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int subtotal(){
        return product.getPrice() * quantity;
    }

    @Override
    public String toString() {
        return "SalesLineItem{" +
                "quantity=" + quantity +
                ", product=" + product +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SalesLineItem that = (SalesLineItem) o;

        if (quantity != that.quantity) return false;
        return product == that.product;

    }

    @Override
    public int hashCode() {
        int result = quantity;
        result = 31 * result + (product != null ? product.hashCode() : 0);
        return result;
    }
}
