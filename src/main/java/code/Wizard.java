package code;
import java.util.ArrayList;

//attributs du personnage
public class Wizard {
    private String name;
    private int niv;
    public int  health;
    private int damage;
    private Pets pet;
    private Wand wand;
    private String house;
    ArrayList<String> knownSpells = new ArrayList<>();
    ArrayList<String> potions = new ArrayList<>();

    // Constructeur
    public Wizard(String name, Wand wand, House house, Pets pet) {
        this.name = name;
        this.health = 200;
        this.damage = 20;
    }

    // Getters
    public String getName() {
        return name;
    }

    public Pets getPet() {
        return pet;
    }

    public int getNiv() {
        return niv;
    }

    public int getHealth() {
        return health;
    }

    public Wand getWand() {
        return wand;
    }

    public String getHouse() {
        return house;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setHealth() {
        this.health = health;
    }
    // Méthodes

    public void equipWand(Wand wand) {
        this.wand = wand;
    }

    public void assignHouse(SortingHat sortingHat) {
        this.house = sortingHat.assignHouse();
    }

    public void fight(Wizard wizard, Enemy enemy){
        System.out.println("The fight has begun ....");
    }
    public boolean IsAlive(){
        return this.health > 0;
    }
    public void increaseHealth(int amount) {
        this.health += amount;
    }
    public void increaseDamage(int amount) {
        this.damage += amount;
    }
    public double getSpellDamageMultiplier() {
        if (this.house.equals("Slytherin")) {
            return 1.2;
        } else {
            return 1.0;
        }
    }
    public double getPotionEffectivenessMultiplier() {
        if (this.house.equals("Hufflepuff")) {
            return 1.2;
        } else {
            return 1.0;
        }
    }
        public double getDamageResistance () {
            if (this.house.equals("Gryffindor")) {
                return 0.8;
            } else {
                return 1.0;
            }
        }
        public double getSpellAccuracy () {
            if (this.house.equals("Ravenclaw")) {
                return 1.2;
            } else {
                return 1.0;

            }
        }
    }



