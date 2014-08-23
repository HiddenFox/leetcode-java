package com.leetcode.search;

/**
 * https://oj.leetcode.com/problems/search-for-a-range/
 * ------------------------------------------------------------------------------
 * Given a sorted array of integers, find the starting and ending position of a given target value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 *  If the target is not found in the array, return [-1, -1].
 *
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 * ------------------------------------------------------------------------------
 * Author: Frank Han (trendhanfeng@gmail.com)
 * Date: 2014-08-23
 */
public class SearchForARange {
    public int[] searchRange(int[] A, int target) {
        int[] returnRange = {-1, -1};
        if (A.length == 0) {
            return returnRange;
        }

        int left = 0;
        int right = A.length-1;

        while (left <= right) {
            int mid = (right + left) / 2;
            if (A[mid] == target) {
                returnRange[0] = this.findFirst(A, target, left, mid);
                returnRange[1] = this.findLast(A, target, mid + 1, right);
                break;
            } else if (A[mid] < target) {
                left = mid + 1;
            } else {
                right = mid -1;
            }
        }

        return returnRange;
    }

    public int findFirst(int[] A, int target, int left, int right) {
        while (left < right) {
            int mid = (right + left) / 2;
            if (A[mid] == target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
         if (A[left] == target) {
             return left;
         } else {
             return left + 1;
         }

    }

    public int findLast(int[] A, int target, int left, int right) {
        while (left < right) {
            int mid = (right + left) / 2;
            if (A[mid] == target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (A[left] == target) {
            return left;
        } else {
            return left - 1;
        }
    }
}
