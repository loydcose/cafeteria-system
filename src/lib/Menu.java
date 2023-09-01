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
        foodList.add(new Menu(1, "Adobo", 100));
        foodList.add(new Menu(2, "Sinigang", 120));
    }
}
