package com.epam.pos.com.epam.pos.comands;

import com.epam.pos.BeverageMachine;
import com.epam.pos.Coin;
import com.epam.pos.com.epam.pos.reader.LineReader;

public class BuyCommand extends Command {
    public BuyCommand(BeverageMachine machine) {
        super(machine);
    }

    public boolean doAction(String value) {
        showAmount();
        showDenomination();
        doPayProcess();
        return true;
    }

    private void showDenomination() {
        System.out.println("Terminal accepts coins next denomination: ");
        for(Coin coin : getMachine().getCoinsSet()){
            System.out.print(" [" + coin.getRating() + "] ");
        }
    }

    private void showAmount(){
        System.out.println("Please pay " + getMachine().returnTotal() + " coins to enjoy chosen beverages!");
    }

    private Coin chooseCoin(int denomination) {
        for(Coin coin : getMachine().getCoinsSet()){
            if(coin.getRating() == denomination){
                return coin;
            }
        }
        return null;
    }

    private void doPayProcess(){
        int rest = - getMachine().returnTotal();
        while(rest < 0){
            System.out.println("Put coin: ");
            rest = getMachine().pay(chooseCoin(LineReader.readNumber()));
        }
        System.out.println("Thanks for choosing us!\n Here is your beverages: \n" + getMachine().returnBoughtProducts());
        System.out.println(getMachine().returnRest(rest));
    }
}
