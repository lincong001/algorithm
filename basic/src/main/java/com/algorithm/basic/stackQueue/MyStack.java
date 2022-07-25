package com.algorithm.basic.stackQueue;import java.util.LinkedList;import java.util.Queue;/** * @projectName: algorithm * @description: 使用队列实现栈 * @author: lincong * @date: 2022-07-25 15:34 * @version: 0.0.1 **/public class MyStack {    private Queue<Integer> q = new LinkedList<>();    int top_elem = 0;    /** 添加元素到栈顶 */    public void push(int value){        //栈，后进先出，value是队列的队尾，是栈的栈顶        q.offer(value);        top_elem = value;    }    /** 返回栈顶元素 */    public int top(){        return top_elem;    }    /** 删除栈顶的元素并返回 */    public int pop(){        int size = q.size();        while(size>2){            q.offer(q.poll());            size--;        }        // 记录新的队尾元素        top_elem = q.peek();        q.offer(q.poll());        // 删除之前的队尾元素        return q.poll();    }    /** 判断栈是否为空 */    public boolean empty(){        return q.isEmpty();    }}