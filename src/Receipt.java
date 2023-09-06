import java.util.Date;
import java.util.List;

import lib.Food;
import lib.Order;
import lib.Utils;

public class Receipt {
	static List<Order> orders = Order.orders;
	
	public static void main(String[] args, int orderId) {	
		Utils.clearScreen();
		System.out.println("Receipt Page\n");
		System.out.printf("%-3s %-15s %-12s %s%n", "ID", "Name", "Quantity", "Total");
		
		Order foundOrder = Utils.findOrderById(orderId);
		
		if (foundOrder != null) {
			for (Food food : foundOrder.foods) {
				System.out.printf("%-3d %-15s %-12d %d%n", food.id, food.name, food.quantity, food.total);
			}
			
			System.out.printf("\nOVERALL TOTAL: %d", countOverallTotal(foundOrder.foods));
			System.out.printf("\nOrder at: %s %s%n", Utils.toDate(foundOrder.createdAt), Utils.toTime(foundOrder.createdAt));
			
			Utils.confirm("Thank you for your order!");
			Main.main(args);
		} else {
			Utils.confirm("No date to be shown");
			Main.main(args);
		}
		
	}
	
	static int countOverallTotal(List<Food> foods) {
		int total = 0;
		
		for (Food food : foods) {
			total += food.total;
		}
		
		return total;
	}

}
