package com.algorithm.basic.linkedlist;

import com.algorithm.basic.inPlaceEditArray.ListNode;

/**
 * @author linchong
 * @version 1.0
 * @Date: 2022-05-21 15:44
 * @Description: ReverseLinkedList$
 */
public class ReverseLinkedList {

	ListNode reverse(ListNode head){
		if(head ==null || head.next == null){
			return head;
		}
		ListNode last = reverse(head.next);
		head.next.next = head;
		head.next = null;
		return last;
	}
}
