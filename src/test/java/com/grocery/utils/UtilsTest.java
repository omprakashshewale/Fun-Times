package com.grocery.utils;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

import org.hamcrest.Matchers;
import org.junit.BeforeClass;
import org.junit.Test;

import com.grocery.calculation.Apple;
import com.grocery.calculation.Basket;
import com.grocery.enums.ItemName;

public class UtilsTest {




    @Test
    public void validApple() {
        Basket Basket = new Basket();
        Basket.putItems(ItemName.APPLE, 3);
        Basket.putItems(ItemName.BREAD, 1);

        BigDecimal bill = Utils.calculateBillAmount(Basket, LocalDateTime.now().plusDays(5));

        assertEquals(BigDecimal.valueOf(1.07), bill);
    }


    

    @Test
    public void invalidDateApple() {
        Basket Basket = new Basket();
        Basket.putItems(ItemName.APPLE, 6);
        Basket.putItems(ItemName.MILK, 1);

        BigDecimal bill = Utils.calculateBillAmount(Basket, LocalDateTime.now());

        assertEquals(BigDecimal.valueOf(1.90), bill);
    }
    
    @Test
    public void breadValid() {
        Basket Basket = new Basket();
        Basket.putItems(ItemName.SOUP, 3);
        Basket.putItems(ItemName.BREAD, 1);

        BigDecimal bill = Utils.calculateBillAmount(Basket, LocalDateTime.now());

        assertEquals(BigDecimal.valueOf(2.35), bill);
    }

    @Test
    public void bothValid() {
        Basket Basket = new Basket();
        Basket.putItems(ItemName.APPLE, 4);
        Basket.putItems(ItemName.SOUP, 2);
        Basket.putItems(ItemName.BREAD, 1);

        BigDecimal bill = Utils.calculateBillAmount(Basket, LocalDateTime.now().plusDays(5));

        assertEquals(BigDecimal.valueOf(2.06), bill);
    }

    
    
	@Test
    public void schemeValid() {
        assertTrue(Utils.checkOfferValidity(LocalDateTime.now().minusDays(1), LocalDateTime.now().plusDays(5), LocalDateTime.now()));
    }
	
    @Test
    public void schemeValidFuture() {
        assertTrue(Utils.checkOfferValidity(LocalDateTime.now().plusDays(1), LocalDateTime.now().plusDays(5), LocalDateTime.now().plusDays(2)));
    }

  

    @Test
    public void sameDate() {
        assertTrue(Utils.checkOfferValidity(LocalDateTime.now().minusDays(5), LocalDateTime.now().plusDays(3), LocalDateTime.now().plusDays(3).minusSeconds(5)));
    }

    @Test
    public void firstdate() {
        assertTrue(Utils.checkOfferValidity(LocalDateTime.now().minusDays(5), LocalDateTime.now().plusDays(3), LocalDateTime.now().minusDays(5).plusSeconds(5)));
    }


}
