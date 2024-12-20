package org.example;

import java.util.HashMap;

public class TelephoneBook {
    HashMap<String,String> phoneBook = new HashMap<>();

    void add(String phone, String lastName) {
        phoneBook.put(phone,lastName);
    }

    void get(String lastName) {
        for (String key : phoneBook.keySet()) {
            if (phoneBook.get(key).equals(lastName)) {
                System.out.println(key + " " + lastName);
            }
        }
    }

}
