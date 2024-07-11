
public class World {

    public static void createWorld() {
        createItems();
        createPotions();
        createWeapons();
        createArmors();
        createMonsters();
        createLocations();
    }

    private static void createPotions(){
        Potion.commonPotion = new Potion(1, "Potion basique", 0, 30);
        Potion.rarePotion = new Potion(2, "Potion rare", 0, 50);
        Potion.legendaryPotion = new Potion(3, "Potion légendaire", 0, 999);
    }

    private static void createMonsters() {
        Monster.rat = new Monster(1, "Rat", 20, 20, 10, 10, 10, Item.ratTail, 75, Potion.commonPotion, 10);
        Monster.skeleton = new Monster(2, "Squelette", 30, 30, 30, 30, 30, Item.bone, 80, Potion.rarePotion, 5);
        Monster.wolf = new Monster(3, "Loup", 50, 50, 50, 70, 50, Item.wolfPelt, 60, Potion.legendaryPotion, 2);
        Monster[] monsters = {Monster.rat, Monster.skeleton, Monster.wolf};
        Monster.monsters = monsters;
    }

    private static void createWeapons(){
        Weapon.basicSword = new Weapon(1, "Epée basique", 1, 10);
        Weapon.axe = new Weapon(2, "Hache", 0, 30);
        Weapon.spear = new Weapon(3, "Lance", 0, 50);
    }

    private static void createArmors(){
        Armor.leatherArmor = new Armor(1, "Armure de cuir", 1, 10);
        Armor.steelArmor = new Armor(2, "Armure d'acier", 0, 30);
        Armor.plateArmor = new Armor(3, "Armure de plaques", 0, 50);
    }

    private static void createItems(){
        Item.ratTail = new Item(1, "Queue de rat", 1);
        Item.bone = new Item(2, "Os", 1);
        Item.wolfPelt = new Item(3, "Peau de loup", 1);
    }

    private static void createLocations(){
        Location.home = new Location(1, "Maison", "Votre maison.", false);
        Location.forest = new Location(2, "Forêt", "Une forêt tranquille.", true);
        Location.city = new Location(3, "Ville", "La capitale du Royaume.", false);
        Location.hut = new Location(4, "Hutte", "Une hutte.", false);

        Location.home.locationNorth = Location.forest;

        Location.forest.locationNorth = Location.city;
        Location.forest.locationEast = Location.hut;
        Location.forest.locationSouth = Location.home;

        Location.hut.locationWest = Location.forest;

        Location.city.locationSouth = Location.forest;
    }

}
