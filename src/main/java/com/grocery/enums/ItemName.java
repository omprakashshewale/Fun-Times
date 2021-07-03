package com.grocery.enums;

import java.math.BigDecimal;

import com.grocery.calculation.Apple;
import com.grocery.calculation.Bread;
import com.grocery.calculation.OffersAvailable;

public enum ItemName {

	MILK(BigDecimal.valueOf(1.3), new OffersAvailable() {
	}), SOUP(BigDecimal.valueOf(0.65), new OffersAvailable() {
	}), APPLE(BigDecimal.valueOf(0.1), new Apple()), BREAD(BigDecimal.valueOf(0.8), new Bread());

	private final BigDecimal price;
	private final OffersAvailable offer;

	ItemName(BigDecimal price, OffersAvailable offer) {
		this.price = price;
		this.offer = offer;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public OffersAvailable getOffer() {
		return offer;
	}
}
