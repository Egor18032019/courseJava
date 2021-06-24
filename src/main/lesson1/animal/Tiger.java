package main.lesson1.animal;

public class Tiger extends Animal {
    public static int count;
    public Tiger(String name, String color, int age, int maxDist, int isSwim) {
        super("Tiger", name, color, age, maxDist, isSwim);

        count++;
    }



    @Override
    public void voice() {
        System.out.println(name + " Rrrrrmeow");
    }
}
