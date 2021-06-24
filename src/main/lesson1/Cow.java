package main.lesson1;

import main.lesson1.animal.Animal;

public class Cow extends Animal {
    public static int count;

    public Cow(String name, String color, int age, int maxDist, int isSwim) {
        super("Baran", name, color, age, maxDist, isSwim);

        count++;
    }

    @Override
    public void voice() {
        System.out.println(name + " Mu mu mu");
    }
}
