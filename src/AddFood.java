

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
		
		System.out.print("Food name: ");
		foodName = scanner.next();
		
		System.out.print("Price: ");
		price = scanner.nextInt();
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
