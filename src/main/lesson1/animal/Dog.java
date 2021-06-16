package main.lesson1.animal;

import main.lesson1.animal.Animal;

public class Dog extends Animal {

    public Dog(String name, String color, int age, int maxDist,int isSwim) {
        this.name = name;
        this.color = color;
        this.age = age;
        this.maxDist = maxDist;
        this.isSwim = isSwim;
    }
    @Override
    public void voice() {
//        super.voice();
        System.out.println(name + " Gaff");

    }
}
