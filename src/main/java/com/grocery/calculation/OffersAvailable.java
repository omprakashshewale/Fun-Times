package com.grocery.calculation;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.grocery.enums.ItemName;

public interface OffersAvailable {

    default BigDecimal calculatePrice(Basket basket, ItemName items, LocalDateTime date) {
    	BigDecimal result=BigDecimal.ZERO;
    	result=items.getPrice().multiply(BigDecimal.valueOf(basket.getItems().get(items)));
        return result;
    }
}
