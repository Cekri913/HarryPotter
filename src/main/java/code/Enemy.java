package code;

import java.util.Random;

public class Enemy {

    // Attributs
    public String name;
    public int health;
    private Random rand;
    // rivate long damage;
    public int damageAmplitude = 15;

    // Constructeur
    public Enemy(String name, int health, int damageAmplitude) {
        this.name = name;
        this.health = health;
        rand = new Random();
        this.damageAmplitude = 15;
    }

    // getters

    public String getName() {
        return this.name;
    }


    public void attack(Wizard wizard) {
        int damage = (int) (Math.random() * damageAmplitude) + 1;
        wizard.calculateDamage(damage);
        System.out.println(Constant.customDisplayText(Constant.RED, name + " has inflicted you " + damage + " of damage"));
    }

    // La méthode prendreDegats permet de réduire les points de vie du troll lorsqu’il est touché par un objet.
    public void calculateDamage(int damage) {
        this.health -= damage;
    }
    public boolean IsAlive(){
        return this.health > 0;
    }



    //La méthode estVaincu renvoie true si les points de vie du troll sont à zéro ou en dessous.
    public boolean isDefeated(){
        return this.health <= 0;
    }
}



