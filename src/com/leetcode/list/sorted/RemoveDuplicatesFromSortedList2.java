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

    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode previousNode = new ListNode(0);
        previousNode.next = head;

        boolean deleteNext = false;
        while (previousNode.next != null && previousNode.next.next != null) {
            if (previousNode.next.val == previousNode.next.next.val) {
                previousNode.next.next = previousNode.next.next.next;
                deleteNext = true;
            } else {
                if (deleteNext) {
                    if (previousNode.next == head) {
                        head = head.next;
                    }
                    previousNode.next = previousNode.next.next;
                } else {
                    previousNode = previousNode.next;
                }
                deleteNext = false;
            }
        }
        if (deleteNext) {
            if (previousNode.next == head) {
                head = head.next;
            }
            previousNode.next = previousNode.next.next;
        }
        return head;
    }

    public ListNode deleteDuplicates3(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode extraNode = new ListNode(0);
        extraNode.next = head;
        ListNode currentNode = extraNode;

        while (currentNode.next != null && currentNode.next.next != null) {
            if (currentNode.next.val == currentNode.next.next.val) {
                int currentValue = currentNode.next.val;
                while (currentNode.next != null && currentNode.next.val == currentValue) {
                    currentNode.next = currentNode.next.next;
                }
            } else {
                currentNode = currentNode.next;
            }
        }
        return extraNode.next;
    }
}
