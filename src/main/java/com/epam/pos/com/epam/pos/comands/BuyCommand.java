package com.epam.pos.com.epam.pos.comands;

import com.epam.pos.BeverageMachine;
import com.epam.pos.Coin;

import java.util.Scanner;

public class BuyCommand extends Command {
    public BuyCommand(BeverageMachine machine) {
        super(machine);
    }

    public void doAction() {
        showAmount();
        showDenomination();
        doPayProcess();
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
        Scanner scanner = new Scanner(System.in);
        Coin givenCoin;
        while(rest < 0){
            System.out.println("Put coin: ");
            givenCoin = chooseCoin(scanner.nextInt());
            if(givenCoin != null) {
                rest = getMachine().pay(givenCoin);
            } else {
                System.out.println("Terminal doesn't accept coins with this denomination!");
            }
        }
        System.out.println("Thanks for choosing us!\n Here is your beverages: \n" + getMachine().returnBoughtProducts());
        System.out.println("Here is your rest: ");
        System.out.println(getMachine().returnRest(rest));
    }
}
