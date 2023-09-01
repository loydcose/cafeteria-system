import java.util.ArrayList;
import java.util.List;

public class Order {
    public static class Food {
        int id;
        String name;
        int quantity;
        int total;

        public Food(int id, String name, int quantity, int price) {
            this.id = id;
            this.name = name;
            this.quantity = quantity;
            this.total = price * quantity;
        }
     
    }

    public static class Drink {
        int id;
        String name;
        int quantity;
        int total;
        
        public Drink(int id, String name, int quantity, int price) {
            this.id = id;
            this.name = name;
            this.quantity = quantity;
            this.total = price * quantity;
        }
    }

    public static List<Food> foodList = new ArrayList<>();
    static void addFood(int id, String name, int quantity, int price) {
    	// if id is already at the foodlist, just add the quantity
    	
        foodList.add(new Food(id, name, quantity, price));
    }

    public static List<Drink> drinkList = new ArrayList<>();
    static void addDrinks(int id, String name, int quantity, int price) {
    	drinkList.add(new Drink(id, name, quantity, price));
    }
}
