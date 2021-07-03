package com.grocery;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.grocery.calculation.Basket;
import com.grocery.enums.ItemName;
import com.grocery.utils.Utils;

@SpringBootApplication
public class Application {

	private static final Logger LOGGER = Logger.getLogger(Application.class.getName());

	public static void main(String[] args) {

		Basket basket = new Basket();
		Scanner sc = new Scanner(System.in);

		LOGGER.info("Soup Tin: ");
		basket.putItems(ItemName.SOUP, sc.nextInt());

		LOGGER.info("bread loafs: ");
		basket.putItems(ItemName.BREAD, sc.nextInt());

		LOGGER.info("Milk Bottles: ");
		basket.putItems(ItemName.MILK, sc.nextInt());

		LOGGER.info("Apples: ");
		basket.putItems(ItemName.APPLE, sc.nextInt());

		LOGGER.info("Items Added successfully to cart");
		
		LOGGER.info("Enter purchase Date: ");
		Scanner sc1 = new Scanner(System.in);
		String date=sc1.nextLine();

	
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDateTime dateTime = LocalDate.parse(date, formatter).atStartOfDay();
		
		basket.getItems().forEach((item, quantity) -> displayBill(item, basket));

		System.out.printf("Total Bill:  "+ Utils.calculateBillAmount(basket, dateTime));
	}

	private static void displayBill(ItemName item, Basket basket) {

		
		System.out.println( basket.getItems().get(item)+"  "+ item.name()+"    =    "+
				item.getOffer().calculatePrice(basket, item, LocalDateTime.now()));
	}
}