package com.ivanliu.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import com.ivanliu.leetcode.Utility.ListNode;
import com.ivanliu.leetcode.Utility.TreeNode;

public class Solution {
	
	/**
	 *  [Easy] #001. Two Sum
	 *  
	 *  Given an array of integers, return indices of the two numbers such that they add up to a specific target.
	 *  You may assume that each input would have exactly one solution.
	 *  
	 *  Example:
	 *  Given nums = [2, 7, 11, 15], target = 9,
	 *  Because nums[0] + nums[1] = 2 + 7 = 9,
	 *  return [0, 1].
	 */
	public int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
        	if (!map.containsKey(nums[i])) {
        		map.put(nums[i], i);
        	}
        	int leftValue = target - nums[i];
        	if (map.containsKey(leftValue) && map.get(leftValue) != i) {
        		return new int[] { map.get(leftValue), i };
        	}
        }
        return null;
    }
//	public int[] twoSum(int[] nums, int target) {
//		for (int i = 0; i < nums.length; ++i) {
//			int leftTarget = target - nums[i];
//			for (int j = i + 1; j < nums.length; ++j) {
//				if (nums[j] == leftTarget) {
//					return new int[] { i, j };
//				}
//			}
//		}
//		return null;
//    }
	
	/**
	 *  [Medium] #002. Add Two Numbers
	 *  
	 *  You are given two linked lists representing two non-negative numbers. 
	 *  The digits are stored in reverse order and each of their nodes contain a single digit. 
	 *  Add the two numbers and return it as a linked list.
	 *  
	 *  Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
	 *  Output: 7 -> 0 -> 8
	 */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode n1 = l1;
		ListNode n2 = l2;
		int carry = 0;
		ListNode result = new ListNode(carry);
		ListNode node = result;
		while (n1 != null || n2 != null) {
			int val1 = n1 != null ? n1.val : 0;
			int val2 = n2 != null ? n2.val : 0;
			int total = val1 + val2 + node.val;
			node.val = total % 10;
			carry = total / 10;
			
			if (n1 != null) n1 = n1.next;
			if (n2 != null) n2 = n2.next;
			if (n1 != null || n2 != null || carry != 0) {
				node.next = new ListNode(carry);
				node = node.next;
			}
		}
        return result;
    }
	
	/**
	 *  [Medium] #003. Longest Substring Without Repeating Characters
	 *  
	 *  Given a string, find the length of the longest substring without repeating characters.
	 *  
	 *  Examples:
	 *  Given "abcabcbb", the answer is "abc", which the length is 3.
	 *  Given "bbbbb", the answer is "b", with the length of 1.
	 *  Given "pwwkew", the answer is "wke", with the length of 3. 
	 *   - Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
	 */
	public int lengthOfLongestSubstring(String s) {
		char[] cArray = s.toCharArray();
		int maxLength = 0;
		int startIndex = 0;
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < cArray.length; ++i) {
			if (map.containsKey(cArray[i])) {
				int length = i - startIndex;
				if (length > maxLength) {
					maxLength = length;
				}
				int index = map.get(cArray[i]) + 1;
				if (index > startIndex) {
					startIndex = index;
				}
			}
			map.put(cArray[i], i);
		}
		int length = cArray.length - startIndex;
		if (length > maxLength) maxLength = length;
		
        return maxLength;
    }
	
	/**
	 *  [Hard] #004. Median of Two Sorted Arrays
	 *  
	 *  There are two sorted arrays nums1 and nums2 of size m and n respectively.
	 *  Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
	 *  
	 *  Example 1:
	 *  nums1 = [1, 3]
	 *  nums2 = [2]
	 *  The median is 2.0
	 *  
	 *  Example 2:
	 *  nums1 = [1, 2]
	 *  nums2 = [3, 4]
	 *  The median is (2 + 3)/2 = 2.5
	 */
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return 0;
    }
	
	/**
	 *  [Medium] #005. Longest Palindromic Substring
	 *  Given a string S, find the longest palindromic substring in S. 
	 *  You may assume that the maximum length of S is 1000, 
	 *  and there exists one unique longest palindromic substring.
	 */
	public String longestPalindrome(String s) {
        return null;
    }
	
	/**
	 *  [Easy] #006. ZigZag Conversion
	 *  
	 *  The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
	 *  P   A   H   N
	 *  A P L S I I G
	 *  Y   I   R
	 *  
	 *  And then read line by line: "PAHNAPLSIIGYIR"
	 *  Write the code that will take a string and make this conversion given a number of rows:
	 *  string convert(string text, int nRows);
	 *  convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
	 */
	public String convert(String s, int numRows) {
		if (numRows == 1) return s;
		StringBuilder sb = new StringBuilder();
		int delta = numRows + numRows - 2;
		int r = 0;
		while (r < numRows) {
			int l = r;
			boolean flag = false;
			while (l < s.length()) {
				sb.append(s.charAt(l));
				if (r % (numRows - 1) == 0) {
					l += delta;
				} else if (flag) {
					l += r * 2;
					flag = false;
				} else {
					l += delta - r * 2;
					flag = true;
				}
			}
			++r;
		}
        return sb.toString();
    }
	
	/**
	 *  [Easy] #014. Longest Common Prefix
	 *  
	 *  Write a function to find the longest common prefix string amongst an array of strings.
	 */
	public String longestCommonPrefix(String[] strs) {
		if (strs.length == 0) return "";
		int minLength = -1;
		int index = 0;
		for (int i = 0; i < strs.length; ++i) {
			if (strs[i].length() > minLength) {
				minLength = strs[i].length();
				index = i;
			}
		}
		String prefix = strs[index];
		while (prefix.length() != 0) {
			int j = 0;
			for (;j < strs.length; ++j) {
				if (!strs[j].startsWith(prefix)) {
					break;
				}
			}
			if (j >= strs.length) return prefix;
			prefix = prefix.substring(0,  prefix.length() - 1);
		}
        return prefix;
    }
	
	/**
	 *  [Easy] #019. Remove Nth Node From End of List
	 *  
	 *  Given a linked list, remove the nth node from the end of list and return its head.
	 *  
	 *  For example,
	 *  Given linked list: 1->2->3->4->5, and n = 2.
	 *  After removing the second node from the end, the linked list becomes 1->2->3->5.
	 *  
	 *  Note:
	 *  Given n will always be valid.
	 *  Try to do this in one pass.
	 */
	public ListNode removeNthFromEnd(ListNode head, int n) {
		Deque<ListNode> queue = new ArrayDeque<>(n + 1);
		ListNode node = head;
		while (node != null) {
			queue.addLast(node);
			if (queue.size() > n + 1) {
				queue.removeFirst();
			}
			node = node.next;
		}
		if (queue.size() < n + 1) {
			node = queue.removeFirst();
			return node.next;
		} else {
			node = queue.removeFirst();
			ListNode toRemove = queue.removeFirst();
			node.next = toRemove.next;
		}
        return head;
    }
	
	/**
	 *  [Easy] #020. Valid Parentheses
	 * 
	 *  Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
	 *  The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
	 */
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		try {
			for (int i = 0; i < s.length(); ++i) {
				char c = s.charAt(i);
				if (c == '(' || c == '{' || c == '[') {
					stack.push(c);
				} else if (c == ')' || c == '}' || c == ']') {
					char top = stack.peek();
					if ( (top == '(' && c == ')')
							|| (top == '{' && c == '}')
							|| (top == '[' && c == ']')) {
						stack.pop();
					} else {
						return false;
					}
				} else {
					return false;
				}
			}
		} catch (Exception e) {
			return false;
		}
		if (stack.size() == 0) return true;
        return false;
    }
	
	/**
	 *  [Medium] #022. Generate Parentheses
	 *  
	 *  Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
	 *  
	 *  For example, given n = 3, a solution set is:
	 *  [
	 *    "((()))",
	 *    "(()())",
	 *    "(())()",
	 *    "()(())",
	 *    "()()()"
	 *  ]
	 */
	public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        String str = "(";
        generateParenthesis(result, str, n - 1, n);
        return result;
    }
	
	public void generateParenthesis(List<String> result, String str, int numStart, int numEnd) {
		if (numStart == 0) {
			int n = numEnd;
			while (n != 0) {
				str += ")";
				--n;
			}
			result.add(str);
		} else {
			if (numStart < numEnd) {
				generateParenthesis(result, str + "(", numStart - 1, numEnd);
				generateParenthesis(result, str + ")", numStart, numEnd - 1);
			} else if (numStart >= numEnd) {
				generateParenthesis(result, str + "(", numStart - 1, numEnd);
			}
		}
	}
	
	/**
	 *  [Easy] #028. Implement strStr()
	 *  
	 *  Implement strStr().
	 *  Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
	 */
	public int strStr(String haystack, String needle) {
		if (haystack.equals(needle)) return 0;
		if (haystack.length() < needle.length()) return -1;
		for (int i = 0; i < haystack.length() - needle.length() + 1; ++i) { // to avoid Time Limit Exceeded
			char c = haystack.charAt(i);
			int j = 0;
			int k = i;
			while (j < needle.length()) {
				if (c != needle.charAt(j)) {
					break;
				}
				++j;
				if (++k < haystack.length()) {
					c = haystack.charAt(k);
				}
			}
			if (j >= needle.length()) {
				return i;
			}
		}
        return -1;
    }
	
	/**
	 *  [Easy] #036. Valid Sudoku
	 *  
	 *  Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
	 *  The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
	 *  A partially filled sudoku which is valid.
	 *  Note:
	 *  A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
	 */
	public boolean isValidSudoku(char[][] board) {
        // Each row must have the numbers 1-9 occuring just once.
		for (int i = 0; i < 9; ++i) {
			HashSet<Character> set = new HashSet<>();
			for (int j = 0; j < 9; ++j) {
				if (board[i][j] == '.') continue;
				if (set.contains(board[i][j])) return false;
				set.add(board[i][j]);
			}
		}
		// Each column must have the numbers 1-9 occuring just once.
		for (int i = 0; i < 9; ++i) {
			HashSet<Character> set = new HashSet<>();
			for (int j = 0; j < 9; ++j) {
				if (board[j][i] == '.') continue;
				if (set.contains(board[j][i])) return false;
				set.add(board[j][i]);
			}
		}
		// And the numbers 1-9 must occur just once in each of the 9 sub-boxes of the grid.
		for (int k = 0; k < 9; ++k) {
			HashSet<Character> set = new HashSet<>();
			for (int i = (k / 3) * 3; i < (k / 3 + 1) * 3; ++i) {
				for (int j = (k % 3) * 3; j < (k % 3 + 1) * 3; ++j) {
					if (board[i][j] == '.') continue;
					if (set.contains(board[i][j])) return false;
					set.add(board[i][j]);
				}
			}
		}
		return true;
    }
	
	/**
	 *  [Easy]
	 *  #038. Count and Say
	 *  
	 *  The count-and-say sequence is the sequence of integers beginning as follows:
	 *  1, 11, 21, 1211, 111221, ...
	 *  
	 *  1 is read off as "one 1" or 11.
	 *  11 is read off as "two 1s" or 21.
	 *  21 is read off as "one 2, then one 1" or 1211.
	 *  Given an integer n, generate the nth sequence.
	 *  
	 *  Note: The sequence of integers will be represented as a string.
	 */
	public String countAndSay(int n) {
		String prev = "1";
		List<String> countAndSayList = new ArrayList<>();
		countAndSayList.add(prev);
		while (countAndSayList.size() < n) {
			StringBuilder sb = new StringBuilder();
			int i = 0;
			char c = prev.charAt(i++);
			int count = 1;
			for (; i < prev.length(); ++i) {
				if (prev.charAt(i) == c) ++count;
				else {
					sb.append(Integer.toString(count));
					sb.append(c);
					c = prev.charAt(i);
					count = 1;
				}
			}
			sb.append(Integer.toString(count));
			sb.append(c);
			prev = sb.toString();
			countAndSayList.add(prev);
		}
        return countAndSayList.get(n - 1);
    }
	
	/**
	 *  [Easy]
	 *  #067. Add Binary
	 *  
	 *  Given two binary strings, return their sum (also a binary string).
	 *  
	 *  For example,
	 *  a = "11"
	 *  b = "1"
	 *  Return "100".
	 */
	public String addBinary(String a, String b) {
		StringBuilder sb = new StringBuilder();
		int i = a.length() - 1;
		int j = b.length() - 1;
		int carry = 0;
		while (0 <= i && 0 <= j) {
			char c1 = a.charAt(i--);
			char c2 = b.charAt(j--);
			int sum = c1 - 48 + c2 - 48 + carry;
			carry = sum / 2;
			sb.append(sum % 2);
		}
		while (0 <= i) {
			char c = a.charAt(i--);
			int sum = c - 48 + carry;
			carry = sum / 2;
			sb.append(sum % 2);
		}
		while (0 <= j) {
			char c = b.charAt(j--);
			int sum = c - 48 + carry;
			carry = sum / 2;
			sb.append(sum % 2);
		}
		if (carry > 0) sb.append(carry);
        return sb.reverse().toString();
    }
	
	/**
	 *  [Easy]
	 *  #107. Binary Tree Level Order Traversal II
	 *  Given a binary tree, return the bottom-up level order traversal of its nodes' values.
	 *  (ie, from left to right, level by level from leaf to root).
	 *  
	 *  For example:
	 *  Given binary tree [3,9,20,null,null,15,7],
	 *      3
	 *     / \
	 *    9  20
	 *      /  \
	 *     15   7
	 *  return its bottom-up level order traversal as:
	 *  [
	 *    [15,7],
	 *    [9,20],
	 *    [3]
	 *  ]
	 */
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null) return result;
		Deque<TreeNode> nodes = new ArrayDeque<>();
		TreeNode flag = new TreeNode(-1);
		nodes.addLast(root);
		nodes.addLast(flag);
		List<Integer> list = new ArrayList<>();
		while (nodes.size() != 0) {
			TreeNode node = nodes.pollFirst();
			if (node == flag) {
				result.add(list);
				if (nodes.size() != 0) {
					nodes.addLast(flag);
					list = new ArrayList<>();
				}
			}
			else {
				if (node.left != null) nodes.addLast(node.left);
				if (node.right != null) nodes.addLast(node.right);
				list.add(node.val);
			}
		}
		List<List<Integer>> resultR = new ArrayList<>();
		for (int i = result.size() - 1; i >= 0; --i) {
			resultR.add(result.get(i));
		}
        return resultR;
    }
	
	/**
	 *  [Easy]
	 *  #110. Balanced Binary Tree
	 *  Given a binary tree, determine if it is height-balanced.
	 *  For this problem, a height-balanced binary tree is defined as a binary tree 
	 *  in which the depth of the two subtrees of every node never differ by more than 1.
	 */
	public boolean isBalanced(TreeNode root) {
		if (root == null) return true;
		Deque<TreeNode> queue = new ArrayDeque<>();
		queue.addLast(root);
		while (queue.size() != 0) {
			TreeNode node = queue.pollFirst();
			if (node.left != null) queue.addLast(node.left);
			if (node.right != null) queue.addLast(node.right);
			int levelLeft = this.isBalanced_getTreeLevel(node.left, 0);
			int levelRight = this.isBalanced_getTreeLevel(node.right, 0);
			if (Math.abs(levelLeft - levelRight) > 1) return false;
		}
		return true;
    }
	
	public int isBalanced_getTreeLevel(TreeNode node, int level) {
		if (node == null) {
			return level;
		} else {
			++level;
			int levelLeft = isBalanced_getTreeLevel(node.left, level);
			int levelRight = isBalanced_getTreeLevel(node.right, level);
			return Math.max(levelLeft, levelRight);
		}
	}
	
	/**
	 *  [Easy]
	 *  #125. Valid Palindrome
	 *  
	 *  Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
	 *  
	 *  For example,
	 *  "A man, a plan, a canal: Panama" is a palindrome.
	 *  "race a car" is not a palindrome.
	 *  
	 *  Note:
	 *  Have you consider that the string might be empty? This is a good question to ask during an interview.
	 *  For the purpose of this problem, we define empty string as valid palindrome.
	 */
	public boolean isPalindrome(String s) {
		if (s.length() == 0) return true;
		String str = s.toLowerCase();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); ++i) {
			char c = str.charAt(i);
			if (97 <= c && c <= 122 || 48 <= c && c <= 57) {
				sb.append(c);
			}
		}
		String checkStr = sb.toString();
		int length = checkStr.length();
		for (int i = 0; i < length / 2; ++i) {
			char c1 = checkStr.charAt(i);
			char c2 = checkStr.charAt(length - 1 - i);
			if (c1 != c2) return false;
		}
        return true;
    }
	
	/**
	 *  [Easy]
	 *  #155. Min Stack
	 *  
	 *  Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
	 *  push(x) -- Push element x onto stack.
	 *  pop() -- Removes the element on top of the stack.
	 *  top() -- Get the top element.
	 *  getMin() -- Retrieve the minimum element in the stack.
	 *  
	 *  Example:
	 *  MinStack minStack = new MinStack();
	 *  minStack.push(-2);
	 *  minStack.push(0);
	 *  minStack.push(-3);
	 *  minStack.getMin();   --> Returns -3.
	 *  minStack.pop();
	 *  minStack.top();      --> Returns 0.
	 *  minStack.getMin();   --> Returns -2.
	 *  
	 *  Your MinStack object will be instantiated and called as such:
	 *  MinStack obj = new MinStack();
	 *  obj.push(x);
	 *  obj.pop();
	 *  int param_3 = obj.top();
	 *  int param_4 = obj.getMin();
	 */
	public class MinStack {
		public class Entry {
			int val;
			int minVal;
			public Entry(int v, int min) {
				this.val = v;
				this.minVal = min;
			}
		}
		int topIndex = -1;
		List<Entry> array = null;
	    /** initialize your data structure here. */
	    public MinStack() {
	    	topIndex = -1;
	        array = new ArrayList<>();
	    }
	    
	    public void push(int x) {
	        if (array.size() == 0) {
	        	array.add(new Entry(x, x));
	        } else {
	        	int min = array.get(0).minVal;
	        	for (int i = 1; i < array.size(); ++i) {
	        		Entry e = array.get(i);
	        		if (e.minVal < min) {
	        			min = e.minVal;
	        		}
	        	}
	        	array.add(new Entry(x, Math.min(x, min)));
	        }
	        ++topIndex;
	    }
	    
	    public void pop() {
	    	array.remove(topIndex);
	        --topIndex;
	    }
	    
	    public int top() {
	        return array.get(topIndex).val;
	    }
	    
	    public int getMin() {
	        return array.get(topIndex).minVal;
	    }
	}
	
	/**
	 *  [Easy]
	 *  #160. Intersection of Two Linked Lists
	 *  
	 *  Write a program to find the node at which the intersection of two singly linked lists begins.
	 *  
	 *  For example, the following two linked lists:
	 *  A:       a1 -> a2
	 *                  \
	 *                  c1 -> c2 -> c3
	 *                  /            
	 *  B: b1 -> b2 -> b3
	 *  begin to intersect at node c1.
	 *  
	 *  Notes:
	 *  If the two linked lists have no intersection at all, return null.
	 *  The linked lists must retain their original structure after the function returns.
	 *  You may assume there are no cycles anywhere in the entire linked structure.
	 *  Your code should preferably run in O(n) time and use only O(1) memory.
	 */
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (!this.getIntersectionNode_hasIntersection(headA, headB)) return null;
		int len1 = this.getIntersectionNode_getLength(headA);
		int len2 = this.getIntersectionNode_getLength(headB);
		
		ListNode list1 = len1 > len2 ? headA : headB;
		ListNode list2 = len1 > len2 ? headB : headA;
		int delta = Math.abs(len1 - len2);
		int i = 0;
		while (i < delta) {
			list1 = list1.next;
			++i;
		}
		while (list1 != list2) {
			list1 = list1.next;
			list2 = list2.next;
		}
		return list1;
    }
	
	public boolean getIntersectionNode_hasIntersection(ListNode l1, ListNode l2) {
		if (l1 == null || l2 == null) return false;
		ListNode n1 = l1;
		while (n1.next != null) {
			n1 = n1.next;
		}
		ListNode n2 = l2;
		while (n2.next != null) {
			n2 = n2.next;
		}
		return n1 == n2;
	}
	
	public int getIntersectionNode_getLength(ListNode list) {
		int length = 0;
		while (list != null) {
			++length;
			list = list.next;
		}
		return length;
	}
	
	/**
	 *  [Easy]
	 *  #165. Compare Version Numbers
	 *  
	 *  Compare two version numbers version1 and version2.
	 *  If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.
	 *  
	 *  You may assume that the version strings are non-empty and contain only digits and the . character.
	 *  The . character does not represent a decimal point and is used to separate number sequences.
	 *  For instance, 2.5 is not "two and a half" or "half way to version three", 
	 *  it is the fifth second-level revision of the second first-level revision.
	 *  Here is an example of version numbers ordering:
	 *  0.1 < 1.1 < 1.2 < 13.37
	 */
	public int compareVersion(String version1, String version2) {
		String[] ver1Strs = version1.split("[.]");
		String[] ver2Strs = version2.split("[.]");
		int i = 0;
		while (i < ver1Strs.length && i < ver2Strs.length) {
			int val1 = Integer.parseInt(ver1Strs[i]);
			int val2 = Integer.parseInt(ver2Strs[i]);
			if (val1 > val2) return 1;
			if (val1 < val2) return -1;
			++i;
		}
		while (i < ver1Strs.length) {
			if (Integer.parseInt(ver1Strs[i++]) != 0) {
				return 1;
			}
		}
		while (i < ver2Strs.length) {
			if (Integer.parseInt(ver2Strs[i++]) != 0) {
				return -1;
			}
		}
        return 0;
    }
	
	/**
	 *  [Easy]
	 *  #168. Excel Sheet Column Title
	 *  
	 *  Given a positive integer, return its corresponding column title as appear in an Excel sheet.
	 *  
	 *  For example:
	 *  1 -> A
	 *  2 -> B
	 *  3 -> C
	 *  ...
	 *  26 -> Z
	 *  27 -> AA
	 *  28 -> AB 
	 */
	public String convertToTitle(int n) {
		StringBuilder sb = new StringBuilder();
		char c = (char) ((n - 1) % 26 + 65);
		sb.append(c);
		int value = n - (c - 64);
		while (value / 26 != 0) {
			value = value / 26;
			c = (char) ((value - 1) % 26 + 65);
			sb.append(c);
			value = value - (c - 64);
		}
		return sb.reverse().toString();
    }
	
	/**
	 *  [Easy]
	 *  #169. Majority Element
	 *  
	 *  Given an array of size n, find the majority element. The majority element is the element that appears more than (n/2) times.
	 *  You may assume that the array is non-empty and the majority element always exist in the array.
	 */
	public int majorityElement(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; ++i) {
			if (map.containsKey(nums[i])) {
				int val = map.get(nums[i]);
				map.put(nums[i], ++val);
			} else {
				map.put(nums[i], 1);
			}
		}
		int t = (int) Math.floor(nums.length / 2);
		Set<Integer> set = map.keySet();
		Iterator<Integer> it = set.iterator();
		while (it.hasNext()) {
			int key = it.next();
			int times = map.get(key);
			if (times > t) {
				return key;
			}
		}
        return 0;
    }
	
	/**
	 *  [Easy]
	 *  #171. Excel Sheet Column Number
	 *  
	 *  Related to question Excel Sheet Column Title
	 *  Given a column title as appear in an Excel sheet, return its corresponding column number.
	 *  
	 *  For example:
	 *  A -> 1
	 *  B -> 2
	 *  C -> 3
	 *  ...
	 *  Z -> 26
	 *  AA -> 27
	 *  AB -> 28 
	 */
	public int titleToNumber(String s) {
		int result = 0;
		int carry = 0;
		int factor = (int) Math.pow(26, carry);
		for (int i = s.length() - 1; i >= 0; --i) {
			result += factor * (int)(s.charAt(i) - 64);
			++carry;
			factor = (int) Math.pow(26, carry);
		}
        return result;
    }
	
	/**
	 *  [Easy]
	 *  #172. Factorial Trailing Zeroes
	 *  
	 *  Given an integer n, return the number of trailing zeroes in n!.
	 *  Note: Your solution should be in logarithmic time complexity.
	 */
	public int trailingZeroes(int n) {
		int result = 0;
		int value = n;
		while (value / 5 != 0) {
			result += value / 5;
			value = value / 5;
		}
        return result;
    }
	
	/**
	 *  [Easy]
	 *  #189. Rotate Array
	 *  
	 *  Rotate an array of n elements to the right by k steps.
	 *  
	 *  For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
	 *  
	 *  Note:
	 *  Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
	 *  
	 *  Hint:
	 *  Could you do it in-place with O(1) extra space?
	 *  Related problem: Reverse Words in a String II
	 */
	public void rotate(int[] nums, int k) {
		if (nums.length == 0 || k == 0) return;
		int length = nums.length;
		int count = 0;
		for (int j = 0; j < k; ++j) {
			int i = j;
			int next = nums[i];
			do {
				i = (i + k) % length;
				int temp = nums[i];
				nums[i] = next;
				next = temp;
				++count;
			} while (i != j);
			if (count == length) break; // important!
		}
    }
	
	/**
	 *  [Easy]
	 *  #190. Reverse Bits
	 *  
	 *  Reverse bits of a given 32 bits unsigned integer.
	 *  
	 *  For example, 
	 *  given input 43261596 (represented in binary as 00000010100101000001111010011100), 
	 *  return 964176192 (represented in binary as 00111001011110000010100101000000).
	 *  
	 *  Follow up:
	 *  If this function is called many times, how would you optimize it?
	 *  
	 *  Related problem: Reverse Integer
	 */
	// you need treat n as an unsigned value
    public int reverseBits(int n) {
    	long value = n & 0x7FFFFFFF;
    	long keyH = 2147483648L;
    	long keyL = 1L;
    	int result = 0;
    	while (value > 0) {
    		int carry = (int) (value / keyH);
    		if (carry > 0) {
    			result += carry * keyL;
    			value -= carry * keyH;
    		}
    		keyH = keyH >> 1;
    		keyL = keyL << 1;
    	}
    	if ((n & 0x80000000) == 0x80000000) ++result;
        return result;
    }
    
    /**
     *  [Easy]
     *  #191. Number of 1 Bits
     *  
     *  Write a function that takes an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).
     *  For example, the 32-bit integer '11' has binary representation 00000000000000000000000000001011, so the function should return 3.
     */
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
    	int result = 0;
    	if ((n & 0x80000000) == 0x80000000) ++result;
    	long value = n & 0x7FFFFFFF;
    	long key = 2147483648L;
    	while (value > 0) {
    		int carry = (int) (value / key);
    		if (carry > 0) {
    			++result;
    			value -= carry * key;
    		}
    		key = key >> 1;
    	}
        return result;
    }
    
    /**
     *  [Easy]
     *  #202. Happy Number
     *  
     *  Write an algorithm to determine if a number is "happy".
     *  A happy number is a number defined by the following process: Starting with any positive integer, 
     *  replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 
     *  (where it will stay), or it loops endlessly in a cycle which does not include 1. 
     *  Those numbers for which this process ends in 1 are happy numbers.
     *  
     *  Example: 19 is a happy number
     *  1^2 + 9^2 = 82
     *  8^2 + 2^2 = 68
     *  6^2 + 8^2 = 100
     *  1^2 + 0^2 + 0^2 = 1
     */
    public boolean isHappy(int n) {
    	String input = Integer.toString(n);
    	Set<Integer> set = new HashSet<>();
    	int total = 0;
    	while (total != 1) {
    		if (set.contains(total)) {
    			return false;
    		}
    		set.add(total);
    		total = 0;
        	for (int i = 0; i < input.length(); ++i) {
        		int value = input.charAt(i) - 48;
        		total += value * value;
        	}
        	input = Integer.toString(total);
    	}
        return true;
    }
    
    /**
     *  [Easy]
     *  #203. Remove Linked List Elements
     *  
     *  Remove all elements from a linked list of integers that have value val.
     *  
     *  Example
     *  Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
     *  Return: 1 --> 2 --> 3 --> 4 --> 5
     */
    public ListNode removeElements(ListNode head, int val) {
    	if (head == null) return null;
    	ListNode node = head;
    	while (node != null && node.val == val) {
    		// find the first element the value of which does not equals to val
    		node = node.next;
    	}
    	ListNode prev = node;
    	ListNode curr = null;
    	while (prev != null) {
    		curr = prev.next;
    		while (curr != null && curr.val == val) {
    			curr = curr.next;
    		}
    		prev.next = curr;
    		prev = curr;
    	}
        return node;
    }
    
    /**
     *  [Easy]
     *  #204. Count Primes
     *  
     *  Description:
     *  Count the number of prime numbers less than a non-negative number, n.
     *  
     *  Hint:
     *  1. Let's start with a isPrime function. To determine if a number is prime, 
     *     we need to check if it is not divisible by any number less than n. 
     *     The runtime complexity of isPrime function would be O(n) and hence counting the total prime numbers 
     *     up to n would be O(n2). Could we do better?
     *     
     *  2. As we know the number must not be divisible by any number > n / 2, 
     *     we can immediately cut the total iterations half by dividing only up to n / 2. Could we still do better?
     *     
     *  3. Let's write down all of 12's factors:
     *     2 * 6 = 12
     *     3 * 4 = 12
     *     4 * 3 = 12
     *     6 * 2 = 12
     *     As you can see, calculations of 4 * 3 and 6 * 2 are not necessary. 
     *     Therefore, we only need to consider factors up to sqrt(n) because, if n is divisible by some number p, 
     *     then n = p * q and since p <= q, we could derive that p <= sqrt(n).
     *     Our total runtime has now improved to O(n^1.5), which is slightly better. Is there a faster approach?
     *     
     *     public int countPrimes(int n) {
     *        int count = 0;
     *        for (int i = 1; i < n; i++) {
     *           if (isPrime(i)) count++;
     *        }
     *        return count;
     *     }
     *
     *     private boolean isPrime(int num) {
     *        if (num <= 1) return false;
     *        // Loop's ending condition is i * i <= num instead of i <= sqrt(num)
     *        // to avoid repeatedly calling an expensive function sqrt().
     *        for (int i = 2; i * i <= num; i++) {
     *           if (num % i == 0) return false;
     *        }
     *        return true;
     *     }
     *     
     *  4. The Sieve of Eratosthenes is one of the most efficient ways to find all prime numbers up to n. 
     *     But don't let that name scare you, I promise that the concept is surprisingly simple
     *     
     *     Sieve of Eratosthenes: algorithm steps for primes below 121. 
     *     "Sieve of Eratosthenes Animation" by SKopp is licensed under CC BY 2.0.
     *     
     *     We start off with a table of n numbers. Let's look at the first number, 2. We know all multiples of 2 must not be primes, 
     *     so we mark them off as non-primes. Then we look at the next number, 3. Similarly, all multiples of 3 such as 3 脳 2 = 6, 
     *     3 脳 3 = 9, ... must not be primes, so we mark them off as well. Now we look at the next number, 4, 
     *     which was already marked off. What does this tell you? Should you mark off all multiples of 4 as well?
     *     
     *  5. 4 is not a prime because it is divisible by 2, which means all multiples of 4 must also be divisible by 2 
     *     and were already marked off. So we can skip 4 immediately and go to the next number, 5. 
     *     Now, all multiples of 5 such as 5 脳 2 = 10, 5 脳 3 = 15, 5 脳 4 = 20, 5 脳 5 = 25, ... can be marked off. 
     *     There is a slight optimization here, we do not need to start from 5 脳 2 = 10. Where should we start marking off?
     *     
     *  6. In fact, we can mark off multiples of 5 starting at 5 脳 5 = 25, because 5 脳 2 = 10 was already marked off by multiple of 2, 
     *     similarly 5 脳 3 = 15 was already marked off by multiple of 3. Therefore, if the current number is p, 
     *     we can always mark off multiples of p starting at p2, then in increments of p: p2 + p, p2 + 2p, ... 
     *     Now what should be the terminating loop condition?
     *     
     *  7. It is easy to say that the terminating loop condition is p < n, which is certainly correct but not efficient. 
     *     Do you still remember Hint #3?
     *     
     *  8. Yes, the terminating loop condition can be p < 鈭歯, as all non-primes 鈮� 鈭歯 must have already been marked off. 
     *     When the loop terminates, all the numbers in the table that are non-marked are prime.
     *     The Sieve of Eratosthenes uses an extra O(n) memory and its runtime complexity is O(n log log n). 
     *     For the more mathematically inclined readers, you can read more about its algorithm complexity on Wikipedia.
     *     
     *     public int countPrimes(int n) {
     *        boolean[] isPrime = new boolean[n];
     *        for (int i = 2; i < n; i++) {
     *           isPrime[i] = true;
     *        }
     *        // Loop's ending condition is i * i < n instead of i < sqrt(n)
     *        // to avoid repeatedly calling an expensive function sqrt().
     *        for (int i = 2; i * i < n; i++) {
     *           if (!isPrime[i]) continue;
     *           for (int j = i * i; j < n; j += i) {
     *              isPrime[j] = false;
     *           }
     *        }
     *        int count = 0;
     *        for (int i = 2; i < n; i++) {
     *           if (isPrime[i]) count++;
     *        }
     *        return count;
     *     }
     */
//    public List<Integer> countPrimes_list = new ArrayList<>();
//    public int countPrimes(int n) {
//    	if (countPrimes_list.size() == 0) {
//    		countPrimes_list.add(0);
//    	}
//    	if (n >= countPrimes_list.size()) {
//    		for (int i = countPrimes_list.size(); i < n + 1; ++i) {
//    			int count = countPrimes_list.get(i - 1);
//    			if (this.countPrimes_isPrime(i - 1)) {
//    				countPrimes_list.add(count + 1);
//    			} else {
//    				countPrimes_list.add(count);
//    			}
//    		}
//    	}
//    	if (n < countPrimes_list.size()) {
//    		return countPrimes_list.get(n);
//    	}
//        return 0;
//    }
//    public boolean countPrimes_isPrime(int n) {
//    	if (n == 0 || n == 1) return false;
//    	for (int i = 2; i * i <= n; ++i) {
//    		if (n % i == 0) return false;
//    	}
//    	return true;
//    }
    public int countPrimes(int n) {
    	boolean[] nums = new boolean[n];
    	for (int i = 2; i < n; ++i) {
    		nums[i] = true;
    	}
    	int p = 2;
    	while (p * p < n) {
    		if (nums[p]) {
    			int i = p * p;
            	while (i < n) {
            		nums[i] = false;
            		i += p;
            	}
    		}
        	++p;
    	}
    	int count = 0;
    	for (int j = 0; j < n; ++j) {
    		if (nums[j]) ++count;
    	}
    	return count;
    }
    
    /**
     *  [Easy]
     *  #205. Isomorphic Strings
     *  
     *  Given two strings s and t, determine if they are isomorphic.
     *  Two strings are isomorphic if the characters in s can be replaced to get t.
     *  All occurrences of a character must be replaced with another character while preserving the order of characters. 
     *  No two characters may map to the same character but a character may map to itself.
     *  
     *  For example,
     *  Given "egg", "add", return true.
     *  Given "foo", "bar", return false.
     *  Given "paper", "title", return true.
     *  
     *  Note:
     *  You may assume both s and t have the same length.
     */
    public boolean isIsomorphic(String s, String t) {
        return isIsomorphic_two(s, t) && isIsomorphic_two(t, s);
    }
    public boolean isIsomorphic_two(String str1, String str2) {
    	Map<Character, Character> map = new HashMap<>();
    	StringBuilder sb = new StringBuilder();
    	for (int i = 0; i < str1.length(); ++i) {
    		char c1 = str1.charAt(i);
    		if (!map.containsKey(c1)) {
    			char c2 = str2.charAt(i);
    			map.put(c1, c2);
    			sb.append(c2);
    		} else {
    			sb.append(map.get(c1));
    		}
    	}
    	return sb.toString().equals(str2);
    }
    
    /**
     *  [Easy]
     *  #206. Reverse Linked List
     *  
     *  Reverse a singly linked list.
     *  
     *  Hint:
     *  A linked list can be reversed either iteratively or recursively. Could you implement both?
     */
    public ListNode reverseList(ListNode head) {
    	//return reverseList_recursive(head);
    	return reverseList_interative(head);
    }
    public ListNode reverseList_recursive(ListNode node) {
    	if (node == null || node.next == null) {
    		return node;
    	} else {
    		ListNode tail = node.next;
    		ListNode head = reverseList(node.next);
    		tail.next = node;
    		node.next = null;
    		return head;
    	}
    }
    public ListNode reverseList_interative(ListNode node) {
    	ListNode tail = node;
    	while (tail != null && tail.next != null) {
    		tail = tail.next;
    	}
    	ListNode head = tail;
    	
    	ListNode tailNew = head;
    	while (node != null && node.next != null) {
    		ListNode tailOld = node;
    		while (tailOld.next != tailNew) {
    			tailOld = tailOld.next;
    		}
    		tailNew.next = tailOld;
    		tailNew = tailOld;
    		tailNew.next = null;
    	}
    	return head;
    }
    
    /**
     *  [Easy]
     *  #217. Contains Duplicate
     *  
     *  Given an array of integers, find if the array contains any duplicates. 
     *  Your function should return true if any value appears at least twice in the array, 
     *  and it should return false if every element is distinct.
     */
    public boolean containsDuplicate(int[] nums) {
    	Set<Integer> set = new HashSet<>();
    	if (nums == null) return false;
    	for (int i = 0; i < nums.length; ++i) {
    		if (set.contains(nums[i])) {
    			return true;
    		}
    		else {
    			set.add(nums[i]);
    		}
    	}
        return false;
    }
    
    /**
     *  [Easy]
     *  #219. Contains Duplicate II
     *  
     *  Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array 
     *  such that nums[i] = nums[j] and the difference between i and j is at most k.
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
    	Map<Integer, Integer> map = new HashMap<>();
    	if (nums == null) return false;
    	for (int i = 0; i < nums.length; ++i) {
    		if (map.containsKey(nums[i])) {
    			int j = map.get(nums[i]);
    			if (Math.abs(j - i) <= k) {
    				return true;
    			}
    			else {
    				map.put(nums[i], i);
    			}
    		} else {
    			map.put(nums[i], i);
    		}
    	}
        return false;
    }
    
    /**
     *  [Easy]
     *  #223. Rectangle Area
     *  
     *  Find the total area covered by two rectilinear rectangles in a 2D plane.
     *  Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.
     *  
     *  Assume that the total area is never beyond the maximum possible value of int.
     */
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
    	//if (E > C || G < A || F > D || H < B) return 0;
    	if (A == C || B == D) return computeArea_two(E, F, G, H);
    	if (E == G || F == H) return computeArea_two(A, B, C, D);
    	
    	int area1 = computeArea_two(A, B, C, D);
    	int area2 = computeArea_two(E, F, G, H);
    	if (E > C || G < A || F > D || H < B) {
    		return area1 + area2;
    	}
    	
		int x1 = A;
    	if (A <= E && E <= C) x1 = E;
    	int x2 = C;
    	if (A <= G && G <= C) x2 = G;
    	
    	int y1 = B;
    	if (B <= F && F <= D) y1 = F;
    	int y2 = D;
    	if (B <= H && H <= D) y2 = H;
    	
    	int comm = computeArea_two(x1, y1, x2, y2);
        return area1 + area2 - comm;
    }
    public int computeArea_two(int x1, int y1, int x2, int y2) {
    	return Math.abs(x1 - x2) * Math.abs(y1 - y2);
    }
    
    /**
     *  [Easy]
     *  #225. Implement Stack using Queues
     *  Implement the following operations of a stack using queues.
     *    push(x) -- Push element x onto stack.
     *    pop() -- Removes the element on top of the stack.
     *    top() -- Get the top element.
     *    empty() -- Return whether the stack is empty.
     *    
     *  Notes:
     *  You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
     *  Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
     *  You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
     *  
     *  Update (2015-06-11):
     *  The class name of the Java function had been updated to MyStack instead of Stack.
     */
    class MyStack {
    	Deque<Integer> deque = new ArrayDeque<>();
        // Push element x onto stack.
        public void push(int x) {
            deque.addLast(x);
        }

        // Removes the element on top of the stack.
        public void pop() {
            deque.pollLast();
        }

        // Get the top element.
        public int top() {
            return deque.peekLast();
        }

        // Return whether the stack is empty.
        public boolean empty() {
            return deque.isEmpty();
        }
    }
    
    /**
     *  [Easy]
     *  #226. Invert Binary Tree
     *  Invert a binary tree.
     *  
     *       4
     *     /   \
     *    2     7
     *   / \   / \
     *  1   3 6   9
     *  
     *  to
     *       4
     *     /   \
     *    7     2
     *   / \   / \
     *  9   6 3   1
     */
    public TreeNode invertTree(TreeNode root) {
    	if (root == null) return root;
    	Deque<TreeNode> queue = new ArrayDeque<>();
    	queue.addLast(root);
    	while (!queue.isEmpty()) {
    		TreeNode node = queue.pollFirst();
    		TreeNode temp = node.left;
    		node.left = node.right;
    		node.right = temp;
    		if (node.left != null) queue.addLast(node.left);
    		if (node.right != null) queue.addLast(node.right);
    	}
        return root;
    }
    
    /**
     *  [Easy]
     *  #231. Power of Two
     *  
     *  Given an integer, write a function to determine if it is a power of two.
     */
    public boolean isPowerOfTwo(int n) {
    	if (n == 0) return false;
        int value = n;
        while (value % 2 == 0) {
        	value = value / 2;
        }
        return value == 1;
    }
    
    /** 
     *  [Easy]
     *  #232. Implement Queue using Stacks
     *  
     *  Implement the following operations of a queue using stacks.
     *    push(x) -- Push element x to the back of queue.
     *    pop() -- Removes the element from in front of queue.
     *    peek() -- Get the front element.
     *    empty() -- Return whether the queue is empty.
     *  
     *  Notes:
     *  You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
     *  Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
     *  You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).
     */
    class MyQueue {
        // Push element x to the back of queue.
    	Stack<Integer> stackIn = new Stack<>();
    	Stack<Integer> stackOut = new Stack<>();
        public void push(int x) {
            while (stackOut.size() != 0) {
            	stackIn.push(stackOut.pop());
            }
            stackIn.push(x);
        }

        // Removes the element from in front of queue.
        public void pop() {
            while (stackIn.size() != 0) {
            	stackOut.push(stackIn.pop());
            }
            stackOut.pop();
        }

        // Get the front element.
        public int peek() {
        	while (stackIn.size() != 0) {
        		stackOut.push(stackIn.pop());
        	}
            return stackOut.peek();
        }

        // Return whether the queue is empty.
        public boolean empty() {
            return stackIn.isEmpty() && stackOut.isEmpty();
        }
    }
    
    /**
     *  [Easy]
     *  #234. Palindrome Linked List
     *  
     *  Given a singly linked list, determine if it is a palindrome.
     *  
     *  Follow up:
     *  Could you do it in O(n) time and O(1) space?
     */
    public boolean isPalindrome(ListNode head) {
    	//return isPalindrome_On_On(head);
    	return isPalindrome_On_O1(head);
    }
    // O(n) time and O(n) space
    public boolean isPalindrome_On_On(ListNode head) {
    	int length = 0;
    	ListNode node = head;
    	while (node != null) {
    		++length;
    		node = node.next;
    	}
    	int[] nums = new int[length];
    	node = head;
    	int j = 0;
    	while (node != null) {
    		nums[j++] = node.val;
    		node = node.next;
    	}
    	for (int i = 0; i < length / 2; ++i) {
    		if (nums[i] != nums[length - 1 - i]) {
    			return false;
    		}
    	}
        return true;
    }
    // O(n) time and O(1) space
    public boolean isPalindrome_On_O1(ListNode head) {
    	int length = 0;
    	ListNode node = head;
    	while (node != null) {
    		++length;
    		node = node.next;
    	}
    	int index2 = (int) Math.ceil(length / 2d);
    	ListNode head2 = head;
    	for (int i = 0; i < index2; ++i) {
    		head2 = head2.next;
    	}
    	if (head2 != null) {
    		head2 = isPalindrome_reverseList(head2);
        	for (int j = 0; j < length / 2; ++j) {
        		if (head.val != head2.val) return false;
        		head = head.next;
        		head2 = head2.next;
        	}
    	}
    	return true;
    }
    public ListNode isPalindrome_reverseList(ListNode head) {
    	if (head.next == null) {
    		return head;
    	} else {
    		ListNode tail = head.next;
    		ListNode newHead = isPalindrome_reverseList(head.next);
    		tail.next = head;
    		head.next = null;
    		return newHead;
    	}
    }
    
    /**
     *  [Easy]
     *  #235. Lowest Common Ancestor of a Binary Search Tree
     *  
     *  Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
     *  According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w 
     *  as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”
     *  
     *          _______6______
     *         /              \
     *      ___2__          ___8__
     *     /      \        /      \
     *    0        4       7       9
     *           /  \
     *          3    5
     *           
     *  For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. Another example is LCA of nodes 2 and 4 is 2, 
     *  since a node can be a descendant of itself according to the LCA definition.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    	List<TreeNode> path1 = new ArrayList<>();
    	List<TreeNode> path2 = new ArrayList<>();
    	lowestCommonAncestor(path1, root, p);
    	lowestCommonAncestor(path2, root, q);
    	//Utility.print(path1);
    	//Utility.print(path2);
    	for (int i = path1.size() - 1; i >= 0; --i) {
    		for (int j = path2.size() - 1; j >= 0; --j) {
    			if (path1.get(i) == path2.get(j)) {
    				return path1.get(i);
    			}
    		}
    	}
        return null;
    }
    // return true if found.
    public boolean lowestCommonAncestor(List<TreeNode> path, TreeNode node, TreeNode target) {
    	if (node == null) {
    		return false;
    	} else if (node == target) {
    		path.add(node);
    		return true;
    	}else {
    		path.add(node);
    		if (lowestCommonAncestor(path, node.left, target)) return true;
    		if (lowestCommonAncestor(path, node.right, target)) return true;
    		path.remove(node);
    		return false;
    	}
    }
    
    /**
     *  [Easy]
     *  #237. Delete Node in a Linked List
     *  
     *  Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
     *  Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, 
     *  the linked list should become 1 -> 2 -> 4 after calling your function.
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
    
    /**
     *  [Easy]
     *  #242. Valid Anagram
     *  
     *  Given two strings s and t, write a function to determine if t is an anagram of s.
     *  
     *  For example,
     *  s = "anagram", t = "nagaram", return true.
     *  s = "rat", t = "car", return false.
     *  
     *  Note:
     *  You may assume the string contains only lowercase alphabets.
     */
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
        	char c = s.charAt(i);
        	if (!map.containsKey(c)) {
        		map.put(c, 1);
        	} else {
        		int v = map.get(c);
        		map.put(c, ++v);
        	}
        }
        for (int j = 0; j < t.length(); ++j) {
        	char c = t.charAt(j);
        	if (!map.containsKey(c)) {
        		return false;
        	} else {
        		int v = map.get(c);
        		map.put(c, --v);
        	}
        }
        Iterator<Character> it = map.keySet().iterator();
        while (it.hasNext()) {
        	if (map.get(it.next()) != 0) {
        		return false;
        	}
        }
        return true;
    }
}
