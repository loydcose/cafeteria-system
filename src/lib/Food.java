package lib;

public class Food {
	public int id;
	 public String name;
	 public int quantity;
	 public int total;
	 public int price;
	 
    public Food(int id, String name, int quantity, int price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.total = price * quantity;
    }	
}
