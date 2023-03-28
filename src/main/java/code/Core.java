package code;

import lombok.Data;
import lombok.Getter;

public enum Core {
    PHOENIX_FEATHER(1), DRAGON_HEARTSTRINGS(2), BASIL_HORN(3), TROLL_MUSTACHE(4);

    @Getter
    private int coreIndice;
     Core(int indice){
         this.coreIndice=indice;
     }

   public static boolean contains(String name) {
        for (Core core : Core.values()) {
            if (name.equals(core.name()))
                return true;
        }
        return false;
    }public static boolean contains(int indice) {
        for (Core core : Core.values()) {
            if (indice == core.coreIndice)
                return true;
        }
        return false;
    }

}
