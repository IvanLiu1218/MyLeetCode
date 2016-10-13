package com.ivanliu.leetcode;

public class Utility {

	public static class ListNode {
		int val;
		ListNode next;
		ListNode (int x) { val = x; }
	}
	
	public static ListNode buildListNode(int[] nums) {
		if (nums.length == 0) return null;
		ListNode head = new ListNode(nums[0]);
		ListNode node = head;
		for (int i = 1; i < nums.length; ++i) {
			node.next = new ListNode(nums[i]);
			node = node.next;
		}
		return head;
	}
	
	public static String toString(ListNode list) {
		StringBuilder result = new StringBuilder("[");
		ListNode node = list;
		while (node != null) {
			result.append(node.val);
			if (node.next != null) {
				result.append(",");
			}
			node = node.next;
		}
		result.append("]");
		return result.toString();
	}
}
