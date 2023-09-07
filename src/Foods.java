

import java.util.List;
import java.util.Scanner;

import lib.Menu;
import lib.Utils;

public class Foods {
	static List<Menu> foods = Menu.foodList;

	public static void main(String[] args) {
		Utils.clearScreen();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println(Utils.decorateText("--- All foods ---", "yellow"));
		Utils.foodTable(foods);
		
		System.out.println("Options:");
		System.out.println("[1] - Add new");
		System.out.println("[2] - Edit food");
		System.out.println("[3] - Delete food");
		System.out.println("[4] - Back");
		
		int option = Utils.getInputInt("Choose: ", 1, 4);	
		System.out.print("Choose: ");
		
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
