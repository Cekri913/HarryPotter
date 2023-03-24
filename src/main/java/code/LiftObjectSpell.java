package code;

public class LiftObjectSpell extends Spell {
    public LiftObjectSpell() {
        super("LiftObject", 10, 0.8);
    }
    @Override
    public void cast (Wizard wizard, Enemy enemy){
        //Logique pour soulever un objet et lâcher sur l'ennemi
    }
}
