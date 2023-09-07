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
		
		System.out.println(Utils.decorateText("--- Menu ---", "yellow"));
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
		
		System.out.print("Choose your food (Id): ");
		foodOption =  scanner.nextInt();
		
		System.out.print("Quantity: ");
		quantity =  scanner.nextInt();
		scanner.nextLine();
		
		System.out.print("Choose more? (y/N): ");
		String input = scanner.nextLine().trim();
		
		Menu foundFood = Utils.findFoodById(foodOption, foods);
		Order.addOrder(orderId, foundFood.id, foundFood.name, quantity, foundFood.price);
		
		if (input.isEmpty() || !input.equalsIgnoreCase("y")) {
			Receipt.main(args, orderId);
		} else {
			Menus.choose(args, orderId);
		}
	}

}
