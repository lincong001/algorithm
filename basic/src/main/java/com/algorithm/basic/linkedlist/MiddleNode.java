package com.algorithm.basic.linkedlist;

import com.algorithm.basic.inPlaceEditArray.ListNode;

/**
 * @author linchong
 * @version 1.0
 * @Date: 2022-05-21 11:23
 * @Description: MiddleNode$获取链表中点
 */
public class MiddleNode {

	ListNode middleNode(ListNode head){
		// 快慢指针初始化指向 head
		ListNode slow = head,fast = head;
		while(fast != null && fast.next != null){
			// 慢指针⾛⼀步，快指针⾛两步
			slow = slow.next;
			fast = fast.next.next;
		}
		// 慢指针指向中点
		return slow;
	}
}
