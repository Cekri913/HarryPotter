package code;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;


@AllArgsConstructor
@Getter
public class House {
    //GRYFFINDOR(1), POUFSOUFFLE(2), SERDAIGLE(3), SERPENTARD(4);

   public  String name; // = { "SLYTHERIN", "HUFFLEPUFF", "GRYFFINDOR", "RAVENCLAW"};
    //private int specialPower;







   /*
      • Les potions sont plus efficaces pour les membres de Hufflepuff.
      • Les sorts font plus de dégâts pour les membres de Slytherin.
      • Les sorciers de Gryffindor sont plus résistants aux dégâts.
      • Les sorciers de Ravenclaw sont plus précis.
    */


    public double getSpellDamageMultiplier() {
        if (this.name.equals(ListHouse.SLYTHERIN)) {
            return 1.2;
        } else {
            return 1.0;
        }
    }
    public double getPotionEffectivenessMultiplier() {
        if (this.name.equals(ListHouse.HUFFLEPUFF)) {
            return 1.2;
        } else {
            return 1.0;
        }
    }
    public double getDamageResistance () {
        if (this.name.equals(ListHouse.GRYFFINDOR)) {
            return 0.8;
        } else {
            return 1.0;
        }
    }
    public double getSpellAccuracy () {
        if (this.name.equals(ListHouse.RAVENCLAW)) {
            return 1.2;
        } else {
            return 1.0;

        }

    }


}
