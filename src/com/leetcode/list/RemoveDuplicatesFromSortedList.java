package com.leetcode.list;

/**
 * http://oj.leetcode.com/problems/remove-duplicates-from-sorted-list/
 * ------------------------------------------------------------------------------
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 *
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 * ------------------------------------------------------------------------------
 * Author: Frank Han (trendhanfeng@gmail.com)
 * Date: 13-11-4
 */
public class RemoveDuplicatesFromSortedList {

	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public static ListNode deleteDuplicates(ListNode head) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		if (head == null) {
			return null;
		}
		ListNode current = head;
		int storedValue = head.val, currentValue;
		while (current != null && current.next != null) {
			currentValue = current.next.val;
			if (currentValue == storedValue) {
				current.next = current.next.next;
			} else {
				storedValue = currentValue;
				current = current.next;
			}
		}
		return head;
	}

	public static void main(String args[]){
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(1);
		l1.next = l2;
		deleteDuplicates(l1);
	}
}
