package com.leetcode.tree;

/**
 * http://oj.leetcode.com/problems/same-tree/
 * ------------------------------------------------------------------------------
 * Given two binary trees, write a function to check if they are equal or not.
 *
 * Two binary trees are considered equal if they are structurally identical and
 * the nodes have the same value.
 * ------------------------------------------------------------------------------
 * Author: Frank Han (trendhanfeng@gmail.com)
 * Date: 13-11-1
 */
public class SameTree {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public boolean isSameTree(TreeNode p, TreeNode q) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		if (p == null && q == null) {
			return true;
		} else if ((p == null && q != null) || (p != null && q == null)) {
			return false;
		}

		if(p.val != q.val) {
			return false;
		}

		if (!isSameTree(p.left, q.left) || !isSameTree(p.right, q.right)) {
			return false;
		}

		return true;
	}

	public static void main(String[] args) {

	}

}
