package com.leetcode.list.sorted;

/**
 * https://oj.leetcode.com/problems/merge-sorted-array/
 * ------------------------------------------------------------------------------
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 *
 * Note:
 * You may assume that A has enough space (size that is greater or equal to m + n)
 * to hold additional elements from B.
 * The number of elements initialized in A and B are m and n respectively.
 * ------------------------------------------------------------------------------
 * Author: Frank Han (trendhanfeng@gmail.com)
 * Date: 2014-08-31
 */
public class MergeSortedArray {
    public void merge(int A[], int m, int B[], int n) {
        while (!(m == 0 && n == 0)) {
            if (m == 0) {
                A[n-1] = B[n-1];
                n--;
            } else if (n == 0) {
                break;
            } else {
                if (A[m-1] > B[n-1]) {
                    A[m+n-1] = A[m-1];
                    m--;
                } else {
                    A[m+n-1] = B[n-1];
                    n--;
                }
            }
        }
    }
}
