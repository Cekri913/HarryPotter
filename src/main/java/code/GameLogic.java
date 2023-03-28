package code;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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

    private Wizard wizard;


    public GameLogic() {
        Scanner scanner = new Scanner(System.in);

        // Initialisation

        System.out.println("                    HARRY POTTER AT HOME");
        System.out.println();


        // Création d'un personnage

        System.out.println("Please enter a pseudo ");
        String pseudo = scanner.nextLine();
        wizard = new Wizard(pseudo);

        System.out.println("Welcome " + wizard.getName() + " !");
        System.out.println("");

      // System.out.println(wizard.getHouse());

        System.out.println(wizard.getHouse().name);
        System.out.println("getSpellAccuracy() : " + wizard.getHouse().getSpellAccuracy());
        System.out.println("getPotionEffectivenessMultiplier() : " + wizard.getHouse().getPotionEffectivenessMultiplier());
        System.out.println("getDamageResistance() : " + wizard.getHouse().getDamageResistance());
        System.out.println("getSpellDamageMultiplier() : " + wizard.getHouse().getSpellDamageMultiplier());
       // System.out.println("spécialité : " + wizard.getHouse().);

        chooseCore();
        choosePet();
        System.exit(0);
       }

        //choosePet();

        public void chooseCore() {
            for (Core core : Core.values()) {
                System.out.println(core.getCoreIndice() + " - " +core.name());
            }
            Scanner sc = new Scanner(System.in);
            String answer = sc.nextLine().toUpperCase();
            while (!Core.contains(answer)) {
                System.out.println("Please choose a core in the list");
                answer = sc.nextLine().toUpperCase();
            }
           System.out.println("You choosed : " + answer);


/*
            Wand wand = new Wand(Core(answer));
            wizard.equipWand(wand);

            System.out.println("core : " + wand.getCore());
            System.out.println("wand : " + wand.getCore());*/

        }


       /* Wand wand = new Wand(Wizard.chooseCore());
        wizard.equipWand(wand);
        SortingHat sortingHat = new SortingHat();
        wizard.assignHouse(sortingHat);

        System.out.println(pseudo + ", you have been assigned to the House " + wizard.getHouse());
        troll = new Enemy("troll", 200, 30);
        List<Enemy> enemyList = new ArrayList<Enemy>();
        enemyList.add(troll);
        level1 = new Level(1, troll, "The Philosopher's stone");
        level1.start(wizard);*/


        public static void fight(Wizard wizard, Enemy enemy, Scanner scan){

            System.out.println("The fight has begun ....");
            System.out.println("Do you want to attack (1) or defend (2) ? : ");
            while(!scan.hasNextInt()){
                scan.nextLine();
            }
            int choice = scan.nextInt();
            if (choice == 1){
                System.out.println("You choose to attack..");
                wizard.attack(enemy.getDamage());
                //wizard.s
               long enemyDamage = enemy.getDamage();
               long wizardSpell = wizard.getSpellDamage();
                System.out.println();
                enemy.attack(wizard);
                System.out.println();

            } else if (choice == 2) {
                System.out.println("You choose to defend");
                wizard.defend();
                // force qui atténue la puissance de frappe de l'ennemi
                enemy.attack(wizard);
            }
            else {
                System.out.println("Please choose 1 or 2");
                scan.nextLine();


        }
    }

    public void choosePet() {
        System.out.println("Which pet do you want ? ");

        for (Pets pet : Pets.values()) {
            System.out.println(pet);
        }

        Scanner sc = new Scanner(System.in);
        String answer = sc.nextLine().toUpperCase();

        while (!Pets.contains(answer)) {
            System.out.println("The name isn't in the list");
            answer = sc.nextLine().toUpperCase();
        }

        wizard.setPet(Pets.valueOf(answer));
        System.out.println("You choose : " + wizard.getPet());

    }




}
