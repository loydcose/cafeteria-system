

import java.util.List;
import java.util.Scanner;
import lib.Menu;
import lib.Utils;

public class EditFood {
	static List<Menu> foodList = Menu.foodList;
	static Scanner scanner = new Scanner(System.in);
	static int foodId;
	static String foodName;
	static int price;
	static boolean isGood = false;

	public static void main(String[] args) {
		Utils.clearScreen();
		System.out.println("Edit food\n");
		System.out.print("Choose food id: ");
		foodId = scanner.nextInt();
		
		
		main2(foodId);
		System.out.println("\nFood Updated!");
		System.out.println("Press enter to continue...");
		scanner.nextLine();
		scanner.nextLine();
		Foods.main(args);
	}
	
	
	public static void main2(int foodId) {
		// find food by id
					Menu foundFood = Utils.findFoodById(foodId);
					
					System.out.printf("Change name (%s): ", foundFood.name);
					foodName = scanner.next();
					
					System.out.printf("Change price (%d): ", foundFood.price);
					price = scanner.nextInt();
					
					// find indexById
					int foodIndex = Utils.findIndexById(foodId, foodList);
					
					// update with array list set
					foodList.set(foodIndex, new Menu(foodId, foodName, price));
					List<Menu> foundFoods = Utils.toSingleItemArray(foodId, foodList);

							
					// display with utils
					Utils.foodTable(foundFoods);
					
					
					// save 
					// print the result
					// then ask this
					System.out.print("\nAre this good ok? (y/n)");
					isGood =  scanner.next().equalsIgnoreCase("y");
					if (!isGood) main2(foodId);
	}
}
