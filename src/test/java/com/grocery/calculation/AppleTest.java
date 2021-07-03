package com.grocery.calculation;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

import org.hamcrest.Matchers;
import org.junit.BeforeClass;
import org.junit.Test;

import com.grocery.enums.ItemName;

public class AppleTest {




	@Test
	public void amountForNoApple() {
		Basket basket = new Basket();
		basket.putItems(ItemName.BREAD, 1);
		Apple apple=new Apple();
		BigDecimal price = apple.calculatePrice(basket, ItemName.APPLE, LocalDateTime.now().plusDays(5));

		assertThat(BigDecimal.ZERO, Matchers.comparesEqualTo(price));
	}


	@Test
	public void dateIsNotValid() {
		Basket basket = new Basket();
		basket.putItems(ItemName.APPLE,3);

		Apple apple=new Apple();
		BigDecimal price = apple.calculatePrice(basket, ItemName.APPLE, LocalDateTime.now());

		assertThat(BigDecimal.valueOf(0.3), Matchers.comparesEqualTo(price));
	}

	
	@Test
	public void dateIsValid() {
		Basket basket = new Basket();
		basket.putItems(ItemName.APPLE, 4);
		Apple apple=new Apple();
		BigDecimal price =apple.calculatePrice(basket, ItemName.APPLE, LocalDateTime.now().plusDays(5));

		assertThat(BigDecimal.valueOf(0.36), Matchers.comparesEqualTo(price));
	}



}
