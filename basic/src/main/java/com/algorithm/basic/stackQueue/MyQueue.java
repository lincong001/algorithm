package com.algorithm.basic.stackQueue;

import java.util.Stack;

/**
 * @projectName: algorithm
 * @description: 使用双栈实现队列
 * @author: lincong
 * @date: 2022-07-25 15:35
 * @version: 0.0.1
 **/
public class MyQueue {

	private Stack<Integer> s1,s2;

	public void MyQueue(){
		s1 = new Stack<>();
		s2 = new Stack<>();
	}
	/** 添加元素到队尾 */
	public void push(int value){
		s1.push(value);
	}
	/** 返回队头元素 */
	public int peek(){
		if(s2.isEmpty()){
			while(!s1.isEmpty())
				s2.push(s1.pop());
		}
		return s2.peek();
	}
	/** 删除队头的元素并返回 */
	public int pop(){
		if(s2.isEmpty()){
			while(!s1.isEmpty())
				s2.push(s1.pop());
		}
		return s2.pop();
	}
	/** 判断队列是否为空 */
	public boolean empty(){
		return s1.isEmpty() && s2.isEmpty();
	}
}
