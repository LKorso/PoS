package com.epam.pos;

public class Balance {
    private int balance;

    public Balance(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void increase(Coin coin){
        balance += coin.getRating();
    }
}
