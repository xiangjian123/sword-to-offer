package com.company.swordoffer;

import java.util.Stack;

/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CQueue {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    // 思路：向stack1插入，想要删除时，将stack1的内容，转移到stack2中，删除。
    // 如果stack2中没有数据，则将stack1的内容转移到stack2中，在删除。
    // stack2和stack1都没有，返回-1

    public CQueue() {
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (stack2.isEmpty()) {
            if (stack1.isEmpty()) {
                return -1;
            } else {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
        }

        return stack2.pop();
    }

    public static void main(String[] args) {

    }


}
