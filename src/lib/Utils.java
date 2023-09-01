package lib;
import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static final String FORMAT = "%-3d %-15s %d%n";
    
    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    
    public static void foodTable(List<Menu> foods) {
    	   System.out.println("ID\t\tName\t\tPrice");
    		for (Menu food : foods) {
    			// ERROR: The field Menu.Food.id is not visible
    			System.out.printf(Utils.FORMAT, food.id, food.name, food.price);
    		}
    }
    
    // since methods in java can't have default values.
    public static Menu findFoodById(int foodId) {
        return findFoodById(foodId, Menu.foodList);
    }
    
	public static Menu findFoodById(int foodId, List<Menu> foods) {
		Menu foundFood = null;
		
		for (Menu food : foods) {
			if (food.id == foodId) {
				foundFood = food;
				break;
			}
		}
		
		return foundFood;
	}
	
	public static int findIndexById(int foodId, List<Menu> foods) {
		int foundIndex = -1;
		
		for (int i = 0; i < foods.size(); i++) {
			if (foods.get(i).id == foodId) {
				foundIndex = i;
				break;
			}
		}
		
		return foundIndex;
	}
	
	public static List<Menu> toSingleItemArray(int foodId, List<Menu> foodList) {
		List<Menu> foundFoods = new ArrayList<>();
		Menu foundFood = Utils.findFoodById(foodId, foodList);
		foundFoods.add(foundFood);
		
		return foundFoods;
	}
	
	public static void clearScreen() {  
	    System.out.print("\033[H\033[2J");  
	    System.out.flush();  
	}  
	
	
	
	
	
}
