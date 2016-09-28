package com.epam.pos;

import java.util.ArrayList;
import java.util.List;

public class DrinksMachine {
    private List<Product> products = new ArrayList();
    private Sale currentSale;

    public DrinksMachine() {
        currentSale = new Sale();
        setProductsList();
    }

    public void chooseProduct(Product chosenProduct, int quantity){
        currentSale.makeLineItem(chosenProduct, quantity);
    }

    private void setProductsList() {
        products.add(Product.TEA);
        products.add(Product.COFFEE);
        products.add(Product.JUICE);
    }

    private int pay(Coin coin){
        return currentSale.total() - coin.getRating();
    }
}
