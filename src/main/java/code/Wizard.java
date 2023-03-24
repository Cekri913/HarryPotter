package code;
import java.util.ArrayList;
import java.util.Scanner;

//attributs du personnage
public class Wizard {
    private String name;
    public int  health = 100;
    private Pets pet;
    private Wand wand;
    private String house;

    // Constructeur
    public Wizard(String name){ //, int health, Pets pet, Wand wand, House house) {
        this.name = name;
        this.health = health;

    }


    // Getters
    public String getName() {
        return name;
    }

    public Pets getPet() {
        return pet;
    }

    public int getHealth() {
        return health;
    }

    public Wand getWand() {
        return wand;
    }

    public String getHouse() {
        return house;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setHealth() {
        this.health = health;
    }
    // Méthodes


    public static Pets choosePet(){
        System.out.println("Which pet do you want?");
        for(Pets pet: Pets.values()){
            System.out.println(pet);
        }
        Scanner sc = new Scanner(System.in);
        String answer = sc.nextLine();
        while(!Pets.contains(answer)){
            System.out.println("The name isn't in the list");
            answer = sc.nextLine();
        }
        return Pets.valueOf(answer);
    }

    public void setPet(Pets pet) {
        this.pet = pet;
    }

    public void equipWand(Wand wand) {
        this.wand = wand;
    }

    public void assignHouse(SortingHat sortingHat) {
        this.house = sortingHat.assignHouse();
    }

    public static void fight(Wizard wizard, Enemy enemy, Scanner scan){
        System.out.println("The fight has begun ....");
        System.out.println("Do you want to attack (1) or defend (2) ? : ");
        while(!scan.hasNextInt()){
            scan.nextLine();
        }
        int choice = scan.nextInt();

    }
    public boolean IsAlive(){
        return this.health > 0;
    }
    public void increaseHealth(int amount) {
        this.health += amount;
    }
    public void increaseDamage(int amount) {
        this.damage += amount;
    }
    public double getSpellDamageMultiplier() {
        if (this.house.equals("Slytherin")) {
            return 1.2;
        } else {
            return 1.0;
        }
    }
    public double getPotionEffectivenessMultiplier() {
        if (this.house.equals("Hufflepuff")) {
            return 1.2;
        } else {
            return 1.0;
        }
    }
        public double getDamageResistance () {
            if (this.house.equals("Gryffindor")) {
                return 0.8;
            } else {
                return 1.0;
            }
        }
        public double getSpellAccuracy () {
            if (this.house.equals("Ravenclaw")) {
                return 1.2;
            } else {
                return 1.0;

            }
        }
    }



