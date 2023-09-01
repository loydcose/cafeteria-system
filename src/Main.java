import java.util.Scanner;
import admin.Admin;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int option;
		System.out.println("Hello, welcome to cafeteria\n");
		
		System.out.println("Select one of the options:");
		System.out.println("[1] - Menu");
		System.out.println("[2] - Admin");
		System.out.println("[3] - Exit");
		
		System.out.print("Choose: ");
		option =  scanner.nextInt();
		
		// enter password first to enter admin.
		
		switch (option) {
		case 1: 
			Food food = new Food();
			food.main(args);
			break;
		case 2: 
			Admin.main(args);
			break;
		default: break;
		}
		
	}
}
