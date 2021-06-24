package main.lesson1.animal;

import main.lesson1.animal.Animal;

public class Dog extends Animal {
    public static int count;
    public Dog(String name, String color, int age, int maxDist, int isSwim) {
        super("Dog", name, color, age, maxDist, isSwim);

        count++;
    }

    @Override
    public void voice() {
//        super.voice();
        System.out.println(name + " Gaff");

    }
}
