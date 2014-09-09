package com.leetcode.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * https://oj.leetcode.com/problems/binary-tree-preorder-traversal/
 * ------------------------------------------------------------------------------
 * Given a binary tree, return the preorder traversal of its nodes' values.
 *
 * For example:
 * Given binary tree {1,#,2,3},
 *  1
 *   \
 *    2
 *   /
 *  3
 *  return [1,2,3].

 * Note: Recursive solution is trivial, could you do it iteratively?
 * ------------------------------------------------------------------------------
 * Author: Frank Han (trendhanfeng@gmail.com)
 * Date: 14-09-09
 */
public class BinaryTreePreorderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> returnList = new LinkedList<Integer>();

        if (root == null) {
            return returnList;
        }
        returnList.add(root.val);

        List<Integer> leftList = this.preorderTraversal(root.left);
        if (leftList.size() > 0) {
            returnList.addAll(leftList);
        }

        List<Integer> rightList = this.preorderTraversal(root.right);
        if (rightList.size() > 0) {
            returnList.addAll(rightList);
        }

        return returnList;
    }

    public List<Integer> preorderTraversal2(TreeNode root) {

        List<Integer> returnList = new LinkedList<Integer>();

        if (root == null) {
            return returnList;
        }

        TreeNode currentNode = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();

        while (true) {
            returnList.add(currentNode.val);
            if (currentNode.right != null) {
                stack.push(currentNode.right);
            }
            if (currentNode.left != null) {
                currentNode = currentNode.left;
            } else {
                if (!stack.isEmpty()) {
                    currentNode = stack.pop();
                } else {
                    break;
                }
            }
        }

        return returnList;
    }
}
