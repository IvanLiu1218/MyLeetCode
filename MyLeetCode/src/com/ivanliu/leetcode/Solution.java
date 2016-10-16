package com.ivanliu.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
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
}
