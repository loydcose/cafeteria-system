import java.util.ArrayList;
import java.util.List;

public class Menu {
    public static class Food {
        int id;
        String name;
        int price;

        public Food(int id, String name, int price) {
            this.id = id;
            this.name = name;
            this.price = price;
        }
     
    }

    public static class Drink {
        int id;
        String name;
        int price;

        public Drink(int id, String name, int price) {
            this.id = id;
            this.name = name;
            this.price = price;
        }
    }

    // Declare food items directly in the Menu class
    public static List<Food> foodList = new ArrayList<>();
    static {
        foodList.add(new Food(1, "Adobo", 100));
        foodList.add(new Food(2, "Sinigang", 120));
    }

    // Declare drink items directly in the Menu class
    public static List<Drink> drinkList = new ArrayList<>();
    static {
        drinkList.add(new Drink(1, "Palamig", 50));
        drinkList.add(new Drink(2, "Cold water", 35));
    }
}
