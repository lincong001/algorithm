/**
 * ����ʵ��ջ�Լ�ջʵ�ֶ���
 *
 *
 * 232. ?ջʵ�ֶ��У��򵥣�
 * 225. ?����ʵ��ջ���򵥣�
 *
 *
 * ������?���Ƚ��ȳ������ݽṹ��ջ��?���Ƚ���������ݽṹ�����������ݽṹ�ײ���ʵ���������������ʵ�ֵģ�ֻ�� API �޶������ǵ�����
 *
 *
 *
 */
package com.algorithm.basic.stackQueue;
//һ��ͨ������ջʵ�ֶ���
//1.ʹ��ջʵ�ֶ��У����еĽӿ�API

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
//    /** ���Ԫ�ص���β */
//    public void push(int x);
//
//    /** ɾ����ͷ��Ԫ�ز����� */
//    public int pop();
//
//    /** ���ض�ͷԪ�� */
//    public int peek();
//
//    /** �ж϶����Ƿ�Ϊ�� */
//    public boolean empty();
//}
//2.ʵ��˼·��ʹ������ջʵ�ֶ��С�
//  2.1����push�����ʱ��ֻҪ��Ԫ��ѹ��s1����. s1.push(x),��push������Ԫ��ʱ1,2,3
//  2.2�����ʱʹ��peek�鿴��ͷԪ��ʱ��������˵��ͷԪ��Ӧ��Ϊ1,����s1��1��ѹ��ջ�ף�
//  ��ʱ��Ҫջs2����һ����ת����: ��s2Ϊ��ʱ����s1�����е�Ԫ��ȡ��������ӵ�s2,��ʱs2�е�Ԫ�ؾ����Ƚ��ȳ���˳��
/*public int peek(){
    if(s2.isEmpty()){
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
    }
    return s2.peek();
}*/
//  2.3����popʱ��ֻ��Ҫ����s2���ɣ�
//      public int pop(){
//           //�ȵ���peek��֤s2�ǿ�
//           peek();
//           s2.pop();
//      }
//  2.4�ж϶����Ƿ�ǿ�
//      �������ջ��Ϊ�գ���˵������Ϊ��
//  2.5�����׶ε�ʱ�临�Ӷ�
//      push:   o(1)
//      peek:   o(N)
//      pop:    o(N)
//      isEmpty: o(1)


//3.ʹ�ö���ʵ��ջ

//ʹ�ö���ʵ��ջ���ײ���Ҫһ������
// class MyStack {
//
//    /** ���Ԫ�ص�ջ�� */
//    public void push(int x);
//
//    /** ɾ��ջ����Ԫ�ز����� */
//    public int pop();
//
//    /** ����ջ��Ԫ�� */
//    public int top();
//
//    /** �ж�ջ�Ƿ�Ϊ�� */
//    public boolean empty();
//}
//ʵ��˼·��
//3.1 push,ֱ�ӽ�Ԫ�ؼ�����У�ͬʱ��¼��βԪ�أ����ڶ�βԪ���൱��ջ�������Ҫtop�鿴ջ��Ԫ�أ�����ֱ�ӷ��ء�
/*class MyStack {
    Queue<Integer> q = new LinkedList<>();
    int top_elem = 0;
    *//** ���Ԫ�ص�ջ�� *//*
    public void push(int x) {
        // x �Ƕ��еĶ�β����ջ��ջ��
        q.offer(x);
        top_elem = x;
    }

    *//** ����ջ��Ԫ�� *//*
    public int top() {
        return top_elem;
    }
}*/
// �ײ�����ݽṹ���Ƚ��ȳ��Ķ��У�ÿ�� pop ֻ�ܴӶ�ͷȡԪ�أ�����ջ�Ǻ���ȳ���Ҳ����˵ pop API Ҫ�Ӷ�βȡԪ�أ�
// ���?���򵥴ֱ����Ѷ���ǰ?�Ķ�ȡ�����ټ�?��β����֮ǰ�Ķ�βԪ���ŵ���ͷ�������Ϳ���ȡ���ˣ�
/** ɾ��ջ����Ԫ�ز����� */
    /*public int pop() {
            int size = q.size();
            while (size > 1) {
                q.offer(q.poll());
                size--;
            }
            // ֮ǰ�Ķ�βԪ���Ѿ����˶�ͷ
            return q.poll();
    }*/
//����ʵ�ֻ���?��?������ǣ�ԭ���Ķ�βԪ�ر��ᵽ��ͷ��ɾ���ˣ����� top_elem ����û�и��£����� ����Ҫ?��?�޸�
    /*public int pop() {
        int size = q.size();
        // ���¶�β 2 ��Ԫ��
        while (size > 2) {
        q.offer(q.poll());
        size--;
        }
        // ��¼�µĶ�βԪ��
        top_elem = q.peek();
        q.offer(q.poll());
        // ɾ��֮ǰ�Ķ�βԪ��
        return q.poll();
    }*/

    /** �ж�ջ�Ƿ�Ϊ�� */
    //�жϵײ�Ķ����Ƿ�Ϊ��
    /*public boolean empty() {
        return q.isEmpty();
    }*/
    //?����ʵ��ջ�Ļ���pop ����ʱ�临�Ӷ��� O(N)�������������� O(1)��


