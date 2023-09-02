import java.util.Scanner;
import lib.Utils;


public class Admin {
	public static void main(String[] args) {
		Utils.clearScreen();
		Scanner scanner = new Scanner(System.in);
		int option;
		System.out.println("Admin dashboard\n");
		
		System.out.println("Select one of the options:");
		System.out.println("[1] - See all foods");
		System.out.println("[2] - Analytics");
		System.out.println("[3] - Back");
		
		System.out.print("Choose: ");
		option =  scanner.nextInt();
		
		switch (option) {
		case 1: 
			Foods.main(args);
			break;
		case 2: 
			Analytics.main(args);
			break;
		case 3: 
			Main.main(args);
			break;
		default: break;
		}

	}

}
