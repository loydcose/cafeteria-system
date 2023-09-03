import java.util.Scanner;

import lib.Utils;
import lib.Menu;
import lib.Order;

import java.util.ArrayList;
import java.util.List;


public class Food {
	static List<Menu> foods = Menu.foodList;

	public static void main(String[] args) {
		Utils.clearScreen();
		Scanner scanner = new Scanner(System.in);
		int foodOption;
		int quantity;
		boolean hasMore;
		
		System.out.println("Food Menu\n");
//		System.out.printf("%-3s %-15s %s%n", "ID", "Name", "Price");
		
//		for (Menu food : foods) {
//			// ERROR: The field Menu.Food.id is not visible
//			System.out.printf(Utils.FORMAT, food.id, food.name, food.price);
//		}
//		
		Utils.foodTable(foods);
		
		System.out.print("\nChoose your food (Id): ");
		foodOption =  scanner.nextInt();
		
		System.out.print("Quantity: ");
		quantity =  scanner.nextInt();
		
		System.out.print("Choose more? (y/n): ");
		hasMore = scanner.next().equalsIgnoreCase("y");
		
		// save to variable
		Menu foundFood = Utils.findFoodById(foodOption, foods);
		Order.addFood(foundFood.id, foundFood.name, quantity, foundFood.price);
//		System.out.println(foundFood.name);
		if (hasMore) {
			main(args);
		} else {
			Receipt.main(args);
		};
		
		
	}
	

	

}
