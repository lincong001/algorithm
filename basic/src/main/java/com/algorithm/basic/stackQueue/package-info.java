/**
 * 队列实现栈以及栈实现队列
 *
 *
 * 232. ?栈实现队列（简单）
 * 225. ?队列实现栈（简单）
 *
 *
 * 队列是?种先进先出的数据结构，栈是?种先进后出的数据结构。这两种数据结构底层其实都是数组或者链表实现的，只是 API 限定了它们的特性
 *
 *
 *
 */
package com.algorithm.basic.stackQueue;
//一、通过两个栈实现队列
//1.使用栈实现队列，队列的接口API

//class MyQueue {
//    private Stack<Integer> s1, s2;
//
//    public MyQueue() {
//        s1 = new Stack<>();
//        s2 = new Stack<>();
//    }
//    // ...
//}

//class MyQueue {
//
//    /** 添加元素到队尾 */
//    public void push(int x);
//
//    /** 删除队头的元素并返回 */
//    public int pop();
//
//    /** 返回队头元素 */
//    public int peek();
//
//    /** 判断队列是否为空 */
//    public boolean empty();
//}
//2.实现思路：使用两个栈实现队列。
//  2.1调用push入队列时，只要将元素压入s1即可. s1.push(x),如push的三个元素时1,2,3
//  2.2如果此时使用peek查看队头元素时，正常来说队头元素应该为1,但是s1中1被压入栈底，
//  此时需要栈s2来起到一个中转作用: 当s2为空时，将s1中所有的元素取出来在添加到s2,此时s2中的元素就是先进先出的顺序
/*public int peek(){
    if(s2.isEmpty()){
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
    }
    return s2.peek();
}*/
//  2.3调用pop时，只需要操作s2即可，
//      public int pop(){
//           //先调用peek保证s2非空
//           peek();
//           s2.pop();
//      }
//  2.4判断队列是否非空
//      如果两个栈都为空，则说明队列为空
//  2.5各个阶段的时间复杂度
//      push:   o(1)
//      peek:   o(N)
//      pop:    o(N)
//      isEmpty: o(1)


//3.使用队列实现栈

//使用队列实现栈，底层需要一个队列
// class MyStack {
//
//    /** 添加元素到栈顶 */
//    public void push(int x);
//
//    /** 删除栈顶的元素并返回 */
//    public int pop();
//
//    /** 返回栈顶元素 */
//    public int top();
//
//    /** 判断栈是否为空 */
//    public boolean empty();
//}
//实现思路：
//3.1 push,直接将元素加入队列，同时记录队尾元素，由于队尾元素相当于栈顶，如果要top查看栈顶元素，可以直接返回。
/*class MyStack {
    Queue<Integer> q = new LinkedList<>();
    int top_elem = 0;
    *//** 添加元素到栈顶 *//*
    public void push(int x) {
        // x 是队列的队尾，是栈的栈顶
        q.offer(x);
        top_elem = x;
    }

    *//** 返回栈顶元素 *//*
    public int top() {
        return top_elem;
    }
}*/
// 底层的数据结构是先进先出的队列，每次 pop 只能从队头取元素；但是栈是后进先出，也就是说 pop API 要从队尾取元素：
// 解决?法简单粗暴，把队列前?的都取出来再加?队尾，让之前的队尾元素排到队头，这样就可以取出了：
/** 删除栈顶的元素并返回 */
    /*public int pop() {
            int size = q.size();
            while (size > 1) {
                q.offer(q.poll());
                size--;
            }
            // 之前的队尾元素已经到了队头
            return q.poll();
    }*/
//这样实现还有?点?问题就是，原来的队尾元素被提到队头并删除了，但是 top_elem 变量没有更新，我们 还需要?点?修改
    /*public int pop() {
        int size = q.size();
        // 留下队尾 2 个元素
        while (size > 2) {
        q.offer(q.poll());
        size--;
        }
        // 记录新的队尾元素
        top_elem = q.peek();
        q.offer(q.poll());
        // 删除之前的队尾元素
        return q.poll();
    }*/

    /** 判断栈是否为空 */
    //判断底层的队列是否为空
    /*public boolean empty() {
        return q.isEmpty();
    }*/
    //?队列实现栈的话，pop 操作时间复杂度是 O(N)，其他操作都是 O(1)。


