import lib.Order;
import lib.Utils;

import java.util.List;
import java.util.Scanner;

public class Analytics {

	public static void main(String[] args) {
		Utils.clearScreen();
		Scanner scanner = new Scanner(System.in);
		List<Order> foodList = Order.foodList;
		int option;
		
		
		System.out.println("Analytics");
		
		
		System.out.println("\nAverage sales: " + Order.getAverageSales());
		System.out.println("\nSales:");
		
		
		System.out.printf("%-3s %-6s %-6s %-10s %-4s %-4s %n", "ID", "Date", "Time", "Name", "Qty", "Prc");
		for (Order food : foodList) {
			System.out.printf("%-3d %-6s %-6s %-10s %-4d %-4d %n", food.id, Utils.toDate(food.createdAt), Utils.toTime(food.createdAt), food.name, food.quantity, food.total);
		}
		
		System.out.println("\nTotal sales: " + Order.overallSales());
		
		
		System.out.println("\nChoose one of the options:");
		System.out.println("[1] Back");
		System.out.println("Choose: ");
		option = scanner.nextInt();
		
	}
}
