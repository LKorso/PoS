package com.epam.pos;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DrinksMachineTest {
    BeverageMachine testItem;

    @Before
    public void setUp() throws Exception {
        testItem = new BeverageMachine();
    }

    @Test
    public void chooseProductTest() throws Exception {
        assertTrue(true);
    }

    @Test
    public void rest() throws Exception {
        List<Coin> expectedRest = new ArrayList();
        expectedRest.add(Coin.TEN);
        expectedRest.add(Coin.FIVE);
        expectedRest.add(Coin.ONE);
        assertEquals(expectedRest, testItem.returnRest(16));
    }
}
