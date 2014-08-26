package com.leetcode.list.sorted;

/**
 * https://oj.leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 * ------------------------------------------------------------------------------
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 *
 * For example,
 *  Given 1->2->3->3->4->4->5, return 1->2->5.
 *  Given 1->1->1->2->3, return 2->3.
 * ------------------------------------------------------------------------------
 * Author: Frank Han (trendhanfeng@gmail.com)
 * Date: 2014-08-23
 */
public class RemoveDuplicatesFromSortedList2 {

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

        ListNode nodeBeforeThisRound = null;
        ListNode nodeBeforeCurrent = head;
        int currentValue = nodeBeforeCurrent.val;
        boolean deleteFirstNodeThisRound = false;

        while (nodeBeforeCurrent.next != null) {
            if (nodeBeforeCurrent.next.val == currentValue) {
                nodeBeforeCurrent.next = nodeBeforeCurrent.next.next;
                deleteFirstNodeThisRound = true;
            } else {
                nodeBeforeCurrent = nodeBeforeCurrent.next;
                currentValue = nodeBeforeCurrent.val;
                if (deleteFirstNodeThisRound) {
                    deleteFirstNodeThisRound = false;
                    if (nodeBeforeThisRound == null) {
                        head = head.next;
                    } else {
                        nodeBeforeThisRound.next = nodeBeforeThisRound.next.next;
                    }
                } else {
                    if (nodeBeforeThisRound == null) {
                        nodeBeforeThisRound = head;
                    } else {
                        nodeBeforeThisRound = nodeBeforeThisRound.next;
                    }
                }
            }
        }

        if (deleteFirstNodeThisRound) {
            if (nodeBeforeThisRound == null) {
                head = head.next;
            } else {
                nodeBeforeThisRound.next = null;
            }
        }

        return head;
    }
}
