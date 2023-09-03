package lib;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// todo learn hasmap
// code improvement -> chatgpt (Java Tuts)

public class Order {
	 public int id;
	 public String name;
	 public int quantity;
	 public int total;
	 public Date createdAt;
	 public int price;

     public Order(int id, String name, int quantity, int price) {
         this.id = id;
         this.name = name;
         this.quantity = quantity;
         this.price = price;
         this.total = price * quantity;
         this.createdAt = new Date();
     }


    public static List<Order> foodList = new ArrayList<>();
    public static void addFood(int id, String name, int quantity, int price) {
    	boolean isExist = false;
    	
    	for (Order food : foodList) {
    		if (food.id == id) {
    			isExist = true;
    			food.quantity += quantity;
    			food.total += (food.quantity + quantity) * food.price;
    			break;
    		}
    	}
    	
    	if (!isExist) {
    		foodList.add(new Order(id, name, quantity, price));
    	}
    	
    }
    
    public static int overallSales() {
    	int total = 0;
    	
    	for (Order food : foodList) {
    		total += food.price;
    	}
    	
    	return total;
    }
    
    public static int getAverageSales() {
    	int average = 0;
    	
    	int total = overallSales();	
    	average = total / foodList.size();
    	
    	return average;
    }
    
}
