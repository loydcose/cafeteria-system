package lib;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;



public class Utils {
	static Scanner scanner = new Scanner(System.in);
	
    public static final String FORMAT = "%-3d | %-15s | %d | %n";
    
    static void printTableLines(int[] arr) {
    	for (int i = 0; i < arr.length; i++) {
    		System.out.print("+");
         	System.out.print(String.join("", Collections.nCopies(arr[i] + 2, "-")));
    	}
     	System.out.print("+");
     	System.out.println();
    }
    
    public static void foodTable(List<Menu> foods) {
    	
    	String[] columns = {"Id", "Name", "Price"};
    	int[] columnLengths = new int[columns.length];
    	for (int i = 0; i < columns.length; i++) {
    		columnLengths[i] = columns[i].length();
    	}
    	
    	
    	for (int i = 0; i < foods.size(); i++) {
    		if (columnLengths[0] < Integer.toString(foods.get(i).id).length()) {
    			columnLengths[0] = Integer.toString(foods.get(i).id).length();
    		}
    		if (columnLengths[1] < foods.get(i).name.length()) {
    			columnLengths[1] = foods.get(i).name.length();
    		}
    		if (columnLengths[2] < Integer.toString(foods.get(i).price).length()) {
    			columnLengths[2] = Integer.toString(foods.get(i).price).length();
    		}
    	}
    	
    	String columnStrFormat = "| %-" + columnLengths[0] + "s | %-" + columnLengths[1] + "s | %-" + columnLengths[2] + "s |%n";
    	String strFormat = "| %-" + columnLengths[0] + "d | %-" + columnLengths[1] + "s | %-" + columnLengths[2] + "d |%n";
    	
    	printTableLines(columnLengths);
     	System.out.printf(columnStrFormat, columns[0], columns[1], columns[2]);
     	printTableLines(columnLengths);
    	
    	for (Menu food : foods) {
			System.out.printf(strFormat, food.id, food.name, food.price);
			printTableLines(columnLengths);
		}
    }
    
    public static void receiptTable(List<Food> foods) {
    	
    	String[] columns = {"Id", "Name", "Quantity", "Total"};
    	int[] columnLengths = new int[columns.length];
    	for (int i = 0; i < columns.length; i++) {
    		columnLengths[i] = columns[i].length();
    	}
    	
    	
    	for (int i = 0; i < foods.size(); i++) {
    		if (columnLengths[0] < Integer.toString(foods.get(i).id).length()) {
    			columnLengths[0] = Integer.toString(foods.get(i).id).length();
    		}
    		if (columnLengths[1] < foods.get(i).name.length()) {
    			columnLengths[1] = foods.get(i).name.length();
    		}
    		if (columnLengths[2] < Integer.toString(foods.get(i).quantity).length()) {
    			columnLengths[2] = Integer.toString(foods.get(i).quantity).length();
    		}
    		if (columnLengths[3] < Integer.toString(foods.get(i).total).length()) {
    			columnLengths[3] = Integer.toString(foods.get(i).total).length();
    		}
    	}
    	
    	String columnStrFormat = "| %-" + columnLengths[0] + "s | %-" + columnLengths[1] + "s | %-" + columnLengths[2] + "s | %-" + columnLengths[3] + "s |%n";
    	String strFormat = "| %-" + columnLengths[0] + "d | %-" + columnLengths[1] + "s | %-" + columnLengths[2] + "d | %-" + columnLengths[3] + "d |%n";
    	
    	printTableLines(columnLengths);
     	System.out.printf(columnStrFormat, columns[0], columns[1], columns[2], columns[3]);
     	printTableLines(columnLengths);
    	
    	for (Food food : foods) {
			System.out.printf(strFormat, food.id, food.name, food.quantity, food.total);
			printTableLines(columnLengths);
		}
    }
    
    public static void analyticsTable(List<Order> orders) {
    	
    	String[] columns = {"Id", "Date", "Time", "Name", "Qty", "Prc"};
    	int[] columnLengths = new int[columns.length];
    	for (int i = 0; i < columns.length; i++) {
    		columnLengths[i] = columns[i].length();
    	}
    	
    	for (Order order : orders) {
    		for (int i = 0; i < order.foods.size(); i++) {
        		if (columnLengths[0] < Integer.toString(order.foods.get(i).id).length()) {
        			columnLengths[0] = Integer.toString(order.foods.get(i).id).length();
        		}
        		if (columnLengths[1] < toDate(order.createdAt).length()) {
        			columnLengths[1] = toDate(order.createdAt).length();
        		}
        		if (columnLengths[2] < toTime(order.createdAt).length()) {
        			columnLengths[2] = toTime(order.createdAt).length();
        		}
        		if (columnLengths[3] < order.foods.get(i).name.length()) {
        			columnLengths[3] = order.foods.get(i).name.length();
        		}
        		if (columnLengths[4] < Integer.toString(order.foods.get(i).quantity).length()) {
        			columnLengths[5] = Integer.toString(order.foods.get(i).quantity).length();
        		}
        		if (columnLengths[5] < Integer.toString(order.foods.get(i).price).length()) {
        			columnLengths[5] = Integer.toString(order.foods.get(i).price).length();
        		}
        	}
    	}
    	
    	
    	String columnStrFormat = "| %-" + columnLengths[0] + "s | %-" + columnLengths[1] + "s | %-" +columnLengths[2]+ "s | %-" + columnLengths[3] + "s | %-" + columnLengths[4] + "s | %-" + columnLengths[5] + "s |%n";
    	String strFormat = "| %-" + columnLengths[0] + "d | %-" + columnLengths[1] + "s | %-" + columnLengths[2] + "s | %-" + columnLengths[3] + "s | %-" + columnLengths[4] + "d | %-" + columnLengths[5] + "d |%n";
    	
    	printTableLines(columnLengths);
     	System.out.printf(columnStrFormat, columns[0], columns[1], columns[2], columns[3], columns[4], columns[5]);
     	printTableLines(columnLengths);
    	
     	for (Order order : orders) {
     		for (Food food : order.foods) {
     			System.out.printf(strFormat, food.id, toDate(order.createdAt), toTime(order.createdAt), food.name, food.quantity, food.price);
     			printTableLines(columnLengths);
     		}
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
	
	public static Order findOrderById(int orderId) {
		List<Order> orders = Order.orders;
		Order foundOrder = null;
		
		for (Order order : orders) {
			if (order.id == orderId) {
				foundOrder = order;
			}
		}
		
		return foundOrder;
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
//	    String chosenColor = color == null ? "yellow" : color;
	    String decoratedString;

	    switch(color) {
	        case "red":
	            decoratedString = "\u001B[31m" + str + "\u001B[0m";
	            break;
	        case "green":
	            decoratedString = "\u001B[32m" + str + "\u001B[0m"; 
	            break;
	        case "blue":
	            decoratedString = "\u001B[34m" + str + "\u001B[0m"; 
	            break;
	        case "purple":
	            decoratedString = "\u001B[35m" + str + "\u001B[0m"; 
	            break;
	        case "cyan":
	            decoratedString = "\u001B[36m" + str + "\u001B[0m"; 
	            break;
	        default:
	            decoratedString = "\u001B[33m" + str + "\u001B[0m"; 
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
