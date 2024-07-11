public class Weapon extends Item {

    private int attack;
    public static Weapon basicSword;
    public static Weapon axe;
    public static Weapon spear;

    public Weapon(int id, String name, int quantity, int attack) {
        super(id, name, quantity);
        this.attack = attack;
    }

    public int getAttack() {
        return this.attack;
    }
    
    public void setAttack(int attack) {
        this.attack = attack;
    }

}