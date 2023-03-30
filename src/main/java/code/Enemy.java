package code;

import lombok.Data;
import lombok.Getter;

import java.util.Random;
@Getter
public class Enemy {

    // Attributs
    public String name;
    public int x;
    public int damage;
    public int y;
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


    public void attack(Wizard wizard, Level level ) {
        if (!this.IsAlive()) {
            System.out.println(Constant.customDisplayText(Constant.GREEN,"Congratulation " + wizard.getName() + ", " + "you just killed " + name));
            level.end(wizard, this);
        } else{
            Random r = new Random();
        damage = r.nextInt(10, 16);
        wizard.calculateDamage(damage);
        System.out.println(Constant.customDisplayText(Constant.RED, name + " has inflicted you " + damage + " of damage"));
        System.out.println("damage après atténuation de " + name + " : " + damage);
    }

    }
    // La méthode prendreDegats permet de réduire les points de vie du troll lorsqu’il est touché par un objet.
    public void calculateDamage(int damage) {
        this.health -= damage;
    }
    public boolean IsAlive(){
        return this.health > 0;
    }

}



