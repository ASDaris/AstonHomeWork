package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("//////////////////////////////// Задание 1 ////////////////////////////////");
        ArrayList<String> twentyWords = new ArrayList<>(List.of("Mango", "Space", "Helicopter", "Caramel", "Helicopter", "Snowflake", "Perfume", "Bubblegum", "Harmonica", "Pineapple", "Compass", "Perfume", "Starfish", "Kitten", "Llama", "Quirky", "Saffron", "Tornado", "Cactus", "Perfumer"));

        HashMap<String, Integer> countWords = new HashMap<String, Integer>();
        for (String word : twentyWords) {
            countWords.put(word, countWords.getOrDefault(word, 0) + 1);
        }
        System.out.println(countWords);

        HashSet<String> originalWords = new HashSet<>(twentyWords);
        System.out.println("Unique words:" + originalWords);

        System.out.println("//////////////////////////////// Задание 2 ////////////////////////////////");
        TelephoneBook telephoneBook = new TelephoneBook();
        telephoneBook.add("+79320001122", "Folaniy");
        telephoneBook.add("+79320003322", "Folaniy");
        telephoneBook.add("+79320004422", "Mango");
        telephoneBook.add("+79320005422", "Lokar");

        telephoneBook.get("Folaniy");
    }
}

