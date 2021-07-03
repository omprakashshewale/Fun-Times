package com.grocery.calculation;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.grocery.enums.ItemName;

public class BasketTest {



    @Test
    public void noOfItems() {
        Basket basket = new Basket();

        basket.putItems(ItemName.SOUP, 1);
        basket.putItems(ItemName.SOUP, 2);

        assertEquals(Integer.valueOf(3), basket.getItems().get(ItemName.SOUP));
    }

}
