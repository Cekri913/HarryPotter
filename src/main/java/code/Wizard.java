package code;
import lombok.Data;
import lombok.Getter;

import java.util.Objects;
import java.util.Random;


//attributs du personnage
@Data @Getter
public class Wizard {
    private String name;

    public int x;
    public int y;
    public int health;
    private boolean inDefense;
    private Pets pet;
    private static Core core;
    private Wand wand;
    private Random rand;
    public House house;
    public static int spellAmplitude = 15;

    // Constructor
    public Wizard(String name) { //, int health, Pets pet, Wand wand, House house) {
        this.name = name;
        this.health = 40;
        this.house  = new House(SortingHat.assignHouse());
        this.inDefense = false;
    }
    // getters

    public int getHealth() {
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
        System.out.println("indefense wizard = " + inDefense );
        if (inDefense) {
            // Réduire les dégâts d'un certain coefficient si le joueur est en défense
            Random rand = new Random();
            int  coef = rand.nextInt(1,4);
            damage = damage / coef;
            System.out.println("coefficient d'atténuation = " + coef);
            System.out.println("damage in defense après atténuation de " + damage);
        }
        

        health -= damage;
    }

   public void attack(Enemy enemy) {
       Random r = new Random();
       int damage = r.nextInt(16);
       if (damage == 0) {
           System.out.println("You missed your spell...");
       } else {
           enemy.calculateDamage(damage);
           System.out.println(Constant.customDisplayText(Constant.BOLD_TEXT,"You have inflicted " + damage + " of damages to " + enemy.getName(), Constant.GREEN));
       }
   }

    public void defend(Enemy enemy, Level level) {
        this.inDefense = true;
        enemy.attack(this, level);
    }

}



