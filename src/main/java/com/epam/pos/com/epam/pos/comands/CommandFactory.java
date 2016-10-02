package com.epam.pos.com.epam.pos.comands;

import com.epam.pos.BeverageMachine;

public class CommandFactory {
    private static final String BUY_COMMAND_KEY = "buy";
    private static final String CHOOSE_PRODUCT_COMMAND_KEY = "choose";
    private static final String CANCEL_SALE_COMMAND_KEY = "cancel";

    private CommandFactory(){
    }

    public static Command getCommand(String commandKey, BeverageMachine machineInstance){
        if (BUY_COMMAND_KEY.equals(commandKey)){
            return new BuyCommand(machineInstance);
        } else if(CHOOSE_PRODUCT_COMMAND_KEY.equals(commandKey)){
            return new ChooseProductCommand(machineInstance);
        } else if(CANCEL_SALE_COMMAND_KEY.equals(commandKey)){
            return new CancelSaleCommand(machineInstance);
        } else {
            return null;
        }
    }
}
