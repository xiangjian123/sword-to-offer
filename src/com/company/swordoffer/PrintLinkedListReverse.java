package com.company.swordoffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 */
public class PrintLinkedListReverse {

    public static void main(String[] args) {
    }

    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[] {};
        }

        int len = 1;
        ListNode temp = head;
        while (temp.next != null) {
            len++;
            temp = temp.next;
        }

        int[] res = new int[len];
        int start = len - 1;
        while (head.next != null) {
            res[start] = head.val;
            head = head.next;
            start--;
        }
        res[0] = head.val;

        return res;
    }
}
