import java.util.Scanner;

import lib.Utils;

public class Main {
	
	public static void main(String[] args) {
		Utils.clearScreen();
		Scanner scanner = new Scanner(System.in);
		System.out.println(Utils.decorateText("--- Cafeteria System ---", "yellow"));
		
		System.out.println("Select one of the options:");
		System.out.println("[1] - Menu");
		System.out.println("[2] - Admin");
		System.out.println("[3] - Exit");
		
		int option = Utils.getInputInt("Choose: ", 1, 3);
		
		switch (option) {
		case 1: 
			Menus.main(args);
			break;
		case 2: 
			System.out.print("Enter password: ");
			boolean isPasswordCorrect = scanner.next().equals("admin");
			if (isPasswordCorrect) {
				Admin.main(args);
			} else {
				System.out.println("Wrong password");
				Main.main(args);
			}
			
			break;
		default: break;
		}

	}
}
