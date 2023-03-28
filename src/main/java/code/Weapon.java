package code;

public class Weapon {
    private String name;
    private int weight;
    private boolean isLifted;


    public Weapon(String name, int weight) {
        this.name = name;
        this.weight = weight;
        this.isLifted = false;
    }

    public void lift() {
        this.isLifted = true;
    }

    // La méthode relacher permet de relâcher l’objet sur la tête du troll, ce qui réduit ses points de vie en fonction du poids de l’objet.
    public void release(Enemy enemy) {
        if (this.isLifted){
            enemy.calculateDamage(this.weight);
            this.isLifted = true;
        }
    }
}
