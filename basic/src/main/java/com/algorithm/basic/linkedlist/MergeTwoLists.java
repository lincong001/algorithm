package com.algorithm.basic.linkedlist;

import com.algorithm.basic.inPlaceEditArray.ListNode;

/**
 * @author linchong
 * @version 1.0
 * @Date: 2022-05-21 9:52
 * @Description: MergeTwoLists$
 */
public class MergeTwoLists {

	//合并两个有序列表，21
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		//虚节点，用来返回结果
		ListNode dumy = new ListNode(-1);
		//临时节点，用来合并链表
		ListNode p = dumy;

		ListNode p1 = l1, p2 = l2;
		while (p1 != null && p2 != null) {
			if (p1.val < p2.val) {
				p.next = p1;
				p1 = p1.next;
			} else {
				p.next = p2;
				p2 = p2.next;
			}
			p = p.next;
		}
		if (p1 != null) {
			p.next = p1;
		} else if (p2 != null) {
			p.next = p2;
		}
		return dumy.next;
	}
}
