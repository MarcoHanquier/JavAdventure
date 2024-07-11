public class Armor extends Item {

    private int defense;
    public static Armor leatherArmor;
    public static Armor steelArmor;
    public static Armor plateArmor;

    public Armor(int id, String name, int quantity, int defense) {
        super(id, name, quantity);
        this.defense = defense;
    }

    public int getDefense() {
        return this.defense;
    }
    
    public void setDefense(int defense) {
        this.defense = defense;
    }

}