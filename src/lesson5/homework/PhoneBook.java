package lesson5.homework;

import java.util.ArrayList;

public class PhoneBook {
    private static ArrayList<String> aryNumbers = new ArrayList<>();

    public static void addNumber(String key, int number) {
        String numberString = String.valueOf(number);
                aryNumbers.add(key);
                aryNumbers.add(numberString);
     }

    public static ArrayList<Integer> getNumber(String name) {
        ArrayList<Integer> arrList = new ArrayList<>();
        if(aryNumbers.size()==0){
            arrList.add(0);
            return arrList;
        }
        for (int i = 0; i < aryNumbers.size(); i=i+2) {
            if(aryNumbers.get(i).equals(name)){
                String phoneNumber = aryNumbers.get((i+1));
                arrList.add(Integer.valueOf(phoneNumber));
            }
        }
        System.out.println(arrList);
        return arrList;
    }

    public static void printArr (){
        System.out.println(aryNumbers);
    }

    public static void seeArray(String[][] arr) {
        System.out.println("Что тут ?");

        int columns = arr.length;
        for (String[] strings : arr) {
            System.out.print("[ ");
            for (int j = 0; j < strings.length; j++) {
                if (j == strings.length - 1) {
                    System.out.print(strings[j] + " ");
                } else {
                    System.out.print(strings[j] + " , ");
                }
            }
            System.out.print("]");
            System.out.println();
        }
    }
}

