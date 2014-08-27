package com.leetcode.search;

/**
 * https://oj.leetcode.com/problems/search-in-rotated-sorted-array/
 * ------------------------------------------------------------------------------
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 *
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 *
 * You may assume no duplicate exists in the array.
 * ------------------------------------------------------------------------------
 * Author: Frank Han (trendhanfeng@gmail.com)
 * Date: 2014-08-28
 */
public class SearchInRotatedSortedArray {

    public int search(int[] A, int target) {
        if (A.length == 0) {
            return -1;
        }

        int peak;
        for (peak = 0; peak < A.length - 1; peak++) {
            if (A[peak] > A[peak+1]) {
                break;
            }
        }

        if (peak == A.length - 1) {
            return binarySearch(A, target, 0, A.length-1);
        } else if (target >= A[0]){
            return binarySearch(A, target, 0, peak);
        } else {
            return binarySearch(A, target, peak+1, A.length-1);
        }
    }

    // For rebuild a rotated array
//    public int search(int[] A, int target) {
//        if (A.length == 0) {
//            return -1;
//        }
//
//        int i;
//        for (i = 0; i < A.length - 1; i++) {
//            if (A[i] > A[i+1]) {
//                break;
//            }
//        }
//        System.out.println(i);
//
//        if (i < A.length - 1) {
//            A = reverseArray(A, 0, i);
//            A = reverseArray(A, i+1, A.length-1);
//            A = reverseArray(A, 0, A.length-1);
//        }
//        System.out.println(Arrays.toString(A));
//        return binarySearch(A, target);
//    }
//
//    public int[] reverseArray(int[] A, int start, int end) {
//        while (start < end) {
//            int temp = A[start];
//            A[start] = A[end];
//            A[end] = temp;
//            start++;
//            end--;
//        }
//        return A;
//    }

    public int binarySearch(int[] A, int target, int start, int end) {
        if (A.length == 0 ) {
            return -1;
        }

        while (start <= end) {
            int middle = (start + end) / 2;
            if (A[middle] == target) {
                return middle;
            } else if (A[middle] > target) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }

        return -1;
    }

}
