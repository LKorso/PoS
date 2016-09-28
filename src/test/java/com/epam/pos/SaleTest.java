package com.epam.pos;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SaleTest {
    private Sale sale;

    @Before
    public void setUp() throws Exception {
        sale = new Sale();
    }

    @Test
    public void makeLineItem() throws Exception {
        sale.makeLineItem(Product.JUICE, 2);
        sale.makeLineItem(Product.TEA, 1);
        assertEquals(115, sale.total());
    }

    @Test(expected = IllegalArgumentException.class)
    public void makeNullLineItem() throws Exception {
        sale.makeLineItem(null, 3);
    }


}
