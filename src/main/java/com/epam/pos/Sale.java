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

    public int total() {
        int total = 0;
        for(SalesLineItem lineItem : lineItems){
            total += lineItem.subtotal();
        }
        return total;
    }

    public int pay(Coin coin){
        if (currentBalance == null){
            currentBalance = new Balance(total());
        }
        return currentBalance.getBalance();
    }
}
