package com.ivanliu.leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ivanliu.leetcode.Utility.ListNode;

public class UtilityTest {

	@Test
	public void test() {
		ListNode list = Utility.buildListNode(new int[] {1,2,3,4,5});
		assertEquals("[1,2,3,4,5]", Utility.toString(list));
	}

}
