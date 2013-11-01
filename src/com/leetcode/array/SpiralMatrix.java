package com.leetcode.array;

import java.util.ArrayList;

/**
 * http://oj.leetcode.com/problems/single-number/
 * ------------------------------------------------------------------------------
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 *
 * For example,
 * Given the following matrix:
 *
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * You should return [1,2,3,6,9,8,7,4,5].
 * ------------------------------------------------------------------------------
 * Author: Frank Han (trendhanfeng@gmail.com)
 * Date: 13-11-1
 */
public class SpiralMatrix {

	public static ArrayList<Integer> spiralOrder(int[][] matrix) {
		ArrayList<Integer> order = new ArrayList<Integer>();
		if (matrix.length == 0 || matrix[0].length == 0) return order;

		int xMin = 0;
		int yMin = 0;
		int xMax = matrix[0].length - 1;
		int yMax = matrix.length - 1;

		order.add(matrix[0][0]);

		int i = 0, j = 0;
		while (true) {
			while (i < xMax)	order.add(matrix[j][++i]);
			if (++yMin > yMax)	break;

			while (j < yMax)	order.add(matrix[++j][i]);
			if (xMin > --xMax)	break;

			while (i > xMin)	order.add(matrix[j][--i]);
			if (yMin > --yMax)	break;

			while (j > yMin)	order.add(matrix[--j][i]);
			if (++xMin > xMax)	break;
		}
		return order;
	}

	public static void main(String[] args) {
		System.out.println(spiralOrder(new int[][]{{}}).toString());
		System.out.println(spiralOrder(new int[][]{{},{},{}}).toString());
		System.out.println(spiralOrder(new int[][]{{2},{3}}).toString());
		System.out.println(spiralOrder(new int[][]{{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}}).toString());
	}

}
