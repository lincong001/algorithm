package com.algorithm.basic.linkedlist;

import com.algorithm.basic.inPlaceEditArray.ListNode;

/**
 * @author linchong
 * @version 1.0
 * @Date: 2022-05-21 11:32
 * @Description: DetectCycle$
 */
public class DetectCycle {

	//如果链表中含有环，如何计算这个环的起点？
	public ListNode detectCycle(ListNode head){
		ListNode slow = head,fast = head;
		while(fast!=null && fast.next!=null){
			fast =fast.next.next;
			slow = slow.next;
			if(slow == fast){
				break;
			}
		}
		//没有环
		if(fast == null || fast.next == null) return null;
		slow = head;
		while(slow!=fast){
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}
}
