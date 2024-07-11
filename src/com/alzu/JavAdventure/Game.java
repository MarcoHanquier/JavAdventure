import java.util.Scanner;
import java.lang.Math;

public class Game {

    public static Player currentPlayer;
    public static Monster currentMonster;

    public static void startGame() {
        World.createWorld();
        createPlayer();

        choice();
    }

    private static void choice() {
        printHeaderInterface();
        System.out.println("Faites un choix : -Explorer -Combattre -Soigner");
        Scanner input = new Scanner(System.in);
        String choice = input.next();
        switch (choice) {
            case "Explorer":
                explore();
                break;
            case "Combattre":
            if (currentPlayer.getCurrentLocation().hasMonsters()) {
                spawnMonster();
                fight();
            } else System.out.println("Il ne semble pas y avoir de monstres dans les parages...");
                break;
            case "Soigner":
                heal();
                break;
            default:
                System.out.println("Faites un choix valide");
                break;
        }
        choice();

    }

    private static void explore() {
        System.out.println("Faites un choix : -Nord -Sud -Est -Ouest");
        Scanner input = new Scanner(System.in);
        String choice = input.next();
        switch (choice) {
            case "Nord":
                currentPlayer.MoveNorth();
                System.out.println("Vous arrivez dans le lieu : " + currentPlayer.getCurrentLocation().getName());
                break;
            case "Sud":
                currentPlayer.MoveSouth();
                System.out.println("Vous arrivez dans le lieu : " + currentPlayer.getCurrentLocation().getName());
                break;
            case "Est":
                currentPlayer.MoveEast();
                System.out.println("Vous arrivez dans le lieu : " + currentPlayer.getCurrentLocation().getName());
                break;
            case "Ouest":
                currentPlayer.MoveWest();
                System.out.println("Vous arrivez dans le lieu : " + currentPlayer.getCurrentLocation().getName());
                break;
            default:
                System.out.println("Faites un choix valide");
                break;
        }

    }

    private static void spawnMonster() {
        currentMonster = Monster.monsters[randomRoll(Monster.monsters.length) - 1];
        currentMonster.setCurrentHP(currentMonster.getMaxHP());
        System.out.println("Vous rencontrez un " + currentMonster.getName() + " !");
    }

    private static void fight() {

        while (currentPlayer.getCurrentHP() > 0) {
            printHeaderInterface();
            System.out.println("Faites un choix : -Attaquer -Soigner -Fuir");
            Scanner input = new Scanner(System.in);
            String choice = input.next();
            switch (choice) {
                case "Attaquer":
                    playerAttack();
                    break;
                case "Soigner":
                    heal();
                    monsterAttack();
                    break;
                case "Fuir":
                    System.out.println("Vous fuyez le combat !");
                    choice();
                    break;
                default:
                    System.out.println("Faites un choix valide");
                    break;
            }
        }
        gameOver();
    }

    private static void playerAttack() {
        int damage = currentPlayer.getCurrentWeapon().getAttack();
        if (randomRoll(100) <= 20) {
            damage = damage * 2;
            System.out.println("Coup critique !");
        }
        currentMonster.setCurrentHP(currentMonster.getCurrentHP() - damage);
        System.out.println("Vous faites " + damage + " dégats ! ");
        if (currentMonster.getCurrentHP() <= 0) {
            victory();
        } else
            monsterAttack();
    }

    private static void monsterAttack() {
        int damage = currentMonster.getDamage() - currentPlayer.getCurrentArmor().getDefense();
        if (damage < 0) {
            damage = 0;
        }
        currentPlayer.setCurrentHP(currentPlayer.getCurrentHP() - damage);
        System.out.println("Vous subissez " + damage + " dégats ! ");
    }

    private static void victory() {
        System.out.println("Le monstre est vaincu !");
        calculateDrop();
        System.out.println("Vous gagnez " + currentMonster.getGivenMoney() + " golds !");
        System.out.println("Vous gagnez " + currentMonster.getGivenXP() + " XP !");
        currentPlayer.setMoney(currentMonster.getGivenMoney());
        currentPlayer.setCurrentXP(currentPlayer.getCurrentXP() + currentMonster.getGivenXP());
        if (currentPlayer.getCurrentXP() >= 100) {
            levelUp();
        }
        choice();
    }

    private static void levelUp() {
        int remainingXP = currentPlayer.getCurrentXP() - 100;
        currentPlayer.setLevel(currentPlayer.getLevel() + 1);
        currentPlayer.setCurrentXP(remainingXP);
        currentPlayer.setMaxHP(currentPlayer.getMaxHP() + 10);
    }

    private static void createPlayer() {
        Scanner input = new Scanner(System.in);
        System.out.println("Entrez votre nom");
        String name = input.next();
        currentPlayer = new Player(1, name, 100, 100, 1, 0, 100, Weapon.axe, Armor.steelArmor, Potion.commonPotion,
                Location.home);
        currentPlayer.getCurrentPotion().setQuantity(3);
    }

    private static void printHeaderInterface() {
        System.out.println();
        System.out.println();
        System.out.println("Nom : " + currentPlayer.getName()
                + " - Niveau : " + currentPlayer.getLevel() + " (" + currentPlayer.getCurrentXP() + "/100 xp)"
                + " - PV : " + currentPlayer.getCurrentHP()
                + " - Arme : " + currentPlayer.getCurrentWeapon().getName()
                + " - Lieu : " + currentPlayer.getCurrentLocation().getName()
                + " - Potions : " + currentPlayer.getCurrentPotion().getQuantity());
    }

    private static void gameOver() {
        System.out.println("Fin de la partie !");
    }

    private static void heal() {
        if (currentPlayer.getCurrentPotion().getQuantity() > 0) {
            currentPlayer.getCurrentPotion().setQuantity(currentPlayer.getCurrentPotion().getQuantity() - 1);
            currentPlayer.usePotion();
            System.out.println("Vous récupérez " + currentPlayer.getCurrentPotion().getGivenHP() + " pv !");
        } else {
            System.out.println("Vous n'avez plus de potions !");
        }
    }

    private static int randomRoll(int max) {
        int min = 1;
        int range = max - min + 1;

        int rollResult = (int) (Math.random() * range) + min;
        System.out.println("roll : " + rollResult);

        return rollResult;
    }

    private static void calculateDrop() {

        if (randomRoll(100) <= currentMonster.getCommonDropRate()) {
            System.out.println("Le monstre a lâché un(e) " + currentMonster.getCommonDrop().getName() + " !");
        }
        if (randomRoll(100) <= currentMonster.getRareDropRate()) {
            currentPlayer.getCurrentPotion().setQuantity(currentPlayer.getCurrentPotion().getQuantity() + 1);
            System.out.println("Le monstre a lâché un(e) " + currentMonster.getRareDrop().getName() + " !");

        }
    }

}
