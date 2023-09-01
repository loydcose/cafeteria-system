import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


public class Food {
	static List<Menu.Food> foods = Menu.foodList;

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int foodOption;
		int quantity;
		boolean hasMore;
		boolean switchToDrinks;
		
		System.out.println("Food Menu\n");
		System.out.printf("%-3s %-15s %s%n", "ID", "Name", "Price");
		
		for (Menu.Food food : foods) {
			System.out.printf(FormattingUtils.FORMAT, food.id, food.name, food.price);
		}
		
		System.out.print("\nChoose your food (Id): ");
		foodOption =  scanner.nextInt();
		
		System.out.print("Quantity: ");
		quantity =  scanner.nextInt();
		
		System.out.print("Choose more? (y/n): ");
		hasMore = scanner.next().equalsIgnoreCase("y");
		
		if (hasMore) {
			Menu.Food foundFood = findFoodById(foodOption);
			Order.addFood(foundFood.id, foundFood.name, quantity, foundFood.price);
			
			// restart this page
			// Clear the console by printing empty lines
			main(args);
		} else {
			// save the food attributes that user choosed in a variable
			System.out.print("How about drinks? (y/n): ");
			switchToDrinks = scanner.next().equalsIgnoreCase("y");

			if (switchToDrinks) {
				Drinks drinks = new Drinks();
				drinks.main(args);
			}
		}
		
		
	}
	
	// todo sa drinks kana
	
	static Menu.Food findFoodById(int foodId) {
		Menu.Food foundFood = null;
		
		for (Menu.Food food : foods) {
			if (food.id == foodId) {
				foundFood = food;
				break;
			}
		}
		
		return foundFood;
	}
	

}
