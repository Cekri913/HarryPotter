package code;

public abstract class Character {
   // Variables et attributs
    public String name;
    public int maxHp, hp, xp;

    // Constructeur
    public Character(String name, int maxHp, int hp, int xp){
        this.name = name;
        this.maxHp = maxHp;
        this.hp = hp;
        this.xp = xp;
    }
     // Méthodes

    public abstract int attack();
    public abstract int defend();

}
