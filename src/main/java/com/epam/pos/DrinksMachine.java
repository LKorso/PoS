package com.epam.pos;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

public class DrinksMachine {
    private Set<Product> products;
    private Sale currentSale;
    private Set<Coin> coins;

    public DrinksMachine() {
        currentSale = new Sale();
        setProductsSet();
        setCoinsSet();
    }

    public void chooseProduct(Product chosenProduct, int quantity){
        currentSale.makeLineItem(chosenProduct, quantity);
    }

    public List<Product> returnBoughtProducts(){
        return currentSale.getProducts();
    }

    public Set<Product> getProductsList() {
        return products;
    }

    public int endSale(){
        return currentSale.total();
    }

    public int pay(Coin coin){
        return  currentSale.changeBlance(coin);
    }

    public List<Coin> returnRest(int rest){
        List<Coin> coinsForReturn = new ArrayList();
        while (rest > 0){
            for (Coin coin : coins){
                while(rest >= coin.getRating()){
                    coinsForReturn.add(coin);
                    rest -= coin.getRating();
                }
            }
        }
        return coinsForReturn;
    }

    private void setProductsSet() {
        products = EnumSet.allOf(Product.class);
    }

    private void setCoinsSet() {
        coins = EnumSet.allOf(Coin.class);
    }
}