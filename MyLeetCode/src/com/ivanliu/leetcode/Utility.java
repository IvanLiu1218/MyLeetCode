package com.ivanliu.leetcode;

import java.util.List;

public class Utility {

	public static class ListNode {
		int val;
		ListNode next;
		ListNode (int x) {
			this(x, null);
		}
		ListNode (int x, ListNode n) {
			val = x;
			next = n;
		}
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
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public static void print(List<TreeNode> list) {
		if (list.size() <= 0) return;
		System.out.print(list.get(0).val);
		for (int i = 1; i < list.size(); ++i) {
			System.out.print(String.format(",%d", list.get(i).val));
		}
		System.out.println(' ');
	}
}
