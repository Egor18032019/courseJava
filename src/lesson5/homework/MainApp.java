package lesson5.homework;

import java.util.*;

public class MainApp {
    public static void main(String[] args) {
        String[] words = new String[]{
                "AS", "sa", "AS",
                "Ab", "aB", "Ba",
                "Фы", "Ыф", "ФЫ",
                "ASD", "DSA", "asd"
        };
        System.out.println("getUnArr = " + getUnArr(words));
        System.out.println("getCountWords = " + getCountWords(words));


        PhoneBook.addNumber("aaa", 12323);
        PhoneBook.addNumber("aaa", 123234);
        PhoneBook.addNumber("BBB", 1);
        PhoneBook.addNumber("BBB", 2);
        PhoneBook.addNumber("BBB", 3);
        PhoneBook.addNumber("BBB", 4);
        PhoneBook.addNumber("BBB", 5);
        PhoneBook.addNumber("CCC", 123);
        PhoneBook.printArr();
        PhoneBook.getNumber("BBB");
        PhoneBookForHashMap myPhoneBook = new PhoneBookForHashMap();
        myPhoneBook.add("ndddame","1");
        myPhoneBook.add("ndddame","124");
        myPhoneBook.add("ndddame","123");
        System.out.println(myPhoneBook.getForSurnamePhoneNumbers("ndddame"));
    }

    public static int getUnArr(String[] arr) {
        Set<String> setArr = new HashSet<String>(Arrays.asList(arr));
        return setArr.size();
    }

    ;

    public static Map<String, Integer> getCountWords(String[] arr) {
        Map<String, Integer> mapForwords = new HashMap<>();
        Integer firstTimeWords = 1;
        for (String it : arr) {
            if (!mapForwords.containsKey(it)) {
                mapForwords.put(it, firstTimeWords);
            } else {
                mapForwords.put(it,mapForwords.get(it)+1);
            }
        }

        return mapForwords;
    }

}
