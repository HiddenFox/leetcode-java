package com.leetcode.string;

/**
 * http://oj.leetcode.com/problems/single-number/
 * ------------------------------------------------------------------------------
 * Given an array of integers, every element appears twice except for one.
 * Find that single one.
 *
 * Note:
 * Your algorithm should have a linear runtime complexity.
 * Could you implement it without using extra memory?
 * ------------------------------------------------------------------------------
 * Author: Frank Han (trendhanfeng@gmail.com)
 * Date: 13-11-1
 */
public class SingleNumber {

	public static int singleNumber(int[] A) {
		for (int i = 1; i < A.length; i++) {
			A[i] ^= A[i-1];
		}
		return A[A.length-1];
	}

	public static void main(String[] args) {
		System.out.println(singleNumber(new int[]{1,4,3,3,1}));
	}

}
