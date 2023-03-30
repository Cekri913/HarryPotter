package code;
import lombok.Data;

import java.util.Objects;
import java.util.Random;


//attributs du personnage
@Data
public class Wizard {
    private String name;

    public int x;
    public int y;
    public static int health = 40;
    private boolean inDefense;
    private Pets pet;
    private static Core core;
    private Wand wand;
    private Random rand;
    public House house;
    public static int spellAmplitude = 10;

    // Constructor
    public Wizard(String name) { //, int health, Pets pet, Wand wand, House house) {
        this.name = name;
        this.health = 40;
        this.house  = new House(SortingHat.assignHouse());
        this.inDefense = false;
    }
    // getters

    public static int getHealth() {
        return health;
    }
    public static int getSpellAmplitude() {
        return spellAmplitude;
    }
    public static Core getCore() {
        return core;
    }

    //setters

    public void setPet(Pets pet) {
        this.pet = pet;
    }
    public void equipWand(Wand wand) {
        this.wand = wand;
    }
    public boolean IsAlive(){
        return this.health > 0;
    }
    public void increaseHealth(double amount) {
        this.health *= amount;
    }
    public void increaseDamage(double amount) {
        this.spellAmplitude *= amount;
    }
    public void assignHouse(SortingHat sortingHat) {
        this.house = house;
    }
    // Méthodes
    public void calculateDamage(int damage) {
        if (inDefense) {
            // Réduire les dégâts d'un certain coefficient si le joueur est en défense
            int coef  =(int) (Math.random()*5) + 1;
            damage = damage / coef;
        }
        this.health -= damage;
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

}



