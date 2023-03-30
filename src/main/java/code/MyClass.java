package code;

public class MyClass {

    // àclasse MyClass qui a une méthode equals redéfinie
    // pour comparer deux instances de la classe en fonction de leur valeur.

    private int value;

    public MyClass(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
    @Override
    public boolean equals(Object obj){
        if (obj == null){
            return false;
        }
        if(getClass() != obj.getClass()){
            return false;
        }
        final MyClass other = (MyClass) obj;
        if(this.value != other.value){
            return false;
        }

        return true;
    }


}
