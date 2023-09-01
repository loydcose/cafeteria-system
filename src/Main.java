import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int option;
		// TODO Auto-generated method stub
		System.out.println("Hello, welcome to cafeteria\n");
		
		
		System.out.println("Select one of the options:");
		System.out.println("[1] - Food");
		System.out.println("[2] - Drinks");
		System.out.println("[3] - Exit");
		
		System.out.print("Choose: ");
		option =  scanner.nextInt();
		
		switch (option) {
		case 1: 
			Food food = new Food();
			food.main(args);
			break;
		case 2: 
			Drinks drinks = new Drinks();
			drinks.main(args);
			break;
//		case 3:
//			Receipt receipt = new Receipt();
//			receipt.main(args);
//			break;
		default: break;
		}
		
	}
}
