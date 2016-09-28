package com.epam.pos;

public enum Coin {
    ONE(1), FIVE(5), TEN(10), TWENTYFIVE(25), FIFTY(50);

    private int rating;

    Coin(int rating) {
        this.rating = rating;
    }

    public int getRating() {
        return rating;
    }
}
