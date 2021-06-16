package main.lesson1.animal;

public class Cat extends Animal {

    public Cat(String name, String color, int age,int maxDist,int isSwim) {
        this.name = name;
        this.color = color;
        this.age = age;
        this.maxDist = maxDist;
        this.isSwim = isSwim;
    }

    @Override
    public void voice() {
        System.out.println(name + " Meow");
    }
    public void catMetod(){
        System.out.println(name + " Kiss-kiss");
    }

}
