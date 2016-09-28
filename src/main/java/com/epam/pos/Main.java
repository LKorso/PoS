package com.epam.pos;

public class Main {
    private static DrinksMachine machine;

    public static void main(String[] args) {
        machine = new DrinksMachine();
        System.out.println("Hello!\nWhat would you like to drink today?");
        showProducts();
    }

    private static void showProducts() {
        for(Product drink : machine.getProducts()){
            System.out.println("== " + drink.getDescription() + " price: " + drink.getPrice() + " ==");
        }
    }


}
