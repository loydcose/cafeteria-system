package lib;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// code improvement -> chatgpt (Java Tuts)


public class Order {
	 public int id;
	 public Date createdAt;
	 public List<Food> foods;
	 
     public Order(int id) {
         this.id = id;
         this.foods = new ArrayList<>();
         this.createdAt = new Date();
     }

    public static List<Order> orders = new ArrayList<>();
    
    public static void addOrder(int orderId, int id, String name, int quantity, int price) {
    	
    	// add food if id already exists
    	for (Order order : orders) {
    		if (order.id == orderId) {
    			boolean isExist = false;
    	    	for (Food foodItem : order.foods) {
    	    		// check if food id has already been added
    	    		if (foodItem.id == id) {
    	    			isExist = true;
    	    			foodItem.quantity += quantity;
    	    			foodItem.total += (foodItem.quantity + quantity) * foodItem.price;
    	    			break;
    	    		}
    	    	}
    	    	if (!isExist) {
    	    		order.foods.add(new Food(id, name, quantity, price));
    	    	}
    	    	return;
    		}
    	}
    	
    	// if id isn't present to orders, add new
    	Order newOrder = new Order(orderId);
    	Food newFood = new Food(id, name, quantity, price);
    	newOrder.foods.add(newFood);
    	orders.add(newOrder);
    	
    }
    
    
    // calculates total sales and average sales
    public static int[] sales() {
    	int total = 0;
    	int items = 0;
    	
    	for (Order order : orders) {
    		for (Food food : order.foods) {
    			items += food.quantity;
    			total += food.total;
    		}
    	}
    	
    	int[] result = {total, total > 0 ? total / items : 0};
    	
    	return result;
    }
}
