package com.company.swordoffer;

/**
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 *
 *  
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *  
 *
 * 限制：
 *
 * 0 <= 节点个数 <= 5000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/fan-zhuan-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

class ListNode1 {
    int val;
    ListNode1 next;
    ListNode1(int x) { val = x; }
}


public class ReverseList {
    public static void main(String[] args) {

    }


    // 头插法

    public static ListNode1 reverseList(ListNode1 head) {
        if (head == null) {
            return null;
        }

        ListNode1 ret = null;

        while (head.next != null) {
            ListNode1 temp = new ListNode1(head.val);
            if (ret == null) {
                ret = temp;
                temp.next = null;
            } else {
                temp.next = ret.next;
                ret.next = temp;
            }

            head = head.next;
        }

        return ret;
    }
}
