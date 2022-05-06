package lesson4.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MainApp {
    public static void main(String[] args) {
        String[] array = new String[]{"A", "B", "C"};
//        swapIt(array, 1, 2);
        ArrayList<String> arrList = new ArrayList<>();
        arrList = arrInList1(array);
        arrInList2(array);
        arrInList3(array);

        Apple appleForBox = new Apple(11);
        Orange orangeForBox = new Orange(22);

        Box boxFruit = new Box();
        Box forAppleBox = new Box();
        Box forOrangeBox = new Box();

        System.out.println("forAppleBox.weight = " + forAppleBox.getWeight());
        System.out.println("forOrangeBox.weight = " + forOrangeBox.getWeight());
        System.out.println("orangeForBox = " + forOrangeBox.getList());
        sortBox(forAppleBox, forOrangeBox);
        System.out.println("forOrangeBox = " + forOrangeBox.getList());
        System.out.println("forAppleBox.weight = " + forAppleBox.getWeight());
        System.out.println("forOrangeBox.weight = " + forOrangeBox.getWeight());
        intoBox(boxFruit, forOrangeBox);
        System.out.println("forOrangeBox.weight = " + forOrangeBox.getWeight());

    }

    public static void swapIt(Object[] arr, int first, int end) {
//        Написать метод, который меняет два элемента массива местами
//        (массив может быть любого ссылочного типа).
        // void так как передаеться сылка и массив мутируеться
        Object foo = arr[first];
        Object bar = arr[end];
        arr[first] = bar;
        arr[end] = foo;
    }

    public static <Y> ArrayList<Y> arrInList1(Y[] arr) {
        ArrayList<Y> alist = new ArrayList<>(arr.length);
        for (int i = 0; i < arr.length; i++) {
            alist.add(arr[i]);
        }
        return alist;
    }

    public static <A> void arrInList2(A[] arr) {
        ArrayList<A> alist = new ArrayList<>(Arrays.asList(arr));
        System.out.println("arrInList2" + alist.getClass());
    }

    public static <A> void arrInList3(A[] arr) {
        ArrayList<A> alist = new ArrayList<>(100);
        Collections.addAll(alist, arr);
        System.out.println("arrInList3" + alist.getClass());
    }

    public static void intoBox(Box firstBox, Box secondBox) {
        // сделать проверку на то что вдруг это одна и таже коробка
        if (firstBox==secondBox){
            return;
        }
        if (firstBox.compareType(secondBox)) {
            while (secondBox.getList().size() > 0) {
                firstBox.addFuit(secondBox.getList().get(0));
                secondBox.removeInBox(0);
            }
        }
    }

    public static void sortBox (Box fBox, Box sBox){
        // сделать проверку на то что вдруг это одна и таже коробка
        if (fBox==sBox){
            return;
        }
         for(int i =0;i<3 ; i++){
             int x =(int)(Math.random()*100);
              Apple appleForBox = new Apple(x);
             int y =(int)(Math.random()*100);
             Orange orangeForBox = new Orange(y);
             fBox.addFuit(appleForBox);
             sBox.addFuit(orangeForBox);
        }
    }
}
