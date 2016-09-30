package com.epam.pos.com.epam.pos.comands;

import com.epam.pos.BeverageMachine;
import com.epam.pos.Product;
import com.epam.pos.com.epam.pos.reader.LineReader;

public class ChooseProductCommand extends Command {
    public ChooseProductCommand(BeverageMachine machine) {
        super(machine);
    }

    public boolean doAction(String value) {
        return chooseProduct(value);
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
        System.out.println("Please, type how many caps of " + beverageName + " would you like to buy : ");
        return LineReader.readNumber();
    }
}
