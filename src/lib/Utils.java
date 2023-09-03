package lib;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Utils {
	static Scanner scanner = new Scanner(System.in);
	
    public static final String FORMAT = "%-3d | %-15s | %d | %n";
    
    public static void foodTable(List<Menu> foods) {
    	// todo make this code short. chatgpt = 
    	
    	String column1 = "ID";
    	String column2 = "Name";
    	String column3 = "Price";
    	
    	
    	int longestId = column1.length();
    	int longestName = column2.length();
    	int longestPrice = column3.length();
    	
    	for (int i = 0; i < foods.size(); i++) {
    		int strLength = Integer.toString(foods.get(i).id).length();
			if (strLength > longestId) {
				longestId = strLength;
			}
		}
    	
    	for (int i = 0; i < foods.size(); i++) {
    		int strLength = foods.get(i).name.length();
			if (strLength > longestName) {
				longestName = strLength;
			}
		}
    	
     	for (int i = 0; i < foods.size(); i++) {
    		int strLength = Integer.toString(foods.get(i).price).length();
			if (strLength > longestPrice) {
				longestPrice = strLength;
			}
		}
     	System.out.print("+");
     	System.out.print(String.join("", Collections.nCopies(longestId + 2, "-")));
     	System.out.print("+");
     	System.out.print(String.join("", Collections.nCopies(longestName + 2, "-")));
     	System.out.print("+");
     	System.out.print(String.join("", Collections.nCopies(longestPrice + 2, "-")));
     	System.out.print("+");
     	System.out.println();
     	
     	String columnStrFormat = "| %-" + longestId + "s | %-" + longestName + "s | %-" + longestPrice + "s |%n";
     	System.out.printf(columnStrFormat, column1, column2, column3);
     	
     	System.out.print("+");
     	System.out.print(String.join("", Collections.nCopies(longestId + 2, "-")));
     	System.out.print("+");
     	System.out.print(String.join("", Collections.nCopies(longestName + 2, "-")));
     	System.out.print("+");
     	System.out.print(String.join("", Collections.nCopies(longestPrice + 2, "-")));
     	System.out.print("+");
     	System.out.println();
     	
     	
     	
     	
     	
     	
     	
     	
     	
     	String strFormat = "| %-" + longestId + "d | %-" + longestName + "s | %-" + longestPrice + "d |%n";
     	
     	
    	for (Menu food : foods) {
    		
			System.out.printf(strFormat, food.id, food.name, food.price);
			System.out.print("+");
			System.out.print(String.join("", Collections.nCopies(longestId + 2, "-")));
	     	System.out.print("+");
	     	System.out.print(String.join("", Collections.nCopies(longestName + 2, "-")));
	     	System.out.print("+");
	     	System.out.print(String.join("", Collections.nCopies(longestPrice + 2, "-")));
	     	System.out.print("+");
	     	
	     	
	     	
	     	System.out.println();
			
		}
    	
    	
    
//    	   System.out.printf("%-3s %-15s %s%n", "ID", "Name", "Price");
//    		for (Menu food : foods) {
//    			// ERROR: The field Menu.Food.id is not visible
//    			System.out.printf(Utils.FORMAT, food.id, food.name, food.price);
//    		}
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
	
	public static List<Menu> toSingleItemArray(int foodId) {
		List<Menu> foodList = Menu.foodList; 
		List<Menu> foundFoods = new ArrayList<>();
		Menu foundFood = Utils.findFoodById(foodId, foodList);
		foundFoods.add(foundFood);
		
		return foundFoods;
	}
	
	
	public static void clearScreen() {  
	    System.out.print("\033[H\033[2J");  
	    System.out.flush();  
	}  
	
	
	public static void confirm(String message) {
		System.out.printf("\n%s", message);
		System.out.println("\nPress enter to continue...");
		scanner.nextLine();
//		scanner.nextLine();
	}
	
	public static String decorateText(String str, String color) {
		String chosenColor = color == null ? "yellow" : color;
		String decoratedString = "\u001B[33mYellow " + str;
		
		switch(chosenColor) {
		case "red": decoratedString = "\u001B[31mRed " + str;
			break;
		case "green": decoratedString = "\u001B[32mGreen " + str;
			break;
		case "blue": decoratedString = "\u001B[34mBlue " + str;
			break;
		case "purple": decoratedString = "\u001B[35mPurple " + str;
			break;
		case "cyan": decoratedString = "\u001B[36mCyanw " + str;
			break;
		default: decoratedString = "\u001B[33mYellow " + str;
		}
		
		return decoratedString;
	}
	
	public static String toDate(Date date) {
		 SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd");
		 String formattedDate = dateFormatter.format(date);
		 
		 return formattedDate;
	}
	
	public static String toTime(Date date) {
		 SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm");
		 String formattedTime = timeFormatter.format(date);
		 
		 return formattedTime;
	}
	
	
	

}
