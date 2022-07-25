package com.algorithm.basic.linkedlist;

import com.algorithm.basic.inPlaceEditArray.ListNode;

/**
 * @author linchong
 * @version 1.0
 * @Date: 2022-05-21 17:08
 * @Description: ReverseBetween$
 */
public class ReverseBetween {

	ListNode reverseBetween(ListNode head,int m,int n){
		// base case
		if(m == 1){
			return reverseN(head,n);
		}
		// 前进到反转的起点触发 base case
		head.next = reverseBetween(head.next,m-1,n-1);
		return head;
	}

	ListNode successor = null; // 后驱节点
	// 反转以 head 为起点的 n 个节点，返回新的头结点
	ListNode reverseN(ListNode head,int n){
		if(n==1){
			//记录第n+1个节点
			successor = head.next;
			return head;
		}
		//以head.next为起点，需要反转前n-1个节点
		ListNode last = reverseN(head.next,n-1);
		head.next.next = head;
		//使反转之后的head节点和后面的节点连起来
		head.next = successor;
		return last;
	}
}
