package main.lesson1.animal;

public class Baran extends Animal {
    public static int count;

    public Baran(String name, String color, int age, int maxDist, int isSwim) {
        super("Baran", name, color, age, maxDist, isSwim);

        count++;
    }

    @Override
    public void voice() {
        System.out.println(name + " Be be be");
    }
}
