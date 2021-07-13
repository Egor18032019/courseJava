package lesson5.homework;

import javafx.beans.binding.MapExpression;

import java.util.*;

public class PhoneBookForHashMap {
    private Map<String, HashSet<String>> phonebook;

    public PhoneBookForHashMap() {
        phonebook = new HashMap<String, HashSet<String>>();
    }

    public static void main(String[] args) {

    }

    public void add(String surname, String phonenumber) {
        if (this.phonebook.containsKey(surname)) {
            phonebook.get(surname).add(phonenumber);
        } else {
            phonebook.put(surname, new HashSet<>(Arrays.asList(phonenumber)));
        }

    }

    public HashSet<String> getForSurnamePhoneNumbers(String surname) {
        return phonebook.get(surname);
    }

    public void seeHashMap() {
        phonebook.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + " " + entry.getValue());
        });
    }

}
