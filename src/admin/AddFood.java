package admin;

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
		boolean isGood;
		String foodName;
		int price;
		
		System.out.println("Add food\n");
		
		System.out.print("Food name: ");
		foodName = scanner.next();
		
		System.out.print("Price: ");
		price = scanner.nextInt();
		
		// save
		foodList.add(new Menu(foodList.size() + 1, foodName, price));
		
		List<Menu> foundFoods = Utils.toSingleItemArray(foodList.size(), foodList);

		
		// display with utils
		Utils.foodTable(foundFoods);
		

		System.out.print("Are this good ok? (y/n): ");
		isGood =  scanner.next().equalsIgnoreCase("y");
		
		if (isGood) {
			Foods.main(args);
		} else {
			EditFood.main2(foodList.size());
			System.out.println("\nFood Added!");
			System.out.println("Press enter to continue...");
			scanner.nextLine();
			scanner.nextLine();
			Foods.main(args);
		}
		
		
		// n - go to edit page
		// y - go back
		
	}

}
