package com.leetcode.list.sorted;

/**
 * https://oj.leetcode.com/problems/remove-duplicates-from-sorted-list/
 * ------------------------------------------------------------------------------
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 *
 *  For example,
 *  Given 1->1->2, return 1->2.
 *  Given 1->1->2->3->3, return 1->2->3.
 * ------------------------------------------------------------------------------
 * Author: Frank Han (trendhanfeng@gmail.com)
 * Date: 2014-08-23
 */


public class RemoveDuplicatesFromSortedList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode currentNode = head;
        int currentValue = head.val;
        while (currentNode.next != null) {
            if (currentNode.next.val == currentValue) {
                currentNode.next = currentNode.next.next;
            } else {
                currentValue = currentNode.next.val;
                currentNode = currentNode.next;
            }
        }

        return head;
    }
}
