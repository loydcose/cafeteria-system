import java.util.List;

import lib.Order;

public class Receipt {
	static List<Order> foodList = Order.foodList;
	
	
	public static void main(String[] args) {	
		System.out.println("Receipt Page\n");
		System.out.printf("%-3s %-15s %-12s %s%n", "ID", "Name", "Quantity", "Total");
		
		for (Order food : foodList) {
			System.out.printf("%-3d %-15s %-12d %d%n", food.id, food.name, food.quantity, food.total);
		}
		
		System.out.printf("\nOVERALL TOTAL: %d", countOverallTotal());
		System.out.println("\nThank you for your order!");
		
	}
	
	static int countOverallTotal() {
		int total = 0;
		
		for (Order food : foodList) {
			total += food.total;
		}
		
		return total;
	}

}
