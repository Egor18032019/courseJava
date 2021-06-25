package main.lesson1.animal;

import com.sun.corba.se.impl.oa.toa.TOA;

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

        for (Animal i : array) {
            i.run(dist);
            i.canSwim(swimDist);
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

        if (array.length==Animal.count){
            System.out.println("В гонки приняло участие: " + array.length);
        }
        else {
            System.out.println("Что то пошло не так");
        }

        System.out.println("Котов " + Cat.count);
        System.out.println("Собак " + Dog.count);
        System.out.println("Тигров " + Tiger.count);
        System.out.println("Баранов " + Baran.count);
    }
}
