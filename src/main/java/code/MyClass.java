package code;

public class MyClass {

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
