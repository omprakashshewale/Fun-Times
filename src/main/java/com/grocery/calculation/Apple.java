package com.grocery.calculation;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

import com.grocery.enums.ItemName;
import com.grocery.utils.Utils;

public class Apple implements OffersAvailable {

	private static final BigDecimal DISCOUNT_PERCENTAGE = BigDecimal.valueOf(0.1);

	@Override
	public BigDecimal calculatePrice(Basket basket, ItemName items, LocalDateTime time) {
		if (!basket.getItems().containsKey(items)) {
			return BigDecimal.ZERO;
		}

		BigDecimal discountPrice = checkAvailableOffers(time);

		BigDecimal result = items.getPrice().multiply(BigDecimal.valueOf(basket.getItems().get(items)))
				.multiply(discountPrice);

		return result;
	}

	private BigDecimal checkAvailableOffers(LocalDateTime currentdate) {

		LocalDateTime startDate = LocalDateTime.now().plusDays(3);
		LocalDateTime endDate = LocalDateTime.now().plusMonths(1).with(TemporalAdjusters.lastDayOfMonth());

		boolean validity = Utils.checkOfferValidity(startDate, endDate, currentdate);
		if (validity) {
			return BigDecimal.ONE.subtract(DISCOUNT_PERCENTAGE);

		} else {
			return BigDecimal.ONE;
		}

	}

}
