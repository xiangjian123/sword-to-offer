package com.company.swordoffer;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 */
public class MinStack {

    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stackMin = new Stack<>();

    private int min = Integer.MAX_VALUE;

    /** initialize your data structure here. */
    // 思路：每次入栈时，将最小值也插入到一个辅助栈中
    public MinStack() {

    }

    public void push(int x) {
        if (x < min) {
            min = x;
        }
        stackMin.push(min);
        stack1.push(x);
    }

    public void pop() {
        stack1.pop();
        stackMin.pop();
    }

    public int top() {
        System.out.println(stack1.peek());
        return stack1.peek();
    }

    public int min() {
        System.out.println(stackMin.peek());
        return stackMin.peek();
    }

    public void show() {
        System.out.println(stack1.size());
        System.out.println(stackMin.size());
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(2147483646);
        minStack.push(2147483646);
        minStack.push(2147483647);
        minStack.top();
        minStack.pop();
        minStack.min();
        minStack.pop();
        minStack.min();
        minStack.pop();

        minStack.show();


        minStack.push(2147483647);
        minStack.top();
        minStack.min();
        minStack.push(-2147483648);
        minStack.top();
        minStack.min();
        minStack.pop();
        minStack.min();
    }
}
