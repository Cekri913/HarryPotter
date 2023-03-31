package code;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;
@Getter @Setter
public class Enemy {

    // Attributs
    public String name;
    public int damage;
    public int health;


    // Constructeur
    public Enemy(String name, int health) {
        this.name = name;
        this.health = health;
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
            if(level.getNumber() == 4 ){
                damage *= 2;
                System.out.println("Petter Pettigrew and Voldemort has inflicted you "  + damage + " of damage.");
            }
            if(level.getNumber() ==  7){
                damage *= 2.5;
                System.out.println("Bellatrix Lesange and Voldemort has inflicted you " + damage + " of damage.");
            }else {
                System.out.println(Constant.customDisplayText(Constant.RED, name + " has inflicted you " + damage + " of damage."));
                System.out.println("damage après atténuation de " + name + " : " + damage);
            }
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



