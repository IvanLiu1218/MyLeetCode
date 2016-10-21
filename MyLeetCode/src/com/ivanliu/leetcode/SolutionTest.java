package com.ivanliu.leetcode;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.ivanliu.leetcode.Solution.MinStack;
import com.ivanliu.leetcode.Utility.ListNode;
import com.ivanliu.leetcode.Utility.TreeNode;

public class SolutionTest {
	private Solution solution = new Solution();
	
	@Test
	public void test001() {
		assertArrayEquals(new int[] {0,1}, solution.twoSum(new int[] {2,7,11,15}, 9));
		assertArrayEquals(new int[] {0,3}, solution.twoSum(new int[] {2,7,11,4}, 6));
		assertArrayEquals(new int[] {1,2}, solution.twoSum(new int[] {3,2,4}, 6));
	}
	
	@Test
	public void test002() {
		ListNode l1 = Utility.buildListNode(new int[] {2,4,3});
		ListNode l2 = Utility.buildListNode(new int[] {5,6,4});
		ListNode result = solution.addTwoNumbers(l1, l2);
		assertEquals("[7,0,8]", Utility.toString(result));
		
		l1 = Utility.buildListNode(new int[] {9,9,9,9,9,9,9});
		l2 = Utility.buildListNode(new int[] {1});
		result = solution.addTwoNumbers(l1, l2);
		assertEquals("[0,0,0,0,0,0,0,1]", Utility.toString(result));
		
		l1 = Utility.buildListNode(new int[] {1});
		l2 = Utility.buildListNode(new int[] {9,9,9,9,9,9,9});
		result = solution.addTwoNumbers(l1, l2);
		assertEquals("[0,0,0,0,0,0,0,1]", Utility.toString(result));
		
		l1 = Utility.buildListNode(new int[] {});
		l2 = Utility.buildListNode(new int[] {1,2,3});
		result = solution.addTwoNumbers(l1, l2);
		assertEquals("[1,2,3]", Utility.toString(result));
	}
	
	@Test
	public void test003() {
		assertEquals(3, solution.lengthOfLongestSubstring("abcabcbb"));
		assertEquals(1, solution.lengthOfLongestSubstring("bbbbb"));
		assertEquals(3, solution.lengthOfLongestSubstring("pwwkew"));
		assertEquals(1, solution.lengthOfLongestSubstring("c"));
		assertEquals(3, solution.lengthOfLongestSubstring("dvdf"));
		assertEquals(2, solution.lengthOfLongestSubstring("abba"));
	}
	
	@Test
	public void test004() {
		// odd
//		assertEquals(2, solution.findMedianSortedArrays(new int[]{1,3}, new int[] {2}), 0);
//		assertEquals(3, solution.findMedianSortedArrays(new int[]{1,3,5,6}, new int[] {2}), 0);
//		assertEquals(5, solution.findMedianSortedArrays(new int[]{1,3,5,6}, new int[] {2,7,8}), 0);
		// even
//		assertEquals(2.5d, solution.findMedianSortedArrays(new int[]{1,3}, new int[] {2,4}), 0);
//		assertEquals(3.5d, solution.findMedianSortedArrays(new int[]{1,3,5,6}, new int[] {2,4}), 0);
//		assertEquals(4d, solution.findMedianSortedArrays(new int[]{1,3,5,6,7}, new int[] {2}), 0);
	}
	
	@Test
	public void test006() {
		assertEquals("PAHNAPLSIIGYIR", solution.convert("PAYPALISHIRING", 3));
		assertEquals("PINALSIGYAHRPI", solution.convert("PAYPALISHIRING", 4));
		assertEquals("PAYPALISHIRING", solution.convert("PAYPALISHIRING", 1));
		assertEquals("A", solution.convert("A", 1));
	}
	
	@Test
	public void test014() {
		assertEquals("ab", solution.longestCommonPrefix(new String[] {"abc","ab","abcd"}));
		assertEquals("a", solution.longestCommonPrefix(new String[] {"abc","ad","abcd"}));
		assertEquals("", solution.longestCommonPrefix(new String[] {}));
	}
	
	@Test
	public void test019() {
		ListNode head = Utility.buildListNode(new int[] {1,2,3,4,5,6});
		ListNode result = solution.removeNthFromEnd(head, 1);
		assertEquals("[1,2,3,4,5]", Utility.toString(result));
		
		head = Utility.buildListNode(new int[] {1,2,3,4,5,6});
		result = solution.removeNthFromEnd(head, 2);
		assertEquals("[1,2,3,4,6]", Utility.toString(result));
		
		head = Utility.buildListNode(new int[] {1,2,3,4,5,6});
		result = solution.removeNthFromEnd(head, 3);
		assertEquals("[1,2,3,5,6]", Utility.toString(result));
		
		head = Utility.buildListNode(new int[] {1,2,3,4,5,6});
		result = solution.removeNthFromEnd(head, 4);
		assertEquals("[1,2,4,5,6]", Utility.toString(result));
		
		head = Utility.buildListNode(new int[] {1,2,3,4,5,6});
		result = solution.removeNthFromEnd(head, 5);
		assertEquals("[1,3,4,5,6]", Utility.toString(result));
		
		head = Utility.buildListNode(new int[] {1,2,3,4,5,6});
		result = solution.removeNthFromEnd(head, 6);
		assertEquals("[2,3,4,5,6]", Utility.toString(result));
	}
	
	@Test
	public void test020() {
		assertEquals(true, solution.isValid("({[]})"));
		assertEquals(true, solution.isValid("({[][]}())"));
		assertEquals(false, solution.isValid("({[][}]())"));
		assertEquals(false, solution.isValid("]"));
		assertEquals(false, solution.isValid("(])"));
	}
	
	@Test
	public void test022() {
		List<String> result = solution.generateParenthesis(3);
		assertEquals(5, result.size());
		assertEquals("[((())), (()()), (())(), ()(()), ()()()]", Arrays.toString(result.toArray()));
	}
	
	@Test
	public void test028() {
		assertEquals(3, solution.strStr("abcdefg", "def"));
		assertEquals(0, solution.strStr("abcdefg", "abc"));
		assertEquals(1, solution.strStr("aabcdefg", "abc"));
		assertEquals(-1, solution.strStr("abcdefg", "abd"));
		assertEquals(0, solution.strStr("a", "a"));
		assertEquals(-1, solution.strStr("a", "ab"));
		assertEquals(0, solution.strStr("ab", "ab"));
		assertEquals(0, solution.strStr("", ""));
		assertEquals(-1, solution.strStr("aaa", "aaaa"));
		assertEquals(-1, solution.strStr("aaaa", "aaab"));
	}
	
	@Test
	public void test036() {
		char[][] board = new char[][] { {'5','3','.','.','7','.','.','.','.'},
			                            {'6','.','.','1','9','5','.','.','.'},
			                            {'.','9','8','.','.','.','.','.','.'},
			                            {'8','.','.','.','6','.','.','.','3'},
			                            {'4','.','.','8','.','3','.','.','1'},
			                            {'7','.','.','.','2','.','.','.','6'},
			                            {'.','6','.','.','.','.','2','8','.'},
			                            {'.','.','.','4','1','9','.','.','5'},
			                            {'.','.','.','.','8','.','.','7','9'},
			                          };
		assertEquals(true, solution.isValidSudoku(board));
	}
	
	@Test
	public void test038() {
		assertEquals("1", solution.countAndSay(1));
		assertEquals("11", solution.countAndSay(2));
		assertEquals("21", solution.countAndSay(3));
		assertEquals("1211", solution.countAndSay(4));
		assertEquals("111221", solution.countAndSay(5));
		assertEquals("312211", solution.countAndSay(6));
		assertEquals("13112221", solution.countAndSay(7));
		assertEquals("1113213211", solution.countAndSay(8));
	}

	@Test
	public void test067() {
		assertEquals("100", solution.addBinary("1", "11"));
		assertEquals("100", solution.addBinary("11", "1"));
		assertEquals("110", solution.addBinary("101", "1"));
	}
	
	@Test
	public void test107() {
		TreeNode head = new TreeNode(3);
		head.left = new TreeNode(9);
		head.right = new TreeNode(20);
		head.right.left = new TreeNode(15);
		head.right.right = new TreeNode(7);
		List<List<Integer>> result = solution.levelOrderBottom(head);
		assertEquals(3, result.size());
		assertEquals("[15, 7]", Arrays.toString(result.get(0).toArray()));
		assertEquals("[9, 20]", Arrays.toString(result.get(1).toArray()));
		assertEquals("[3]", Arrays.toString(result.get(2).toArray()));
		
		head = new TreeNode(3);
		head.left = new TreeNode(9);
		head.right = new TreeNode(20);
		head.left.left = new TreeNode(15);
		head.right.right = new TreeNode(7);
		result = solution.levelOrderBottom(head);
		assertEquals(3, result.size());
		assertEquals("[15, 7]", Arrays.toString(result.get(0).toArray()));
		assertEquals("[9, 20]", Arrays.toString(result.get(1).toArray()));
		assertEquals("[3]", Arrays.toString(result.get(2).toArray()));
		
		head = new TreeNode(3);
		head.right = new TreeNode(20);
		head.right.left = new TreeNode(15);
		head.right.right = new TreeNode(7);
		result = solution.levelOrderBottom(head);
		assertEquals(3, result.size());
		assertEquals("[15, 7]", Arrays.toString(result.get(0).toArray()));
		assertEquals("[20]", Arrays.toString(result.get(1).toArray()));
		assertEquals("[3]", Arrays.toString(result.get(2).toArray()));
	}
	
	@Test
	public void test110() {
		TreeNode head = new TreeNode(0);
		head.left = new TreeNode(1);
		head.right = new TreeNode(1);
		head.right.left = new TreeNode(2);
		head.right.right = new TreeNode(2);
		head.right.right.right = new TreeNode(3);
		assertEquals(false, solution.isBalanced(head));
		
		head = new TreeNode(0);
		head.left = new TreeNode(1);
		head.right = new TreeNode(1);
		head.right.left = new TreeNode(2);
		head.right.right = new TreeNode(2);
		assertEquals(true, solution.isBalanced(head));
		
		head = new TreeNode(1);
		head.left = new TreeNode(2);
		head.left.left = new TreeNode(3);
		head.left.left.left = new TreeNode(4);
		head.right = new TreeNode(2);
		head.right.right = new TreeNode(3);
		head.right.right.right = new TreeNode(4);
		assertEquals(false, solution.isBalanced(head));
	}
	
	@Test
	public void test125() {
		assertEquals(true, solution.isPalindrome("A man, a plan, a canal: Panama"));
		assertEquals(false, solution.isPalindrome("race a car"));
		assertEquals(false, solution.isPalindrome("0P"));
	}
	
	@Test
	public void test155() {
		MinStack minStack = solution.new MinStack();
		minStack.push(4);
		assertEquals(4, minStack.top());
		assertEquals(4, minStack.getMin());
		minStack.push(-1);
		assertEquals(-1, minStack.top());
		assertEquals(-1, minStack.getMin());
		minStack.push(2);
		assertEquals(2, minStack.top());
		assertEquals(-1, minStack.getMin());
		minStack.push(0);
		assertEquals(0, minStack.top());
		assertEquals(-1, minStack.getMin());
		minStack.pop();
		assertEquals(2, minStack.top());
		assertEquals(-1, minStack.getMin());
		minStack.pop();
		assertEquals(-1, minStack.top());
		assertEquals(-1, minStack.getMin());
		minStack.pop();
		assertEquals(4, minStack.top());
		assertEquals(4, minStack.getMin());
		
	}
	
	@Test
	public void test160() {
		ListNode com = Utility.buildListNode(new int[] {1,2,3});
		ListNode headA = new ListNode(1, com);
		ListNode headB = new ListNode(1, new ListNode(1, com));
		assertEquals(com, solution.getIntersectionNode(headA, headB));
		
		headA = new ListNode(1, new ListNode(1, new ListNode(1, com)));
		headB = new ListNode(1, com);
		assertEquals(com, solution.getIntersectionNode(headA, headB));
		
		headA = new ListNode(1, new ListNode(1, new ListNode(1, com)));
		headB = new ListNode(1, new ListNode(1, com.next));
		assertEquals(com.next, solution.getIntersectionNode(headA, headB));
		
		// no intersection
		headA = Utility.buildListNode(new int[] {1,2,3});
		headB = Utility.buildListNode(new int[] {4,5,6});
		assertEquals(null, solution.getIntersectionNode(headA, headB));
	}
	
	@Test
	public void test165() {
		assertEquals(1, solution.compareVersion("1.1", "0.1"));
		assertEquals(0, solution.compareVersion("1.1", "1.1"));
		assertEquals(-1, solution.compareVersion("0.1", "1.1"));
		assertEquals(1, solution.compareVersion("1.21.1", "1.11.34"));
		assertEquals(1, solution.compareVersion("1.11.33", "1.11.3"));
		assertEquals(-1, solution.compareVersion("1.11.3", "1.12.32"));
		assertEquals(-1, solution.compareVersion("1", "1.1"));
		assertEquals(0, solution.compareVersion("1", "1.0"));
		assertEquals(0, solution.compareVersion("1.0.0", "1"));
		assertEquals(1, solution.compareVersion("1.0.0.1", "1"));
		assertEquals(-1, solution.compareVersion("1", "1.0.1"));
	}
	
	@Test
	public void test168() {
		assertEquals("A", solution.convertToTitle(1));
		assertEquals("Z", solution.convertToTitle(26));
		assertEquals("AA", solution.convertToTitle(27));
		assertEquals("AZ", solution.convertToTitle(52));
		assertEquals("BA", solution.convertToTitle(53));
		assertEquals("AAA", solution.convertToTitle(703));
		assertEquals("AAZ", solution.convertToTitle(728));
		assertEquals("ZY", solution.convertToTitle(701));
	}
	
	@Test
	public void test169() {
		assertEquals(1, solution.majorityElement(new int[] {1,1,1,2,3}));
		assertEquals(2, solution.majorityElement(new int[] {1,2,4,2,2}));
	}
	
	@Test
	public void test171() {
		assertEquals(1, solution.titleToNumber("A"));
		assertEquals(26, solution.titleToNumber("Z"));
		assertEquals(28, solution.titleToNumber("AB"));
		assertEquals(701, solution.titleToNumber("ZY"));
		assertEquals(703, solution.titleToNumber("AAA"));
	}
	
	@Test
	public void test172() {
		assertEquals(1, solution.trailingZeroes(6));
		assertEquals(2, solution.trailingZeroes(10));
		assertEquals(3, solution.trailingZeroes(19));
		assertEquals(4, solution.trailingZeroes(22));
		assertEquals(6, solution.trailingZeroes(26));
	}
	
	@Test
	public void test189() {
		int[] nums = new int[] {1,2,3,4,5,6,7};
		solution.rotate(nums, 3);
		assertEquals("[5, 6, 7, 1, 2, 3, 4]", Arrays.toString(nums));
		
		nums = new int[] {1,2,3,4,5,6,7,8};
		solution.rotate(nums, 3);
		assertEquals("[6, 7, 8, 1, 2, 3, 4, 5]", Arrays.toString(nums));
		
		nums = new int[] {1,2,3,4,5,6};
		solution.rotate(nums, 2);
		assertEquals("[5, 6, 1, 2, 3, 4]", Arrays.toString(nums));
		
		nums = new int[] {1,2,3,4,5,6,7,8,9};
		solution.rotate(nums, 3);
		assertEquals("[7, 8, 9, 1, 2, 3, 4, 5, 6]", Arrays.toString(nums));
		
		nums = new int[] {1,2,3,4,5,6};
		solution.rotate(nums, 4);
		assertEquals("[3, 4, 5, 6, 1, 2]", Arrays.toString(nums));
	}
	
	@Test
	public void test190() {
		assertEquals(964176192, solution.reverseBits(43261596));
		assertEquals(1073741824, solution.reverseBits(2));
		assertEquals(2, solution.reverseBits(1073741824));
		long value = 2147483648L;
		assertEquals(1, solution.reverseBits((int)value));
		assertEquals((int)value, solution.reverseBits(1));
		value = 4294967295L;
		assertEquals((int)value, solution.reverseBits((int)value));
	}
	
	@Test
	public void test191() {
		assertEquals(3, solution.hammingWeight(11));
		long value = 2147483648L;  // 0x7FFF_FFFF
		assertEquals(1, solution.hammingWeight((int)value));
		value = 4294967295L;  // 0xFFFF_FFFF
		assertEquals(32, solution.hammingWeight((int)value));
	}
	
	@Test
	public void test202() {
		assertEquals(true, solution.isHappy(19));
		assertEquals(true, solution.isHappy(1));
		assertEquals(true, solution.isHappy(1000));
		assertEquals(false, solution.isHappy(17));
	}
	
	@Test
	public void test203() {
		ListNode list = null;
		assertEquals("[]", Utility.toString(solution.removeElements(list, 2)));
		list = new ListNode(1, new ListNode(2, new ListNode(3, null)));
		assertEquals("[1,3]", Utility.toString(solution.removeElements(list, 2)));
		list = new ListNode(1, new ListNode(2, new ListNode(3, null)));
		assertEquals("[2,3]", Utility.toString(solution.removeElements(list, 1)));
		list = new ListNode(2, new ListNode(2, new ListNode(3, null)));
		assertEquals("[3]", Utility.toString(solution.removeElements(list, 2)));
		list = new ListNode(2, new ListNode(2, new ListNode(2, null)));
		assertEquals("[]", Utility.toString(solution.removeElements(list, 2)));
	}
	
	@Test
	public void test204() {
		// test countPrimes_isPrime():
		assertEquals(false, solution.countPrimes_isPrime(0));
		assertEquals(false, solution.countPrimes_isPrime(1));
		assertEquals(true, solution.countPrimes_isPrime(2));
		assertEquals(true, solution.countPrimes_isPrime(3));
		assertEquals(false, solution.countPrimes_isPrime(4));
		assertEquals(true, solution.countPrimes_isPrime(5));
		assertEquals(true, solution.countPrimes_isPrime(11));
		assertEquals(false, solution.countPrimes_isPrime(12));
		assertEquals(true, solution.countPrimes_isPrime(13));
		// test countPrimes()
		assertEquals(0, solution.countPrimes(0));
		assertEquals(0, solution.countPrimes(1));
		assertEquals(0, solution.countPrimes(2));
		assertEquals(1, solution.countPrimes(3));
		assertEquals(2, solution.countPrimes(4));
		assertEquals(2, solution.countPrimes(5));
		assertEquals(3, solution.countPrimes(6));
		assertEquals(3, solution.countPrimes(7));
		assertEquals(4, solution.countPrimes(8));
		assertEquals(8, solution.countPrimes(20));
		assertEquals(7, solution.countPrimes(19));
		// Time Limit Exceeded
		assertEquals(41537, solution.countPrimes(499979));
		assertEquals(0, solution.countPrimes(999983));
	}
}
