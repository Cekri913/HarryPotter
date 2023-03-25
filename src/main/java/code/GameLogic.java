package code;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameLogic {
    // levels
    private static Level level1;
    private static Level level2;
    private static Level level3;
    private static Level level4;
    private static Level level5;
    private static Level level6;
    private static Level level7;


    private static Enemy troll;
    private static Enemy basilic;
    private static Enemy detraqueurs;
    private static Enemy voldemort;
    private static Enemy peterPettigrew;
    private static Enemy doloresOmbrage;
    private static Enemy bellatrixLestrange;
    private static Enemy mangemorts;


    public GameLogic() {
        Scanner scanner = new Scanner(System.in);


        // Initialisation
        System.out.println("                    HARRY POTTER AT HOME");
        System.out.println();


        // Création d'un personnage
        System.out.println("Please enter a pseduo ");
        String x = scanner.nextLine();
        Wizard wizard = new Wizard(x);
        System.out.println("Welcome " + x + " !");
        System.out.println("");
        System.out.println("Choisissez un animal");
        Wizard.choosePet();
        System.out.println("Please choose a Core");
        String y = scanner.nextLine();
        Wand wand = new Wand(x);
        wizard.equipWand(wand);
        SortingHat sortingHat = new SortingHat();
        wizard.assignHouse(sortingHat);

        System.out.println(x + ", you have been assigned to the House " + wizard.getHouse());
        troll = new Enemy("troll", 200, 30);
        List<Enemy> enemyList = new ArrayList<Enemy>();
        enemyList.add(troll);
        level1 = new Level(1, troll, "The Philosopher's stone");
        level1.start(wizard);
    }

        public static void fight(Wizard wizard, Enemy enemy, Scanner scan){

            System.out.println("The fight has begun ....");
            System.out.println("You are faced to " + enemy.getName() + ".");
            System.out.println("Do you want to attack (1) or defend (2) ? : ");
            while(!scan.hasNextInt()){
                scan.nextLine();
            }
            int choice = scan.nextInt();
            if (choice == 1){
                System.out.println("You choose to attack..");
                wizard.attack(enemy.getDamage());
                //wizard.s
               long ennemyDamage = enemy.getDamage();
               long wizardSpell = wizard.getSpellDamage();
                System.out.println();
                enemy.attack();
                System.out.println();

            } else if (choice == 2) {
                System.out.println("You choose to defend");
                wizard.defend();
                // force qui atténue la puissance de frappe de l'ennemi
                enemy.attack();
            }
            else {
                System.out.println("Please choose 1 or 2");
                scan.nextLine();


        }



    }

}
