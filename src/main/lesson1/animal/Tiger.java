package main.lesson1.animal;

public class Tiger extends Animal {

    public Tiger(String name, String color, int age, int maxDist, int isSwim) {
        this.name = name;
        this.color = color;
        this.age = age;
        this.maxDist = maxDist;

    }



    @Override
    public void voice() {
        System.out.println(name + " Rrrrrmeow");
    }
}
