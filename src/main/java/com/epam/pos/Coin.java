package com.epam.pos;

public enum Coin{
    FIFTY(50),TWENTYFIVE(25), TEN(10), FIVE(5), ONE(1) ;

    private int rating;

    Coin(int rating) {
        this.rating = rating;
    }

    public int getRating() {
        return rating;
    }

}
