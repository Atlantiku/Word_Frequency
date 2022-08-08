package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        System.out.println("enter your sentense: " + "\n");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        frequency(input);
    }

    private static void frequency(String sentence) {

        //split sentence into array
        String[] split = sentence.split(" ");
        //create empty Map
        Map<String, Integer> wordsWithFrequency = new HashMap<>();

        for (String word : split) {
            //if the word is inside Map add +1
            if (wordsWithFrequency.containsKey(word)) {
                wordsWithFrequency.put(word, wordsWithFrequency.get(word) + 1);
                //if word is not inside Map, then it in the Map with value =1
            } else {
                wordsWithFrequency.put(word, 1);
            }
        }
        sortAndPrint(wordsWithFrequency);
    }

    private static void sortAndPrint(Map<String, Integer> wordsWithFrequency) {

        //create the list with values from parameter
        List<Map.Entry<String, Integer>> list = new LinkedList<>(wordsWithFrequency.entrySet());

        //sorting the list
        Collections.sort(list, Comparator.comparing(Map.Entry::getValue));
        wordsWithFrequency = new LinkedHashMap<>();

        //converting sorted linkedHashmap to map
        for (Map.Entry<String, Integer> aa : list) {
            wordsWithFrequency.put(aa.getKey(), aa.getValue());
        }

        printing(wordsWithFrequency);
    }

    private static void printing(Map<String, Integer> wordsWithFrequency) {

        //get all keys from map
        ArrayList<String> keys = new ArrayList<>(wordsWithFrequency.keySet());

        //looking map from bottom to top
        for(int i=keys.size()-1; i>=0;i--){

            //print desc order
            System.out.println(wordsWithFrequency.get(keys.get(i)) + "  "+keys.get(i));
        }
    }

}