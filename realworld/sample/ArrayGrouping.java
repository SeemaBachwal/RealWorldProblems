package com.example.visagca.realworld.sample;

import java.util.*;

public class ArrayGrouping {
    public List<Integer> partitionAndCombine(int[] arr) {
        List<Integer> evens = new ArrayList<>();
        List<Integer> odds = new ArrayList<>();

        for (int num : arr) {
            if (num % 2 == 0) evens.add(num);
            else odds.add(num);
        }

        Collections.sort(evens); // ascending
        odds.sort(Collections.reverseOrder()); // descending

        List<Integer> result = new ArrayList<>(evens);
        result.addAll(odds);

        return result;
    }

    public static void main(String[] args) {
        ArrayGrouping ag = new ArrayGrouping();
        int[] arr = {5, 2, 9, 4, 7, 6, 3};
        System.out.println(ag.partitionAndCombine(arr));
        // Output: [2, 4, 6, 9, 7, 5, 3]
    }
}
