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
    // Logic to start a level
    public void start(Wizard wizard){
        System.out.println("Welcome at the level " + this.number + " : " + this.name);

        switch (this.number){
            case 1, 2, 3, 5, 6:
                System.out.println("You are meeting an enemy : " + enemy.getName());
                break;
            case 4,7 :
                String listEnemy = "";
                for(Enemy enemy : enemies) {
                    listEnemy = listEnemy + enemy.getName() + ", ";
                }
                System.out.println("You are meeting enemies : " + listEnemy);
                break;
        }
        System.out.println("The fight has begun ....");
        // ajouter un attribut "PROCESS" pour narrer l'évolution/narrer l'histoire de chaque niveau


    }
    public void end(Wizard wizard, Enemy enemy, Scanner sc){
        if(!enemy.IsAlive()){
            System.out.println("You just finished the level " + this.name);
            System.out.println("Do you want increase your health (1) or increase your spellDamage (2) for the next of your journey ? ");
            while (!sc.hasNextInt()) {
                System.out.println("Please choose 1 or 2");
                sc.nextLine();
            }
            int choice = sc.nextInt();
            while(choice != 1 && choice != 2){
                System.out.println("Please choose 1 or 2");
                sc.nextLine();
                choice = sc.nextInt();
            }if(choice == 1){
                System.out.println("health increasing...");
                double amount = (double) (Math.random())*2 + 1;
                wizard.increaseHealth(amount);
                System.out.println("Increasing success ! \n Your health has been multiplied by " + amount);
                System.out.println(wizard.getHealth());;
            }
            if(choice == 2){
                System.out.println("damage increasing...");
                double amount = (double) (Math.random()*2 + 1);
                wizard.increaseDamage(amount);
                System.out.println("Increasing success ! \n Your spellDamage has been multiplied by " + amount);
                System.out.println(wizard.getSpellAmplitude());
            }
        } else if (!wizard.IsAlive()) {
            System.out.println(Constant.customDisplayText(Constant.FIVE_TAB,"GAME OVER", Constant.RED));
        }
    }


}
