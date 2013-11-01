package com.leetcode.tree;

/**
 * http://oj.leetcode.com/problems/balanced-binary-tree/
 * ------------------------------------------------------------------------------
 * Given a binary tree, determine if it is height-balanced.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree in
 * which the depth of the two subtrees of every node never differ by more than 1.
 * ------------------------------------------------------------------------------
 * Author: Frank Han (trendhanfeng@gmail.com)
 * Date: 13-11-1
 */
public class BalancedBinaryTree {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public boolean isBalanced(TreeNode root) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		if (root == null) {
			return true;
		}

		if (isBalanced(root.left) == false || isBalanced(root.right) == false) {
			return false;
		}

		int leftHeight = height(root.left);
		int rightHeight = height(root.right);
		if (leftHeight - rightHeight >= -1 && leftHeight - rightHeight <= 1) {
			return true;
		} else {
			return false;
		}
	}

	public int height(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);
		if (leftHeight < rightHeight) {
			return rightHeight + 1;
		} else {
			return leftHeight + 1;
		}
	}

	public static void main(String[] args) {

	}

}
