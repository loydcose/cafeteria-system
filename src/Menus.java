import java.util.Scanner;

import lib.Utils;
import lib.Menu;
import lib.Order;

import java.util.ArrayList;
import java.util.List;


public class Menus {
	static List<Menu> foods = Menu.foodList;
	static List<Order> orders = Order.orders;
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		Utils.clearScreen();
		int orderId = orders.size() + 1;
		int option;
		
		System.out.println("Food Menu\n");
		Utils.foodTable(foods);
			
		System.out.println("[1] - Order Food");
		System.out.println("[2] - Back");
		System.out.print("Choose: ");
		option = scanner.nextInt();		
		
		switch(option) {
		case 1: choose(args, orderId);
		break;
		default: Main.main(args);
		}
	}
	
	public static void choose(String[] args, int orderId) {
		
		int foodOption;
		int quantity;
		boolean hasMore;
		
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
