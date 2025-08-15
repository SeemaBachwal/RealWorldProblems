package com.example.visagca.realworld.sample;

public class OneSwapPairs {
    public int countOneSwapPairs(int[] A, int[] B) {
        int mismatches = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != B[i]) mismatches++;
        }
        if (mismatches == 0) return A.length; // already matching
        if (mismatches == 2) return A.length; // one swap fixes two mismatches
        return A.length - mismatches; // the rest match already
    }

    public static void main(String[] args) {
        OneSwapPairs osp = new OneSwapPairs();
        int[] A = {1, 3, 5, 7};
        int[] B = {1, 5, 3, 7};
        System.out.println(osp.countOneSwapPairs(A, B));
        // Output: 4
    }
}
