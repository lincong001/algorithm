package com.algorithm.basic.linkedlist;

import com.algorithm.basic.inPlaceEditArray.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author linchong
 * @version 1.0
 * @Date: 2022-05-21 10:10
 * @Description: MergeKLists$
 * 给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * 示例 2：
 *
 * 输入：lists = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：lists = [[]]
 * 输出：[]
 *  
 *
 * 提示：
 *
 * k == lists.length
 * 0 <= k <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] 按 升序 排列
 * lists[i].length 的总和不超过 10^4
 *
 */
public class MergeKLists {

	public ListNode mergeKLists(ListNode[] lists) {
		if (lists.length == 0) return null;
		// 优先级队列，最⼩堆
		PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
		// 将 k 个链表的头结点加⼊最⼩堆
		for (ListNode head : lists) {
			if (head!=null){
				priorityQueue.add(head);
			}
		}
		// 虚拟头结点
		ListNode dumy = new ListNode(-1);
		ListNode p =dumy;
		while (!priorityQueue.isEmpty()){
			// 获取最⼩节点，接到结果链表中
			ListNode node = priorityQueue.poll();
			p.next = node;
			if(node.next!=null){
				//不为空，加入优先队列重新排序
				priorityQueue.add(node.next);
			}
			p = p.next;
		}

		return dumy.next;
	}
}
