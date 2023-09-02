package lib;
import java.util.ArrayList;
import java.util.List;

public class Menu {    
    public int id;
    public String name;
    public int price;

    public Menu(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // Declare food items directly in the Menu class
    public static List<Menu> foodList = new ArrayList<>();
    static {
    	
        foodList.add(new Menu(foodList.size() + 1, "Sinigang sa miso", 60));
        foodList.add(new Menu(foodList.size() + 1, "Sinigang", 60));
        foodList.add(new Menu(foodList.size() + 1, "Longsilog", 45));
        foodList.add(new Menu(foodList.size() + 1, "Tosilog", 40));
        
        foodList.add(new Menu(foodList.size() + 1, "Pepsi", 15));
        foodList.add(new Menu(foodList.size() + 1, "Coke", 22));
        foodList.add(new Menu(foodList.size() + 1, "Cobra", 18));
        foodList.add(new Menu(foodList.size() + 1, "Sprite", 20));
    }
}
