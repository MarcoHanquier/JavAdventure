
public class Monster extends Creature{

    private int damage;
    private int givenXP;
    private int givenMoney;
    private Item commonDrop;
    private int commonDropRate;
    private Item rareDrop;
    private int rareDropRate;
    public static Monster rat;
    public static Monster skeleton;
    public static Monster wolf;
    public static Monster currentMonster;
    public static Monster[] monsters;



    public Monster(int id, String name, int maxHp, int currentHp, int damage, int givenXP, int givenMoney, Item commonDrop, int commonDropRate, Item rareDrop, int rareDropRate) {
        super(id, name, maxHp, currentHp);
        this.damage = damage;
        this.givenXP = givenXP;
        this.givenMoney = givenMoney;
        this.commonDrop = commonDrop;
        this.commonDropRate = commonDropRate;
        this.rareDrop = rareDrop;
        this.rareDropRate = rareDropRate;
    }

    public int getDamage() {
        return this.damage;
    }

    public int getGivenXP() {
        return this.givenXP;
    }

    public int getGivenMoney() {
        return this.givenMoney;
    }

    public Item getCommonDrop() {
        return this.commonDrop;
    }

    public int getCommonDropRate() {
        return this.commonDropRate;
    }

    public Item getRareDrop() {
        return this.rareDrop;
    }

    public int getRareDropRate() {
        return this.rareDropRate;
    }


}
