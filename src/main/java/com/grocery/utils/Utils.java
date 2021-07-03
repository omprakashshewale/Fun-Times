package com.grocery.utils;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.EnumMap;
import java.util.Map;
import java.util.Map.Entry;

import com.grocery.calculation.Basket;
import com.grocery.calculation.OffersAvailable;
import com.grocery.enums.ItemName;

public final class Utils {

	
	private Utils() {
		throw new IllegalStateException("Utility class");
	}

	public static BigDecimal calculateBillAmount(Basket basket, LocalDateTime date) {

		BigDecimal amount = BigDecimal.ZERO;
	
		amount = basket.getItems().keySet().stream().map(a -> a.getOffer().calculatePrice(basket, a, date))
				.reduce(BigDecimal.ZERO, BigDecimal::add);

		return amount;
	}

	public static boolean checkOfferValidity(LocalDateTime startDate, LocalDateTime endDate,
			LocalDateTime purchaseDate) {
		Boolean status = false;
		if ((purchaseDate.isAfter(startDate) || purchaseDate.isEqual(startDate))
				&& (purchaseDate.isBefore(endDate) || purchaseDate.isEqual(endDate))) {
			status = true;
		} 
		
		return status;
		
	}

}
