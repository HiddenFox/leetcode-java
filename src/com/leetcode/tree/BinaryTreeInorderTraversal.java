package com.leetcode.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * https://oj.leetcode.com/problems/binary-tree-inorder-traversal/
 * ------------------------------------------------------------------------------
 * Given a binary tree, return the inorder traversal of its nodes' values.
 *
 * For example:
 * Given binary tree {1,#,2,3},
 *  1
 *   \
 *    2
 *   /
 *  3
 * return [1,3,2].
 *
 * Note: Recursive solution is trivial, could you do it iteratively?
 * ------------------------------------------------------------------------------
 * Author: Frank Han (trendhanfeng@gmail.com)
 * Date: 14-09-09
 */
public class BinaryTreeInorderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> returnList = new LinkedList<Integer>();

        if (root == null) {
            return returnList;
        }

        List<Integer> leftList = this.inorderTraversal(root.left);
        if (leftList.size() > 0) {
            returnList.addAll(leftList);
        }

        returnList.add(root.val);

        List<Integer> rightList = this.inorderTraversal(root.right);
        if (rightList.size() > 0) {
            returnList.addAll(rightList);
        }

        return returnList;
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> returnList = new LinkedList<Integer>();

        if (root == null) {
            return returnList;
        }

        TreeNode currentNode = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();

        boolean isPoped = false;
        while (true) {
            if (currentNode.left != null && !isPoped) {
                stack.push(currentNode);
                currentNode = currentNode.left;
                isPoped = false;
            } else {
                returnList.add(currentNode.val);
                if (currentNode.right != null) {
                    currentNode = currentNode.right;
                    isPoped = false;
                } else {
                    if (!stack.isEmpty()) {
                        currentNode = stack.pop();
                        isPoped = true;
                    } else {
                        break;
                    }
                }
            }
        }

        return returnList;
    }
}
