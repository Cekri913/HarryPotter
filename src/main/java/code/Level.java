package code;

import java.util.List;
import java.util.Scanner;

public class Level {

    public int getNumber() {
        return number;
    }

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
    // Logique pour demarrer le niveau
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
        System.out.println("The fight has begun ....");
        // ajouter un attribut "PROCESS" pour narrer l'évolution/narrer l'histoire de chaque niveau


    }
    public void end(Wizard wizard, Enemy enemy){
        if(!wizard.IsAlive()){

        }
    }


}
