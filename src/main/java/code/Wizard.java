package code;
import lombok.Data;

import java.util.Random;
import java.util.Scanner;


//attributs du personnage
@Data
public class Wizard {
    private String name;
    public long health = 10;
    private Pets pet;
    private Wand wand;
    private Random rand;
    private long spellDamage;
    private long spellStrength;
    private House house;
    private Potion potion;

    private final int spellAmplitude = 15;

    private String [] houses = { "SLYTHERIN", "HUFFLEPUFF", "GRYFFINDOR", "RAVENCLAW"};


    // Constructor
    public Wizard(String name) { //, int health, Pets pet, Wand wand, House house) {
        this.name = name;
        this.health = health;
        this.house  = new House(SortingHat.assignHouse());
    }



    public static void choosePet() {
        for (Pets pet : Pets.values()) {
            System.out.println(pet);
        }
        Scanner sc = new Scanner(System.in);
        String answer = sc.nextLine();
        while (!Pets.contains(answer)) {
            System.out.println("The name isn't in the list");
            answer = sc.nextLine();
        }
        Pets.valueOf(answer);
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

    public void takeDamage(int damage) {
        health -= damage;
    }
    public void increaseHealth(int amount) {
        this.health += amount;
    }
    public void increaseDamage(int amount) {
        this.spellDamage += amount;
    }

    public void attack(long enemyDamage) {
        double ale = Math.random() * spellAmplitude;
        long spellStrength= Math.round(ale);
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



