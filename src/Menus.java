import java.util.Scanner;

import lib.Utils;
import lib.Menu;
import lib.Order;

import java.util.ArrayList;
import java.util.List;


public class Menus {
	static List<Menu> foods = Menu.foodList;
	static List<Order> orders = Order.orders;
	
	public static void main(String[] args) {
		 int orderId = orders.size() + 1;
		choose(args, orderId);
	}
	
	public static void choose(String[] args, int orderId) {
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
		
		Order.addOrder(orderId, foundFood.id, foundFood.name, quantity, foundFood.price);
//		System.out.println(foundFood.name);
		
		if (hasMore) {
			Menus.choose(args, orderId);
		} else {
			Receipt.main(args, orderId);
		};
	}
	
	
	

	

}
