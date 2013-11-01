package com.leetcode.array;

/**
 * http://oj.leetcode.com/problems/search-a-2d-matrix/
 * ------------------------------------------------------------------------------
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 *
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * For example,
 *
 * Consider the following matrix:
 *
 * [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * Given target = 3, return true.
 * ------------------------------------------------------------------------------
 * Author: Frank Han (trendhanfeng@gmail.com)
 * Date: 13-11-1
 */
public class SearchA2DMatrix {

//	public static boolean searchMatrix(int[][] matrix, int target) {
//		// IMPORTANT: Please reset any member data you declared, as
//		// the same Solution instance will be reused for each test case.
//		if (matrix.length == 0 || matrix[0].length == 0) {
//			return false;
//		}
//
//		int xMin = 0;
//		int xMax = matrix[0].length - 1;
//		int yMin = 0;
//		int yMax = matrix.length - 1;
//
//		int xCurrent = 0, yCurrent = 0;
//
//		if (matrix[0][0] > target) {
//			return false;
//		} else if (matrix[yMax][0] < target) {
//			yCurrent = yMax;
//		} else {
//			while (yMin < yMax) {
//				yCurrent = (yMin + yMax) / 2;
//
//				if (matrix[yMin][0] == target || matrix[yMax][0] == target || matrix[yCurrent][0] == target) {
//					return true;
//				} else if (yMin == yCurrent) {
//					break;
//				} else if (matrix[yCurrent][0] > target) {
//					yMax = yCurrent;
//				} else {
//					yMin = yCurrent;
//				}
//			}
//		}
//
//		while (xMin <= xMax) {
//			xCurrent = (xMin + xMax) / 2;
//			if (matrix[yCurrent][xCurrent] == target) {
//				return true;
//			} else if (matrix[yCurrent][xCurrent] > target) {
//				xMax = xCurrent - 1;
//			} else {
//				xMin = xCurrent + 1;
//			}
//		}
//
//		return false;
//	}

	public static boolean searchMatrix(int[][] matrix, int target) {

		if (matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}

		int xLength = matrix[0].length;
		int min = 0;
		int max = matrix[0].length * matrix.length - 1;

		int x, y, current;
		while (min <= max) {
			current = (min + max) / 2;
			y = current / xLength;
			x = current % xLength;
			if (matrix[y][x] == target) {
				return  true;
			} else if (target < matrix[y][x]) {
				max = current - 1;
			} else {
				min = current + 1;
			}
		}

		return false;
	}

	public static void main(String args[]) {
		System.out.println("false " + searchMatrix(new int[][]{{1},{3}}, 0));
		System.out.println("true " + searchMatrix(new int[][]{{1},{3}}, 1));
		System.out.println("true " + searchMatrix(new int[][]{{1},{3}}, 3));
		System.out.println("false " + searchMatrix(new int[][]{{1},{3}}, 4));
		System.out.println("false " + searchMatrix(new int[][]{{-10,-10},{-9,-9},{-8,-6},{-4,-2},{0,1},{3,3},{5,5},{6,8}}, -11));
		System.out.println("true " + searchMatrix(new int[][]{{-10,-10},{-9,-9},{-8,-6},{-4,-2},{0,1},{3,3},{5,5},{6,8}}, -10));
		System.out.println("false " + searchMatrix(new int[][]{{-10,-10},{-9,-9},{-8,-6},{-4,-2},{0,1},{3,3},{5,5},{6,8}}, -7));
		System.out.println("true " + searchMatrix(new int[][]{{-10,-10},{-9,-9},{-8,-6},{-4,-2},{0,1},{3,3},{5,5},{6,8}}, 0));
		System.out.println("true " + searchMatrix(new int[][]{{-10,-10},{-9,-9},{-8,-6},{-4,-2},{0,1},{3,3},{5,5},{6,8}}, 1));
		System.out.println("true " + searchMatrix(new int[][]{{-10,-10},{-9,-9},{-8,-6},{-4,-2},{0,1},{3,3},{5,5},{6,8}}, 6));
		System.out.println("true " + searchMatrix(new int[][]{{-10,-10},{-9,-9},{-8,-6},{-4,-2},{0,1},{3,3},{5,5},{6,8}}, 8));
		System.out.println("false " + searchMatrix(new int[][]{{-10,-10},{-9,-9},{-8,-6},{-4,-2},{0,1},{3,3},{5,5},{6,8}}, 9));
	}
}
