package code;

public class House {
    //GRYFFINDOR, POUFSOUFFLE, SERDAIGLE, SERPENTARD;

    private String name;
    private int specialPower;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
