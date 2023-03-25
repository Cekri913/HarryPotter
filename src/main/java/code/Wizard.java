package code;
import java.util.ArrayList;
import java.util.Scanner;

//attributs du personnage
public class Wizard {
    private String name;
    public long  health = 100;
    private Pets pet;
    private Wand wand;
    private long spellDamage;
    private long spellStrength;
    private String house;
    private Potion potion;

    private final int spellAmplitude = 15;

    // Constructeur
    public Wizard(String name){ //, int health, Pets pet, Wand wand, House house) {
        this.name = name;
        this.health = health;

    }


    // Getters
    public String getName() {
        return name;
    }
    public long getSpellDamage() {
        return spellDamage;
    }

    public Pets getPet() {
        return pet;
    }

    public long getHealth() {
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


    public static Pets choosePet(){
        System.out.println("Which pet do you want?");
        for(Pets pet: Pets.values()){
            System.out.println(pet);
        }
        Scanner sc = new Scanner(System.in);
        String answer = sc.nextLine();
        while(!Pets.contains(answer)){
            System.out.println("The name isn't in the list");
            answer = sc.nextLine();
        }
        return Pets.valueOf(answer);
    }

    public void setPet(Pets pet) {
        this.pet = pet;
    }

    public void equipWand(Wand wand) {
        this.wand = wand;
    }

    public void assignHouse(SortingHat sortingHat) {
        this.house = sortingHat.assignHouse();
    }

    public boolean IsAlive(){
        return this.health > 0;
    }
    public void increaseHealth(int amount) {
        this.health += amount;
    }
    public void increaseDamage(int amount) {
        this.spellDamage += amount;
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


    public void attack(long enemyDamage long spellStrength) {
        double ale = Math.random() * spellAmplitude;
        spellStrength= Math.round(ale);
        System.out.println(spellStrength);
        if (spellStrength == 0) {
            System.out.println("You failed your spell....");

        } else {

        }
        health = health - enemyDamage;
    }

    public void defend() {
        System.out.println("");

    }
    }



