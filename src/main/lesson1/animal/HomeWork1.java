package main.lesson1.animal;

public class HomeWork1 {
    public static void main(String[] args) {
        Animal[] animals = {
                new Cat("Belies", "white", 3, 200, 0),
                new Cat("Tyson", "black", 4, 200, 0),
                new Dog("Bilbo", "black", 3, 500, 100),
                new Tiger("Tiger", "orange", 3, 666, 50),
                new Baran("Barman", "grey", 3, 666, 40),
        };

        forForEach(animals, 100, 100);

    }

    static void forForEach(Animal[] array, int dist, int swimDist) {
        int cats = 0;
        int dogs = 0;
        int tigers = 0;
        int barrans = 0;

        for (Animal i : array) {
            i.run(dist);
            i.canSwim(swimDist);
            if (i instanceof Cat) {
                cats++;
            }
            if (i instanceof Dog) {
                dogs++;
            }
            if (i instanceof Tiger) {
                tigers++;
            }
            if (i instanceof Baran) {
                barrans++;
            }
            Class exClass = i.getClass();
//            System.out.println("exClass " + exClass);
            if (exClass.toString().endsWith("Dog")){
                System.out.println("+ собака");
            }
            else if(exClass.toString().endsWith("Cat")){
                System.out.println("+ кот");
            }   else if(exClass.toString().endsWith("Tiger")){
                System.out.println("+ тигр");
            }  else if(exClass.toString().endsWith("Baran")){
                System.out.println("+ баран");
            }

        }
        System.out.println("В гонки приняло участие" + array.length);
        System.out.println("Котов " + cats);
        System.out.println("Собак " + dogs);
        System.out.println("Тигров " + tigers);
        System.out.println("Баранов " + barrans);
    }
}
