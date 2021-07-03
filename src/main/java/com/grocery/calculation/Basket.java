package com.grocery.calculation;

import java.util.EnumMap;
import java.util.Map;

import com.grocery.enums.ItemName;

public class Basket {
	
	   private final EnumMap<ItemName, Integer> itemDetails = new EnumMap<>(ItemName.class);

    public void putItems(ItemName items, Integer noOfItems) {

        if (itemDetails.containsKey(items)) {
        	itemDetails.put(items, noOfItems + getItems().get(items));
        } else {
        	itemDetails.put(items, noOfItems);
        }

    }

    public Map<ItemName, Integer> getItems() {
        return itemDetails;
    }

}
