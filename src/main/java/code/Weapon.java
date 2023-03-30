package code;

import java.util.Random;

public class Weapon {
    private String name;
    private int weight;
    private boolean isLifted;

/*
    public Weapon(String name) {
        this.name = name;
        this.isLifted = false;
    }

    public void lift() {
        this.isLifted = true;a
    }

    // La méthode relacher permet de relâcher l’objet sur la tête du troll, ce qui réduit ses points de vie en fonction du poids de l’objet.
    public void release(Enemy enemy) {
        if (this.isLifted){
           Random r = new Random();
           int weight = r.nextInt(10); // [0 9]
            enemy.calculateDamage(weight);
            this.isLifted = true;
        }
    }*/
}
