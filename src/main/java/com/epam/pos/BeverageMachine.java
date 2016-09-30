package com.epam.pos;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

public class BeverageMachine {
    private Set<Product> products;
    private Sale currentSale;
    private Set<Coin> coins;

    public BeverageMachine() {
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

    public int returnTotal(){
        return currentSale.total();
    }

    public int pay(Coin coin){
        return  currentSale.changeBalance(coin);
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

    public void restartSale(){
        currentSale = new Sale();
    }

    public Set<Coin> getCoinsSet() {
        return coins;
    }

    private void setProductsSet() {
        products = EnumSet.allOf(Product.class);
    }

    private void setCoinsSet() {
        coins = EnumSet.allOf(Coin.class);
    }
}