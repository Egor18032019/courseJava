package main.lesson1.animal;

public abstract class Animal {
    public static int count;
    protected String type;
    protected String name;
    String color;
    int age;
    int maxDist;
    int isSwim;

    public Animal(String type, String name, String color, int age, int maxDist, int isSwim) {
        this.name = name;
        this.color = color;
        this.age = age;
        this.maxDist = maxDist;
        this.isSwim = isSwim;
        count++;
    }

    public final void info() {
        System.out.println(name + " " + color + " " + age);
    }

    public void run(int distention) {
        if (distention < 0) {
            throw new IllegalArgumentException("Задайте дистанцию больше нуля..");
        }
        if (maxDist >= distention || distention > 0) {
            System.out.println(name + " пробежал " + distention + " м");
        } else {
            System.out.println(name + "не смог пробежать " + distention + " м");
        }
    }

    public void canSwim(int swimming) {
        if (swimming < 0) {
            throw new IllegalArgumentException("Задайте дистанцию больше нуля..");
        }
        if (isSwim == 0) {
            System.out.println(name + " неплавает");
            return; // что бы дальше не пошел
        } else {
            if (isSwim >= swimming) {
                System.out.println(name + " проплыл " + swimming + " м");
            } else {
                System.out.println(name + " не смог проплыть " + swimming + " м");
            }
        }
    }

    ;

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
