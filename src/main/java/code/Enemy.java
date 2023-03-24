package code;

public class Enemy {

    // Attributs
    private String name;
    private int health;

    private int damage;

    // Constructeur
    public Enemy(String name, int health) {
        this.name = name;
        this.health = health;
    }

    // getters

    public String getName() {
        return this.name;
    }

    public void attack() {
    }
}


