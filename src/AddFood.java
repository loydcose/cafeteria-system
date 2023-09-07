

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import lib.Menu;
import lib.Utils;

public class AddFood {

	public static void main(String[] args) {
		Utils.clearScreen();
		List<Menu> foodList = Menu.foodList;
		Scanner scanner = new Scanner(System.in);
		String foodName;
		int price;
		
		System.out.println(Utils.decorateText("--- Add food ---", "yellow"));
		
		while (true) {
			System.out.print("Food name: ");
			String foodNameInput = scanner.nextLine();
			if (!foodNameInput.isEmpty()) {
				foodName = foodNameInput;
				break;
			} else {
				System.out.println(Utils.decorateText("String must not be empty.", "red"));
			}
		}
		
		while (true) {
			System.out.print("Price: ");
			if (scanner.hasNextInt()) {
				price = scanner.nextInt();
				break;
			} else {
				System.out.println(Utils.decorateText("Must be a number.", "red"));
				scanner.nextLine();
			}
		}
		scanner.nextLine();
		
		
		// save
		foodList.add(new Menu(foodList.size() + 1, foodName, price));
		
		List<Menu> foundFoods = Utils.toSingleItemArray(foodList.size(), foodList);
		
		// display with utils
		Utils.foodTable(foundFoods);
		
		System.out.print("Is this good ok? (Y/n): ");
		String input = scanner.nextLine().trim();
		
		if (input.isEmpty() || !input.equalsIgnoreCase("n")) {
			Utils.confirm("Food Added!");
			Foods.main(args);
		} else {
			EditFood.main2(foodList.size());
			Utils.confirm("Food Added!");
			Foods.main(args);
		}
		
	}

}
