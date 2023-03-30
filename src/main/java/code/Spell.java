package code;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Spell {

    //Attributs
    private String name;
    private int damage;

    // Constructeur

    public Spell(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }

    // Méthodes

    public static void wingardiumLeviosa(Wizard wizard, Enemy enemy) {
    // spell to throw object on the troll
        System.out.println("Choose an object to lift with " + Constant.customDisplayText(Constant.ITALIC_TEXT, "Wingardium Leviosa"));
        ArrayList<String> list = new ArrayList<>();
        list.add("rock");
        list.add("chair");
        list.add("table");
        for(int i = 0; i < list.size() + 1; i++){
            System.out.println(i+1 + "-  " + list.get(i));
        }

        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        while(!sc.hasNextInt()){
            System.out.println(Constant.customDisplayText(Constant.RED,"Please choose an integer ", Constant.BOLD_TEXT));
            sc.nextLine();
        }
        if(choice == 1){
            System.out.println("You chose the " + list.get(choice));
        } else if (choice == 2) {
            System.out.println("You chose the " + list.get(choice));
        } else if (choice == 3) {
            System.out.println("You chose the " + list.get(choice));
        }else{
            System.out.println("Please chose a number between 1 and 3");

        }
        Random rand = new Random();
        int successRate = 60; // 60 % de chance que le sort réussisse
        if (rand.nextInt(100) < successRate){
            System.out.println(Constant.customDisplayText(Constant.YELLOW,"object lifting..."));
            if(wizard.y < enemy.y) {
                System.out.println(Constant.customDisplayText(Constant.BLACK, "Take down the " + list.get(choice) + " on the troll ! "));
                int damage;
                damage = rand.nextInt(15);
                // dégats en fonction de l'objet et possibilité de rater le lifting
                enemy.calculateDamage(damage);
            }
        }else {
            System.out.println(Constant.customDisplayText(Constant.RED,"You missed the target."));

        }

}
    public void Sword(Enemy enemy) {
                Random r = new Random();
                int damage;
                damage = r.nextInt(5,15);
                enemy.calculateDamage(damage);
                System.out.println("You are using the legendary sword of Godric Gryffindor and you have inflicted " + damage + " of damage to the Basilic");
                }

    public void Accio(Enemy enemy){
        Random rand = new Random();
        int damage;
        damage = rand.nextInt(3, 13);
        enemy.calculateDamage(damage);
        System.out.println("You are using " + Constant.customDisplayText(Constant.ITALIC_TEXT, "Accio") + " to pull out one of the fangs of the Basilic \n You have inflicted " + damage + " to him");

    }





}
