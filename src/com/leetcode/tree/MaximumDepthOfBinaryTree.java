package com.leetcode.tree;

/**
 * http://oj.leetcode.com/problems/maximum-depth-of-binary-tree/
 * ------------------------------------------------------------------------------
 * Given a binary tree, find its maximum depth.
 *
 * The maximum depth is the number of nodes along the longest path from the root
 * node down to the farthest leaf node.
 * ------------------------------------------------------------------------------
 * Author: Frank Han (trendhanfeng@gmail.com)
 * Date: 13-11-1
 */
public class MaximumDepthOfBinaryTree {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public int maxDepth(TreeNode root) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		if (root == null) {
			return 0;
		}

		int leftDepth = 0;
		int rightDepth = 0;
		int depth = 1;

		if (root.left != null) {
			leftDepth = maxDepth(root.left);
		}

		if (root.right != null) {
			rightDepth = maxDepth(root.right);
		}

		if (leftDepth > rightDepth) {
			depth += leftDepth;
		} else {
			depth += rightDepth;
		}

		return depth;

	}

	public static void main(String[] args) {

	}

}

