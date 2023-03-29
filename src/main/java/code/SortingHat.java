package code;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortingHat {
    // Liste des maisons disponibles

    // on transforme une liste de valeurs (public enum ListHouse en une liste string
    // on stream l'enum, on la transforme en liste, on parcours la liste puis on en fait une collection
    public static final List<String> HOUSES = Stream.of((ListHouse.values())).map(ListHouse::name).collect(Collectors.toList());

    // Méthode permettant au Choixpeau Magique d'assigner une maison à un sorcier en choisissant aléatoirement parmi les maisons disponibles.

    /**
     *
     * @return
     */
    public static String assignHouse(){
       // int index = (int)(Math.random() * HOUSES.length);
       // return HOUSES[index];

        Random r = new Random();
        int min = 0;
        int max = HOUSES.size() - 1;
        int random = r.nextInt((max - min) + 1) + min;

        //System.out.println("assignHouse : random = " + random);
        //System.out.println("assignHouse : max = " + max);

        String chosenHousename = HOUSES.get(random);
        //System.out.println("initializeHouse : Wizard house = " + chosenHousename);

        return null;

    }
}
