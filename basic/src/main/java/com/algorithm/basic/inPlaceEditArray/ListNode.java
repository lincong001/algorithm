package com.algorithm.basic.inPlaceEditArray;

import lombok.val;

/**
 * @author linchong
 * @version 1.0
 * @Date: 2022-05-19 22:42
 * @Description: ListNode$
 */
public class ListNode {
	public int val;
	public ListNode next;
	ListNode() {}
	public ListNode(int val) { this.val = val; }
	public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
