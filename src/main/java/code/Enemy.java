package code;

public class Enemy {

    // Attributs
    private String name;
    private int health;
    private int damage;

    // Constructeur
    public Enemy(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    // getters

    public String getName() {
        return this.name;
    }

    public void attack() {
    }
}


