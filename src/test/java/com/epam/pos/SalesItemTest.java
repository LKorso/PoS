package com.epam.pos;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SalesItemTest {
    private SalesLineItem lineItem;

    @Before
    public void setUp() throws Exception {
        lineItem = new SalesLineItem();
    }

    @Test
    public void subtotalTest() throws Exception {
        lineItem.setProduct(Product.TEA);
        lineItem.setQuantity(3);
        assertEquals(75, lineItem.subtotal());
    }

    @Test(expected = IllegalArgumentException.class)
    public void negativeQuantity() throws Exception {
        lineItem.setQuantity(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void zeroQuantity() throws Exception {
        lineItem.setQuantity(0);
    }
}
