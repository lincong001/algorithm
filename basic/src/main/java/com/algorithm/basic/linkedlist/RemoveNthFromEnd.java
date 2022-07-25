package com.algorithm.basic.linkedlist;

import com.algorithm.basic.inPlaceEditArray.ListNode;

/**
 * @author linchong
 * @version 1.0
 * @Date: 2022-05-21 11:14
 * @Description: RemoveNthFromEnd$给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 */
public class RemoveNthFromEnd {

	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dumy = new ListNode(-1);
		dumy.next = head;
		ListNode p1 = dumy;
		ListNode p2 = dumy;
		for(int i=0;i<n+1;i++){
			p1 = p1.next;
		}
		while(p1!=null){
			p1 = p1.next;
			p2 = p2.next;
		}
		p2.next = p2.next.next;
		return dumy.next;
	}
}
