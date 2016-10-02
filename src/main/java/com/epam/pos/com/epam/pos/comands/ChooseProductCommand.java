package com.epam.pos.com.epam.pos.comands;

import com.epam.pos.BeverageMachine;
import com.epam.pos.Product;

import java.util.Scanner;
import java.util.Set;

public class ChooseProductCommand extends Command {
    public ChooseProductCommand(BeverageMachine machine) {
        super(machine);
    }

    public void doAction() {
        String productName = getProductName();
        if(!chooseProduct(productName)) {
            System.out.println("You've chosen wrong beverage, please, try again.");
            doAction();
        } else {
            System.out.println("Your order accepted.");
        }
    }

    private String getProductName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, choose beverage.");
        showProducts(getMachine().getProductsList());
        return scanner.next();
    }

    private boolean chooseProduct(String productName){
        for (Product product : getMachine().getProductsList()) {
            if(product.getDescription().equals(productName)){
                getMachine().chooseProduct(product, getQuantity(productName));
                return true;
            }
        }
        return false;
    }

    private int getQuantity(String beverageName){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, type how many cups of " + beverageName + " would you like to buy : ");
        return scanner.nextInt();
    }

    private void showProducts(Set<Product> products){
        for(Product product : products){
            System.out.println("==  " + product.getDescription() + "\t-\t" + product.getPrice() + "  ==");
        }
    }
}
