package com.algorithm.basic.linkedlist;

import com.algorithm.basic.inPlaceEditArray.ListNode;

/**
 * @author linchong
 * @version 1.0
 * @Date: 2022-05-21 11:28
 * @Description: HasCycle$判断链表是否成环
 */
public class HasCycle {

	boolean hasCycle(ListNode head){
		// 快慢指针初始化指向 head
		ListNode slow = head,fast = head;
		// 快指针⾛到末尾时停⽌
		while(fast!=null && fast.next!=null){
			slow = slow.next;
			fast = fast.next.next;
			// 快慢指针相遇，说明含有环
			if(slow == fast){
				return true;
			}
		}
		// 不包含环
		return false;
	}
}
