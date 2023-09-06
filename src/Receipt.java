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
		Order foundOrder = Utils.findOrderById(orderId);
		
		if (foundOrder != null) {
			Utils.receiptTable(foundOrder.foods);
			
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
