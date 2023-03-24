package code;

public class Spell {

    //Attributs
    private String name;
    private int power;
    private double successRate;

    // Constructeur
    public Spell( String name, int power, double successRate) {
        this.name = name;
        this.power = power;
        this.successRate = successRate;
    }
    // Méthode

    public void cast(Wizard wizard, Enemy enemy) {
        // Logique pour lancer le sort sur l'ennemi
    }

}
