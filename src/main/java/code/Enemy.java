package code;

public class Enemy {

    // Attributs
    private String name;
    private int health;
    private long damage;
    private final int damageAmplitude = 20;

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

        System.out.println(getName() + " vous a infligé " + getDamage() + " de dégats");
    }

    public long getDamage() {
        double ale = Math.random()*damageAmplitude;
        damage = Math.round(ale);
        if(damage == 0){
            damage = 2;
        }
        System.out.println("Voici ce que j'apporte : " + damage);
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}


