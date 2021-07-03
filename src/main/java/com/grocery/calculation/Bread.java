package com.grocery.calculation;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.Map;
import java.util.Optional;

import com.grocery.enums.ItemName;
import com.grocery.utils.Utils;

public class Bread implements OffersAvailable {

	private static final BigDecimal NO_OF_ITEMS = BigDecimal.valueOf(2);

	@Override
	public BigDecimal calculatePrice(Basket basket, ItemName item, LocalDateTime time) {
		if (!basket.getItems().containsKey(item)) {
			return BigDecimal.ZERO;
		}
		boolean offerValid = checkOffer(time);
		if (offerValid) {
			Integer offer = getItems(basket.getItems(), item);

			BigDecimal discount = item.getPrice().divide(NO_OF_ITEMS, BigDecimal.ROUND_HALF_UP)
					.multiply(BigDecimal.valueOf(offer));

			Integer b = basket.getItems().get(item) - offer;
			if (b > 0) {
				return discount.add(item.getPrice().multiply(BigDecimal.valueOf(b)));
			} else {
				return discount;
			}
		}
		return item.getPrice().multiply(BigDecimal.valueOf(basket.getItems().get(item)));
	}

	private boolean checkOffer(LocalDateTime time) {

		LocalDateTime startDate = LocalDateTime.now().minusDays(1);
		LocalDateTime endDate = LocalDateTime.now().plusDays(7);

		boolean result = Utils.checkOfferValidity(startDate, endDate, time);

		return result;
	}

	private Integer getItems(Map<ItemName, Integer> items, ItemName item) {

		return Math.min(items.get(item), Optional.ofNullable(items.get(ItemName.SOUP)).orElse(0) / 2);
	}

}
