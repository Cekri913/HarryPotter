package code;
import lombok.Data;

import java.util.Random;


//attributs du personnage
@Data
public class Wizard {
    private String name;

    public static int getHealth() {
        return health;
    }
    public static int health = 100;
    private boolean inDefense;
    private Pets pet;

    public static Core getCore() {
        return core;
    }
    private static Core core;
    private Wand wand;
    private Random rand;
    private long spellDamage;

    // private long spellStrength;
    private House house;
    // private Potion potion;

    public static int getSpellAmplitude() {
        return spellAmplitude;
    }

    public static int spellAmplitude = 15;

    private String [] houses = { "SLYTHERIN", "HUFFLEPUFF", "GRYFFINDOR", "RAVENCLAW"};


    // Constructor
    public Wizard(String name) { //, int health, Pets pet, Wand wand, House house) {
        this.name = name;
        this.health = 100;
        this.house  = new House(SortingHat.assignHouse());
        this.inDefense = false;
    }

    public void setPet(Pets pet) {
        this.pet = pet;
    }

    public void equipWand(Wand wand) {
        this.wand = wand;
    }

    public boolean IsAlive(){
        return this.health > 0;
    }

    public void calculateDamage(int damage) {
        if (inDefense == true) {
            // Réduire les dégâts d'un certain coefficient si le joueur est en défense
            int coef  =(int) (Math.random()*5) + 1;
            damage = damage / coef;
        }
        this.health -= damage;
    }
    public void increaseHealth(double amount) {
        this.health *= amount;
    }
    public void increaseDamage(double amount) {
        this.spellAmplitude *= amount;
    }

   public void attack(Enemy enemy) {
       int damage = (int) (Math.random() * spellAmplitude);
       if (damage == 0) {
           System.out.println("You missed your spell...");
       } else {
           enemy.calculateDamage(damage);
           System.out.println(Constant.customDisplayText(Constant.BOLD_TEXT,"You have inflicted " + damage + " of damages to " + enemy.getName(), Constant.GREEN));
       }
   }

    public void defend(Enemy enemy) {
        this.inDefense = true;
        enemy.attack(this);
    }

    public void assignHouse(SortingHat sortingHat) {
        this.house = house;
    }
}



