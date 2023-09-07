

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
		System.out.println(Utils.decorateText("--- Edit food ---", "yellow"));
		Utils.foodTable(foodList);
		
		foodId = Utils.getInputInt("Choose food id to edit: ", 1, foodList.size());	
		
		main2(foodId);
		Utils.confirm("Food Updated!");
		Foods.main(args);
	}
	
	
	public static void main2(int foodId) {
		// find food by id
		Menu foundFood = Utils.findFoodById(foodId);
					
		System.out.printf("Change name (%s): ", foundFood.name);
		String foodNameInput = scanner.nextLine().trim();
		foodName = foodNameInput.isEmpty() ? foundFood.name : foodNameInput;
					
		System.out.printf("Change price (%d): ", foundFood.price);
		String foodPriceInput = scanner.nextLine().trim();
		price = foodPriceInput.isEmpty() ? foundFood.price : Integer.parseInt(foodPriceInput);
					
		// find indexById
		int foodIndex = Utils.findIndexById(foodId, foodList);
					
		// update with array list set
		foodList.set(foodIndex, new Menu(foodId, foodName, price));
		List<Menu> foundFoods = Utils.toSingleItemArray(foodId, foodList);
		System.out.println();
		
		// display with utils
		Utils.foodTable(foundFoods);
					
		// save 
		// print the result
		System.out.print("Is this good ok? (Y/n): ");
		String input = scanner.nextLine().trim();
		
		if (!input.isEmpty() && input.equalsIgnoreCase("n")) {
			main2(foodId);
		}
	}
}
