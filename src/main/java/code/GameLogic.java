package code;

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
        System.out.println("Please choose a Core");
        String y = scanner.nextLine();
        System.out.println("Please choose a wood");
        String z = scanner.nextLine();
        Wand wand = new Wand(y, z);
        wizard.equipWand(wand);
        SortingHat sortingHat = new SortingHat();
        wizard.assignHouse(sortingHat);

        System.out.println(x + ", you have been assigned to the House " + wizard.getHouse());
        Troll troll = new Troll();
        List<Enemy> enemyList = new ArrayList<Enemy>();
        enemyList.add(troll);
        level1 = new Level(1, troll, "The Philosopher's stone");
        level1.start(wizard);


    }
}
