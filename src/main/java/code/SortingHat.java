package code;

import java.util.Random;

public class SortingHat {
    // Liste des maisons disponibles


    public static final String[] HOUSES = {"SLYTHERIN", "HUFFLEPUFF", "GRYFFINDOR", "RAVENCLAW"};

    // Méthode permettant au Choixpeau Magique d'assigner une maison à un sorcier en choisissant aléatoirement parmi les maisons disponibles.
    public static String assignHouse(){
       // int index = (int)(Math.random() * HOUSES.length);
       // return HOUSES[index];

        Random r = new Random();
        int min = 0;
        int max = HOUSES.length - 1;
        int random = r.nextInt((max - min) + 1) + min;

        System.out.println("assignHouse : random = " + random);
        System.out.println("assignHouse : max = " + max);

        String chosenHousename = new House(HOUSES[random]).getName();
        System.out.println("initializeHouse : Wizard house = " + chosenHousename);

        return chosenHousename;

    }
}
