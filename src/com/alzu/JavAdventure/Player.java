
public class Player extends Creature {

    private int level;
    private int currentXP;
    private int money;
    private Weapon currentWeapon;
    private Armor currentArmor;
    private Potion currentPotion;
    private Location currentLocation;
    public static Player currentPlayer;

    public Player(int id, String name, int maxHp, int currentHp, int level, int currentXP, int money,
            Weapon currentWeapon,
            Armor currentArmor, Potion currentPotion, Location currentLocation) {
        super(id, name, maxHp, currentHp);
        this.level = level;
        this.currentXP = currentXP;
        this.money = money;
        this.currentWeapon = currentWeapon;
        this.currentArmor = currentArmor;
        this.currentPotion = currentPotion;
        this.currentLocation = currentLocation;
    }

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getCurrentXP() {
        return this.currentXP;
    }

    public void setCurrentXP(int currentXP) {
        this.currentXP = currentXP;
    }

    public int getMoney() {
        return this.money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Weapon getCurrentWeapon() {
        return this.currentWeapon;
    }

    public void setCurrentWeapon(Weapon currentWeapon) {
        this.currentWeapon = currentWeapon;
    }

    public Armor getCurrentArmor() {
        return this.currentArmor;
    }

    public void setCurrentArmor(Armor currentArmor) {
        this.currentArmor = currentArmor;
    }

    public Potion getCurrentPotion() {
        return this.currentPotion;
    }

    public void setCurrentPotion(Potion currentPotion) {
        this.currentPotion = currentPotion;
    }

    public Location getCurrentLocation() {
        return this.currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    public Player getCurrentPlayer() {
        return Player.currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        Player.currentPlayer = currentPlayer;
    }

    public void usePotion() {

        if (Game.currentPlayer.getCurrentHP() + Game.currentPlayer.getCurrentPotion().getGivenHP() > Game.currentPlayer
                .getMaxHP()) {
            Game.currentPlayer.setCurrentHP(Game.currentPlayer.getMaxHP());
        } else
            Game.currentPlayer.setCurrentHP(
                    Game.currentPlayer.getCurrentHP() + Game.currentPlayer.getCurrentPotion().getGivenHP());

    }

    public void MoveNorth() {
        if (currentLocation.locationNorth != null) {
            currentLocation = currentLocation.locationNorth;
        } else {
            System.out.println("Pas de lieu à explorer dans cette direction !");
        }
    }

    public void MoveSouth() {
        if (currentLocation.locationSouth != null) {
            currentLocation = currentLocation.locationSouth;
        } else {
            System.out.println("Pas de lieu à explorer dans cette direction !");
        }
    }

    public void MoveEast() {
        if (currentLocation.locationEast != null) {
            currentLocation = currentLocation.locationEast;
        } else {
            System.out.println("Pas de lieu à explorer dans cette direction !");
        }
    }

    public void MoveWest() {
        if (currentLocation.locationWest != null) {
            currentLocation = currentLocation.locationWest;
        } else {
            System.out.println("Pas de lieu à explorer dans cette direction !");
        }
    }

}
