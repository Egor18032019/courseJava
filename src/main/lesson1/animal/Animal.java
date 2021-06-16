package main.lesson1.animal;

public abstract class Animal {
    protected String name;
    String color;
    int age;
    int maxDist;
    int isSwim =5;
    public final void info() {
        System.out.println(name + " " + color + " " + age);
    }

    public void run(int distention) {
        if (maxDist > distention) {
            System.out.println(name + " пробежал " + distention + " м");
        }
    }
    public void canSwim(int swimming){
        if(isSwim==0){
            System.out.println(name + " неплавает");
        }
        else {
            if (isSwim>=swimming){
                System.out.println(name + " проплыл " + swimming + " м");
            }
            else
            {
                System.out.println(name + " не смог проплыть " + swimming + " м");
            }
        }
    };
    public abstract void voice();

    public void fullInfo() {
        System.out.println("{");
        System.out.println("name: " + name);
        System.out.println("color: " + color);
        System.out.println("age: " + age);
        System.out.println("maxDist: " + maxDist);
        System.out.println("isSwim: " + isSwim);
        System.out.println("}");
    }
}
