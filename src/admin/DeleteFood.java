package admin;

import java.util.Scanner;

public class DeleteFood {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int foodId;
		String foodName;
		int price;
		boolean isGood;
		System.out.println("Edit food\n");
		
		System.out.print("Choose food id: ");
		foodId = scanner.nextInt();
		
		// about to delete, then table
		System.out.print("Are you sure you want to delete that? (y/n)");
		isGood =  scanner.next().equalsIgnoreCase("y");
	}

}
