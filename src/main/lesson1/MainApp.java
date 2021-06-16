//package main.lesson1;
//
//import main.lesson1.animal.Animal;
//import main.lesson1.animal.Cat;
//import main.lesson1.animal.Dog;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//
//public class MainApp {
//    public static void main(String[] args) {
//        Cat cat = new Cat("Барсик", "белый", 2);
//        Cat cat2 = new Cat("White", "White", 3);
//        cat.info();
//        cat2.info();
//        Cow cow = new Cow("Биштекс");
//        cow.name();
//        Dog dog = new Dog("Бильбо", "black", 3);
//        dog.voice();
//        Animal an = new Cat("A", "B", 3);
//        an.voice();
//
//        Animal[] animals = {
//                new Cat("B", "B", 1),
//                new Dog("C", "C", 2),
//        };
//        for (Animal iterator : animals) {
//            iterator.voice();
//        }
//        Animal wildCat = new Cat("D", "Dark", 4);
//        if (wildCat instanceof Cat) {
//            ((Cat) wildCat).catMetod();
//        } else {
//            System.out.println(" Не кот же...");
//        }
//
//        ArrayList<Object> listTest = new ArrayList<>();
//        Cat[] cats = new Cat[2];
//        cats[0] = new Cat("A", "B", 4);
//        cats[1] = new Cat("Ab", "Bc", 5);
//        listTest.add(cat2);
//
//        System.out.println(Arrays.toString(cats));
//        System.out.println(listTest);
//
//        forForEachList(listTest);
//        forForEach(cats);
//
//    }
//
//    static void forForEach(Animal[] array) {
//        for (Animal i : array) {
//            i.fullInfo();
//        }
//    }
//
//    static void forForEachList(ArrayList<Object> array) {
//        for (Object i : array) {
//            System.out.println(i);
//        }
//    }
//};