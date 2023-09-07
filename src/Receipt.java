import java.util.Date;
import java.util.List;
import java.util.Scanner;

import lib.Food;
import lib.Order;
import lib.Utils;

public class Receipt {
	static List<Order> orders = Order.orders;
	
	public static void main(String[] args, int orderId) {	
		Utils.clearScreen();
		Scanner scanner = new Scanner(System.in);
		System.out.println(Utils.decorateText("--- Receipt ---", "yellow"));
		Order foundOrder = Utils.findOrderById(orderId);
		
		if (foundOrder != null) {
			Utils.receiptTable(foundOrder.foods);
			
			System.out.printf("Order at: %s %s", Utils.toDate(foundOrder.createdAt), Utils.toTime(foundOrder.createdAt));
			System.out.printf("\nOverall Total: %d", countOverallTotal(foundOrder.foods));
			
			Utils.confirm("\nThank you for your order!");
			scanner.nextLine();
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
