package code;

import java.util.List;

public class Level {

    // Attributs
    private int number;
    private List<Enemy> enemies;

    private Enemy enemy;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
    private CombatMechanic combatMechanic;

    // Constructeur

    public Level(int argNumber, Enemy argEnemy, String argName){
        this.number = argNumber;
        this.enemy = argEnemy;
        this.name = argName;
    }

    public Level(int lNum, String lName, List<Enemy> lEnemies){
        this.number = lNum;
        this.name = lName;
        this.enemies = lEnemies;

    }
    // Logique pour demarrer le niveau 1
    public void start(Wizard wizard){
        System.out.println("Welcome at the level " + this.number + " : " + this.name);

        switch (this.number){
            case 1, 2, 3, 5, 6:
                System.out.println(" You are meeting an enemy : " + enemy.getName());
                break;
            case 4,7 :
                String listEnemy = "";
                for(Enemy enemy : enemies) {
                    listEnemy = listEnemy + enemy.getName() + ", ";
                }
                System.out.println(" You are meeting enemies : " + listEnemy);
                break;
        }
        wizard.fight(wizard, enemy);



            // combatMechanic.fight(wizard, enemy);
          /*  if (Wizard.IsAlive()) {
                continue;
            }*/
       // wizard.getHealth();
        // System.out.println(" wizard.getHealth() :  " + wizard.getHealth());
        // System.out.println("Yous lost... GAME OVER ");


        //System.out.println("Congratulations ! You just finished the level " + this.number + " : " + this.name);
    }


}
