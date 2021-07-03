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
        ArrayList<Y> alist = new ArrayList<>(100);
        for (int i = 0; i < arr.length; i++) {
            alist.add(arr[i]);
        }
        System.out.println("arrInList1" + alist.getClass());
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
}
