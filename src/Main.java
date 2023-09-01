import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int option;
		System.out.println("Hello, welcome to cafeteria\n");
		
		System.out.println("Select one of the options:");
		System.out.println("[1] - Menu");
		System.out.println("[2] - Exit");
		
		System.out.print("Choose: ");
		option =  scanner.nextInt();
		
		switch (option) {
		case 1: 
			Food food = new Food();
			food.main(args);
			break;
		default: break;
		}
		
	}
}
