package com.grocery.calculation;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hamcrest.Matchers;
import org.junit.BeforeClass;
import org.junit.Test;

import com.grocery.enums.ItemName;

public class OffersAvailableTest {

	private final OffersAvailable offer = new OffersAvailable() {
    };

    @Test
    public void price() {
        Basket basket = new Basket();
        basket.putItems(ItemName.SOUP, 10);

        BigDecimal price = offer.calculatePrice(basket,ItemName.SOUP, LocalDateTime.now());

        assertThat(BigDecimal.valueOf(6.50), Matchers.comparesEqualTo(price));
    }



}
