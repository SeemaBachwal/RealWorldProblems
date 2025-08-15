package com.example.visagca.realworld.sample;

import java.util.ArrayList;
import java.util.List;


public class OneSwapPairs {

    public int maxMatchesAfterOneSwap(int[] A, int[] B) {
        int n = A.length;
        int matchCount = 0;
        List<Integer> mismatches = new ArrayList<>();

        // Step 1: Count matches and track mismatched indices
        for (int i = 0; i < n; i++) {
            if (A[i] == B[i]) {
                matchCount++;
            } else {
                mismatches.add(i);
            }
        }

        // If no mismatches, everything matches
        if (mismatches.size() == 0) return n;

        // Initialize maximum matches
        int maxMatches = matchCount;

        // Step 2: Try swapping only mismatched positions
        int m = mismatches.size();
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                int idx1 = mismatches.get(i);
                int idx2 = mismatches.get(j);

                // Swap in A
                swap(A, idx1, idx2);

                // Count how many positions match now
                int newMatchCount = matchCount;
                // Check the two swapped positions
                if (A[idx1] == B[idx1]) newMatchCount++;
                if (A[idx2] == B[idx2]) newMatchCount++;
                // If swapping broke a previous match (unlikely here because only mismatches), adjust
                if (A[idx1] != B[idx2] && A[idx2] != B[idx1]) { /* handled in newMatchCount */ }

                if (newMatchCount > maxMatches) maxMatches = newMatchCount;

                // Swap back
                swap(A, idx1, idx2);
            }
        }

        return maxMatches;
    }

    // Helper swap function
    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
    	OneSwapPairs osp = new OneSwapPairs();

        int[] A1 = {1, 3, 5, 7};
        int[] B1 = {1, 5, 3, 7};
        System.out.println(osp.maxMatchesAfterOneSwap(A1, B1)); // 4

        int[] A2 = {1, 2, 3, 4};
        int[] B2 = {1, 4, 3, 2};
        System.out.println(osp.maxMatchesAfterOneSwap(A2, B2)); // 4

        int[] A3 = {1, 2, 3, 4, 5};
        int[] B3 = {5, 4, 3, 2, 1};
        System.out.println(osp.maxMatchesAfterOneSwap(A3, B3)); // 3
    }
}
