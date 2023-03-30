package code;

import java.time.temporal.ValueRange;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameLogic {
    // levels
    private static Level level;
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
        System.out.println(Constant.customDisplayText(Constant.FIVE_TAB, "HARRY POTTER AT HOME", Constant.RED));
        System.out.println();



        // Creation of a character

        System.out.println(Constant.customDisplayText(Constant.WHITE_TEXT,"Please enter a name "));
        String name = scanner.nextLine();
        while(!isValidPseudo(name)){
            System.out.println(Constant.customDisplayText(Constant.ITALIC_TEXT,"Please put a capital letter and/or at least one number at your name"));
            name = scanner.nextLine();
        }  if(isValidPseudo(name)) {
            wizard = new Wizard(name);
            System.out.println(Constant.customDisplayText(Constant.BOLD_TEXT,"Welcome " + wizard.getName() + " !"));
        }

        choosePet();

        chooseCore();

        SortingHat sortingHat = new SortingHat();
        wizard.assignHouse(sortingHat);

        System.out.println(name + ", The magic Choixpeau has just assigned to the House " + wizard.getHouse().name);
        troll = new Enemy("TROLL", 20, 20);
        List<Enemy> enemyList = new ArrayList<Enemy>();
        enemyList.add(troll);
        level = new Level(1, troll, "The Philosopher's stone");
        level.start(wizard);
       // Weapon weapon  = new Weapon("rock");
        fight(wizard, troll);
        // upDate();
        level.end(wizard, troll);
        basilic = new Enemy("BASILIC", 25, 25);
        level = new Level(2, basilic,"The Chamber of Secrets" );
        level.start(wizard);
        if(wizard.getHouse().name.equals(ListHouse.GRYFFINDOR.name())){
            System.out.println("You are from Gryffindor so you can use the legendary sword of Godric Gryffindor to take the basilic down.");
        }else {
            System.out.println("You are not from Gryffindor. You have to pull one of the fangs of the basilic out et use it to destroy the newspaper of Tom Jedusor.");
        }
        fight(wizard, basilic);
        System.out.println("wizard : " + wizard.health);
        System.out.println("basilic : " + basilic.health);
        level.end(wizard, basilic);
        detraqueurs = new Enemy("Les detraqueurs", 45, 40);
        level = new Level(3, detraqueurs, "The Prisoner of Azkaban");
        level.start(wizard);


    }
    public static boolean isValidPseudo(String name) {
        boolean hasUppercase = !name.equals(name.toLowerCase());
        boolean hasDigit = name.matches(".*\\d.*");
        return hasUppercase && hasDigit;
    }
    public static boolean lifeVerify(Wizard wizard, Enemy enemy){
        return !wizard.IsAlive() && !enemy.IsAlive();
    }
    public void choosePet() {
        System.out.println("Which pet do you want ? ");

        for (Pets pet : Pets.values()) {
            System.out.println(pet);
        }
        Scanner sc = new Scanner(System.in);
        String answer = sc.nextLine().toUpperCase();

        while (!Pets.contains(answer)) {
            System.out.println("PLease choose a pet in the list");
            answer = sc.nextLine().toUpperCase();
        }
        wizard.setPet(Pets.valueOf(answer));
        System.out.println("Good choice, you chose the " + wizard.getPet() + ". This animal will follow you throughout your journey");


    }



    public static Core chooseCore() {
        System.out.println("Please choose a core for your wand");
        final ValueRange range = ValueRange.of(1,Core.values().length);
        String answer;
        Core choice = null;

        for (Core core : Core.values()) {
            System.out.println( core.getCoreIndice() + " - " +core);
        }
        Scanner sc = new Scanner(System.in);
        answer = sc.nextLine();

        try {
            while (!range.isValidIntValue(Integer.parseInt(answer))) {
                System.out.println("Please choose a number between 1 and 4");
                answer = sc.nextLine();
            }
            for(Core c : Core.values()){
                if (Integer.parseInt(answer)==c.getCoreIndice()){
                    choice=c;
                }
            }
            System.out.println("You chose : " + choice.name() );
            return choice;
        }catch (Exception e){
            System.out.println(" Please choose a core in the list");
            return chooseCore();
        }


    }

    /**
     * Narre la mécanique et le fonctionnement du combat
     * @param wizard
     * @param enemy
     */
    public static void fight(Wizard wizard, Enemy enemy) {
        Scanner scan = new Scanner(System.in);
        while(wizard.IsAlive() && enemy.IsAlive()) {
            System.out.println("Do you want to attack (1) or defend (2) ? : ");
            while (!scan.hasNextInt()) {
                scan.nextLine();
            }
            int choice = scan.nextInt();
            while (choice != 1 && choice != 2) {
                System.out.println("Please choose 1 or 2");
                scan.nextLine();
                choice = scan.nextInt();
            }
            if (choice == 1) {
                System.out.println("You choose to attack..");
                System.out.println("santé " + enemy.getName() + " : " + enemy.getHealth());
                System.out.println("santé wizard : " + wizard.getHealth());
                wizard.attack(enemy);
                System.out.println();
                enemy.attack(wizard, level);
                System.out.println();

            }
            if (choice == 2) {
                System.out.println();
                System.out.println("You choose to defend");
                wizard.defend(enemy, level);
                // force qui atténue la puissance de frappe de l'ennemy
            }
            System.out.println("santé " + enemy.getName()+ " : " + enemy.health);
            System.out.println("santé wizard : " + wizard.health);
        }if(!wizard.IsAlive()){
            System.out.println(Constant.customDisplayText(Constant.BLACK,wizard.getName() + ", " + enemy.getName() + " just killed you..."));
        } else if (!enemy.IsAlive()) {
            System.out.println(Constant.customDisplayText(Constant.GREEN,"Congratulation " + wizard.getName() + ", " + "you just killed " + enemy.getName()));

        }

    }
    public void usePotion(Potion potion){
        if(wizard.getHouse().name.equals(ListHouse.GRYFFINDOR.name())){
            potion.setEffectiveness((int) (potion.getEffectiveness() * 1.5));
        }
        potion.drink(wizard);
    }
    public void castSpell(Spell spell, Enemy enemy){
        if(wizard.getHouse().name.equals(ListHouse.SLYTHERIN.name())){
            spell.setDamage((int) (spell.getDamage() * 1.5));
        }spell.cast(enemy);
    }
    public void takeDamage(int damage){
        if(wizard.getHouse().name.equals(ListHouse.GRYFFINDOR.name())){
            damage = (int) (damage * 0.8);
        }
        wizard.setHealth(wizard.getHealth() - damage);
    }
    public void spellAccuracy(Spell spell){

    }

}



