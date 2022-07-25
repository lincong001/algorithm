package com.algorithm.basic.inPlaceEditArray;

/**
 * @author linchong
 * @version 1.0
 * @Date: 2022-05-19 22:42
 * @Description: DeleteDuplicates$
 */
public class DeleteDuplicates {

	/**
	 * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表
	 * @param head
	 * @return
	 */
	ListNode deleteDuplicates(ListNode head){
		if(head == null) return null;
		ListNode slow = head,fast = head;
		while(fast != null){
			if(fast.val != slow.val){
				// nums[slow] = nums[fast];
				slow.next = fast;
				// slow++;
				slow = fast;
			}
			// fast++
			fast = fast.next;
		}
		// 断开与后⾯重复元素的连接
		slow.next = null;
		return head;
	}
}
