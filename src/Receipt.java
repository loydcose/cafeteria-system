import java.util.Date;
import java.util.List;

import lib.Order;
import lib.Utils;

public class Receipt {
	static List<Order> foodList = Order.foodList;
	
	
	public static void main(String[] args) {	
		System.out.println("Receipt Page\n");
		System.out.printf("%-3s %-15s %-12s %s%n", "ID", "Name", "Quantity", "Total");
		
		for (Order food : foodList) {
			System.out.printf("%-3d %-15s %-12d %d%n", food.id, food.name, food.quantity, food.total);
		}
		
		Date lastCreatedOrder = foodList.get(foodList.size() - 1).createdAt;
		
		System.out.printf("\nOVERALL TOTAL: %d", countOverallTotal());
		System.out.printf("\nOrder at: %s %s%n", Utils.toDate(lastCreatedOrder), Utils.toTime(lastCreatedOrder));
		
		Utils.confirm("Thank you for your order!");
		Main.main(args);
		
	}
	
	static int countOverallTotal() {
		int total = 0;
		
		for (Order food : foodList) {
			total += food.total;
		}
		
		return total;
	}

}
