public class Item {
    
private int id;
private String name;
private int quantity;
public static Item ratTail;
public static Item bone;
public static Item wolfPelt;
public static Item commonPotion;

public Item(int id, String name, int quantity) {
        this.id = id;
        this.name = name;
        this.quantity = this.quantity+1;
    }

    public int getID() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

}
