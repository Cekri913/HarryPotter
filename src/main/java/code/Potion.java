package code;

public class Potion {

    // Attributs
    private String name;
    private int healthRestored;

    // Constructeur
    public Potion(String name, int healthRestored) {
        this.name = name;
        this.healthRestored = healthRestored;
    }
    public void drink(Wizard wizard)  {
        // Logique pour boire la potion et regagner de la vie
    }


}
