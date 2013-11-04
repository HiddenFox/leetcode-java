package com.leetcode.list;

/**
 * http://oj.leetcode.com/problems/linked-list-cycle-ii/
 * ------------------------------------------------------------------------------
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 *
 * Follow up:
 * Can you solve it without using extra space?
 * ------------------------------------------------------------------------------
 * Author: Frank Han (trendhanfeng@gmail.com)
 * Date: 13-11-4
 */
public class LinkedListCycle2 {

	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public static ListNode detectCycle(ListNode head) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		ListNode slow = head;
		ListNode fast = head;

		while (true) {
			if (fast == null || fast.next == null) {
				return null;
			}
			slow = slow.next;
			fast = fast.next.next;
			if (fast == slow) {
				break;
			}
		}

		slow = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);

		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l4;
		System.out.println(detectCycle(l1).val);

		l4.next = l1;
		System.out.println(detectCycle(l1).val);

		l4.next = l2;
		System.out.println(detectCycle(l1).val);

		ListNode l5 = new ListNode(5);
		l5.next = l5;
		System.out.println(detectCycle(l5).val);
	}

}


