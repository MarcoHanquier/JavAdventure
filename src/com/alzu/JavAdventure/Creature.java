public class Creature {
    
    private int id;
    private String name;
    private int maxHp;
    private int currentHp;

public Creature(int id, String name, int maxHp, int currentHp) {
    this.id = id;
    this.name = name;
    this.maxHp = maxHp;
    this.currentHp = currentHp;
}

public int getID() {
    return this.id;
}

public String getName() {
    return this.name;
}

public void setName(String name) {
    this.name = name;
}

public  int getMaxHP() {
    return maxHp;
}

public  void setMaxHP(int maxHp) {
    this.maxHp = maxHp;
}

public  int getCurrentHP() {
    return currentHp;
}

public  void setCurrentHP(int currentHp) {
    this.currentHp = currentHp;
}

}
