

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
		
		System.out.print("Choose food id to delete: ");
		foodId = scanner.nextInt();
		scanner.nextLine();
		
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
