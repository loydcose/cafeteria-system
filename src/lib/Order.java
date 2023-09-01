package lib;
import java.util.ArrayList;
import java.util.List;

public class Order {
	 public int id;
	 public String name;
	 public int quantity;
	 public int total;

     public Order(int id, String name, int quantity, int price) {
         this.id = id;
         this.name = name;
         this.quantity = quantity;
         this.total = price * quantity;
     }


    public static List<Order> foodList = new ArrayList<>();
    public static void addFood(int id, String name, int quantity, int price) {
    	// if id is already at the foodlist, just add the quantity
    	
        foodList.add(new Order(id, name, quantity, price));
    }
}
