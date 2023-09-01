package admin;

import java.util.List;
import java.util.Scanner;

import lib.Menu;
import lib.Utils;

public class Foods {
	static List<Menu> foods = Menu.foodList;

	public static void main(String[] args) {
		Utils.clearScreen();
		Scanner scanner = new Scanner(System.in);
		int option;
		System.out.println("All foods\n");
		
		System.out.printf("%-3s %-15s %s%n", "ID", "Name", "Price");
		
		for (Menu food : foods) {
			// ERROR: The field Menu.Food.id is not visible
			System.out.printf(Utils.FORMAT, food.id, food.name, food.price);
		}
		
		System.out.println("\nOptions:");
		System.out.println("[1] - Add new");
		System.out.println("[2] - Edit food");
		System.out.println("[3] - Delete food");
		System.out.println("[4] - Back");
		System.out.print("Choose:");
		option =  scanner.nextInt();
		
		switch (option) {
		case 1: 
			AddFood.main(args);
			break;
		case 2: 
			EditFood.main(args);
			break;
		case 3: 
			DeleteFood.main(args);
			break;
		case 4: 
			Admin.main(args);
			break;
		default: break;
		}

	}

}
