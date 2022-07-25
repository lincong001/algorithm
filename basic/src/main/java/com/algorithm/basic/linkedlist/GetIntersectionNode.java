package com.algorithm.basic.linkedlist;

import com.algorithm.basic.inPlaceEditArray.ListNode;

/**
 * @author linchong
 * @version 1.0
 * @Date: 2022-05-21 15:10
 * @Description: GetIntersectionNode$获取两条链表的交点
 */
public class GetIntersectionNode {

	ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		// p1 指向 A 链表头结点，p2 指向 B 链表头结点
		ListNode p1 = headA, p2 = headB;
		while (p1 != p2) {
			// p1 ⾛⼀步，如果⾛到 A 链表末尾，转到 B 链表
			if (p1 == null) p1 = headB;
			else p1 = p1.next;
			// p2 ⾛⼀步，如果⾛到 B 链表末尾，转到 A 链表
			if (p2 == null) p2 = headA;
			else p2 = p2.next;
		}
		return p1;
	}


	ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
		int lenA = 0,lenB = 0;
		for(ListNode p1 = headA;p1!=null;p1=p1.next){
			lenA++;
		}
		for(ListNode p2 = headB;p2!=null;p2=p2.next){
			lenB++;
		}
		// 让 p1 和 p2 到达尾部的距离相同
		ListNode p1 = headA, p2 = headB;
		if (lenA > lenB) {
			for (int i = 0; i < lenA - lenB; i++) {
				p1 = p1.next;
			}
		} else {
			for (int i = 0; i < lenB - lenA; i++) {
				p2 = p2.next;
			}
		}
		// 看两个指针是否会相同，p1 == p2 时有两种情况：
		// 1、要么是两条链表不相交，他俩同时⾛到尾部空指针
		// 2、要么是两条链表相交，他俩⾛到两条链表的相交点
		while (p1 != p2) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return p1;
	}
}
