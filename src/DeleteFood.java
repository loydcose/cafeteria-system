

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
		
		Utils.clearScreen();
		System.out.println(Utils.decorateText("--- Delete food ---", "yellow"));
		
		Utils.foodTable(foodList);
		
		foodId = Utils.getInputInt("Choose food id to delete: ", 1, foodList.size());	
		
		System.out.println();
		Utils.foodTable(Utils.toSingleItemArray(foodId, foodList));
		
		System.out.print("You sure you want to remove this? (y/N): ");
		String input = scanner.nextLine().trim();
		
		if (input.isEmpty() || !input.equalsIgnoreCase("y")) {
			Foods.main(args);
		} else {
			int foodIndex = Utils.findIndexById(foodId, foodList);
			foodList.remove(foodIndex);
			
			Utils.confirm("Food Deleted!");
			Foods.main(args);
		}
	}
}
