package com.grocery.calculation;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hamcrest.Matchers;
import org.junit.BeforeClass;
import org.junit.Test;

import com.grocery.enums.ItemName;

public class BreadTest {



    @Test
    public void dateInvalid() {
        Basket basket = new Basket();
        basket.putItems(ItemName.BREAD, 2);
        Bread bread=new Bread() ;
        BigDecimal price = bread.calculatePrice(basket, ItemName.BREAD, LocalDateTime.now().plusMonths(3));

        assertThat(BigDecimal.valueOf(1.6), Matchers.comparesEqualTo(price));
    }


    
	@Test
    public void onlyBread() {
        Basket basket = new Basket();
        basket.putItems(ItemName.BREAD, 2);
        Bread bread=new Bread() ;
        BigDecimal price = bread.calculatePrice(basket, ItemName.BREAD, LocalDateTime.now());

        assertThat(BigDecimal.valueOf(1.6), Matchers.comparesEqualTo(price));
    }



    @Test
    public void soupGreaterthanBread() {

        Basket basket = new Basket();
        basket.putItems(ItemName.BREAD, 1);
        basket.putItems(ItemName.SOUP, 5);
        Bread bread=new Bread() ;
        BigDecimal price = bread.calculatePrice(basket, ItemName.BREAD, LocalDateTime.now());

        assertThat(BigDecimal.valueOf(0.4), Matchers.comparesEqualTo(price));
    }

    @Test
    public void soupLessthanBread() {
        Basket basket = new Basket();
        basket.putItems(ItemName.BREAD, 4);
        basket.putItems(ItemName.SOUP, 2);
        Bread bread=new Bread() ;
        BigDecimal price = bread.calculatePrice(basket, ItemName.BREAD, LocalDateTime.now());

        assertThat(BigDecimal.valueOf(2.8), Matchers.comparesEqualTo(price));
    }

    @Test
    public void soupInvalid() {
        Basket basket = new Basket();
        basket.putItems(ItemName.BREAD, 2);
        basket.putItems(ItemName.SOUP, 1);
        Bread bread=new Bread() ;
        BigDecimal price = bread.calculatePrice(basket, ItemName.BREAD, LocalDateTime.now());

        assertThat(BigDecimal.valueOf(1.6), Matchers.comparesEqualTo(price));
    }
}
