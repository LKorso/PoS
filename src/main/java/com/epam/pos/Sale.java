package com.epam.pos;

import java.util.ArrayList;
import java.util.List;

public class Sale {
    private List<SalesLineItem> lineItems = new ArrayList();
    private Balance currentBalance;

    public void makeLineItem(Product product, int quantity) {
        if(product == null){
            throw new IllegalArgumentException("Wrong product.");
        }
        lineItems.add(new SalesLineItem(quantity, product));
    }

    public List<Product> getProducts(){
        List<Product> products = new ArrayList();
        for(SalesLineItem lineItem  : lineItems){
            for(int i = 1; i <= lineItem.getQuantity(); i++){
                products.add(lineItem.getProduct());
            }
        }
        return products;
    }

    public int total() {
        int total = 0;
        for(SalesLineItem lineItem : lineItems){
            total += lineItem.subtotal();
        }
        return total;
    }

    public int changeBalance(Coin coin){
        if(currentBalance == null){
            currentBalance = new Balance(-total());
        }
        currentBalance.increase(coin);
        return currentBalance.getBalance();
    }
}
