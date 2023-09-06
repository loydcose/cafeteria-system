

import java.util.Scanner;
import lib.Menu;
import lib.Utils;

import java.util.ArrayList;
import java.util.List;

public class DeleteFood {

	public static void main(String[] args) {
		List<Menu> foodList = Menu.foodList;
		Scanner scanner = new Scanner(System.in);
		int foodId;
		String foodName;
		int price;
		boolean isGood;
		
		System.out.print("Choose food id to delete: ");
		foodId = scanner.nextInt();
		
		Utils.foodTable(Utils.toSingleItemArray(foodId, foodList));
		
		// display table
		
		// about to delete, then table
		System.out.print("Are you sure you want to remove this? (y/n): ");
		isGood =  scanner.next().equalsIgnoreCase("y");
		
		if (isGood) {
			// remove the food
			int foodIndex = Utils.findIndexById(foodId, foodList);
			foodList.remove(foodIndex);
			
			Utils.confirm("Food Deleted!");
			Foods.main(args);
		} else {
			// dont remove 
			Foods.main(args);
		}
	}

}
