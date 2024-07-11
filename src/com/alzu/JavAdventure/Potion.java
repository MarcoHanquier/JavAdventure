public class Potion extends Item {

    private int givenHP;
    public static Potion commonPotion;
    public static Potion rarePotion;
    public static Potion legendaryPotion;

    public Potion(int id, String name, int quantity, int givenHP) {
        super(id, name, quantity);
        this.givenHP = givenHP;
    }

    public int getGivenHP() {
        return this.givenHP;
    }
    
    public void setGivenHP(int givenHP) {
        this.givenHP = givenHP;
    }

}
