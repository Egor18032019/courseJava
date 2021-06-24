package main.lesson1.animal;

public class Cat extends Animal {
    public static int count;
    public Cat(String name, String color, int age, int maxDist, int isSwim) {
        super("Cot", name, color, age, maxDist, isSwim);

        count++;
    }
    @Override
    public void voice() {
        System.out.println(name + " Meow");
    }
    public void catMetod(){
        System.out.println(name + " Kiss-kiss");
    }

}
