package main.lesson1;

import main.lesson1.animal.Animal;

public class Cow extends Animal {
    public Cow (String name) {
        this.name = name;
//        this.color = color;
//        this.age = age;
    };
    public void name (){
        System.out.println(("Корову зовут " + name ));
    }
    @Override
    public void voice() {
        System.out.println(name + " Muuuuuuu");

    }
}
