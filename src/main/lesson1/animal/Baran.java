package main.lesson1.animal;

public class Baran extends Animal {
    public Baran(String name, String color, int age, int maxDist,int isSwim) {
        this.name = name;
        this.color = color;
        this.age = age;
        this.maxDist = maxDist;
        this.isSwim = isSwim;

    }

    @Override
    public void voice() {
        System.out.println(name + " Be be be");
    }
}
