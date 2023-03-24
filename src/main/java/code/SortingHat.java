package code;

public class SortingHat {
    // Liste des maisons disponibles
    public static final String[] HOUSES = {"Gryffindor", "Poufsouffle", "Serdaigle", "Serpentard"};

    // Méthode permettant au Choixpeau Magique d'assigner une maison à un sorcier en choisissant aléatoirement parmi les maisons disponibles.
    public static String assignHouse(){
        int index = (int)(Math.random() * HOUSES.length);
        return HOUSES[index];
    }
}
