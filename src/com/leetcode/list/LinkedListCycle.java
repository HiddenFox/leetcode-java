package com.leetcode.list;

/**
 * http://oj.leetcode.com/problems/linked-list-cycle/
 * ------------------------------------------------------------------------------
 * Given a linked list, determine if it has a cycle in it.
 *
 * Follow up:
 * Can you solve it without using extra space?
 * ------------------------------------------------------------------------------
 * Author: Frank Han (trendhanfeng@gmail.com)
 * Date: 13-11-1
 */
public class LinkedListCycle {

	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public static boolean hasCycle(ListNode head) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		ListNode current = head;
		while (current != null && current.next != null) {
			ListNode cursor = head;
			while (true) {
				if (cursor == current.next) {
					return true;
				}
				if (cursor == current) {
					break;
				}
				cursor = cursor.next;
			}
			current = current.next;
		}
		return false;
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);

		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		System.out.println(hasCycle(l1));

		l4.next = l4;
		System.out.println(hasCycle(l1));

		l4.next = l1;
		System.out.println(hasCycle(l1));

		l4.next = l2;
		System.out.println(hasCycle(l1));
		System.out.println(hasCycle(l3));

		ListNode l5 = new ListNode(5);
		System.out.println(hasCycle(l5));

		l5.next = l5;
		System.out.println(hasCycle(l5));
	}

}
