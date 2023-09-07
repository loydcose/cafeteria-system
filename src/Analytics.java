import lib.Food;
import lib.Order;
import lib.Utils;

import java.util.List;
import java.util.Scanner;

public class Analytics {

	public static void main(String[] args) {
		Utils.clearScreen();
		Scanner scanner = new Scanner(System.in);
//		List<Order> foodList = Order.foodList;
		int[] sales = Order.sales();
		int totalSales = sales[0];
		int averageSales = sales[1];
		int option;
		
		
		
		System.out.println(Utils.decorateText("--- Analytics ---", "yellow"));
		
		if (Order.orders.isEmpty()) {
			System.out.println("No data to be displayed");
		} else {
			System.out.println("Average sales: " + averageSales);
			
			Utils.analyticsTable(Order.orders);
//			System.out.printf("%-3s %-6s %-6s %-10s %-4s %-4s %n", "ID", "Date", "Time", "Name", "Qty", "Prc");
//			
//			for (Order order : Order.orders) {
//				for (Food food : order.foods) {
//					System.out.printf("%-3d %-6s %-6s %-10s %-4d %-4d %n", food.id, Utils.toDate(order.createdAt), Utils.toTime(order.createdAt), food.name, food.quantity, food.total);
//				}
//			}
			
			System.out.println("Total sales: " + totalSales);
		}
		
		
		System.out.println("\nChoose one of the options:");
		System.out.println("[1] - Back");
		System.out.print("Choose: ");
		option = scanner.nextInt();
		
		if (option == 1) {
			Admin.main(args);
		}
		
	}
}
