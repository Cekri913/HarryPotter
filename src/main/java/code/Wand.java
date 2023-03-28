package code;

import lombok.Getter;

import java.util.Random;

@Getter
public class Wand {
    // Attributes
    private Core core;
    private int size;
    // private int size;


    // Constructor
        public Wand(Core core){
            this.core = core;

        }

    public Wand(){
        //initializeCore();
    }




}
