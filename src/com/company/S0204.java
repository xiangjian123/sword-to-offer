package com.company;

import java.util.List;

/**
 * 编写一个函数，检查输入的链表是否是回文的。
 *
 *  
 *
 * 示例 1：
 *
 * 输入： 1->2
 * 输出： false
 * 示例 2：
 *
 * 输入： 1->2->2->1
 * 输出： true
 *  
 *
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-linked-list-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * // 倒插法建一个新的表，比较 。O(n) + O(n)
 * // 遍历求和 + 数量 + 中位数，求和前半段 XXXX 不行，顺序不一定对
 * // 快慢指针找中点，根据中点，翻转后续的链表，然后一一对比。区分长度为奇数和偶数
 */
public class S0204 {
    public static void main(String[] args) {}


    // On + On 反转 + 比较
    public boolean isPalindrome1(ListNode head) {
        ListNode temp = reverseLinked(head);

        ListNode cur1 = head;
        ListNode cur2 = temp;

        boolean flag = true;
        while (flag && cur2 != null) {
            if (cur1.val != cur2.val) {
                flag = false;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
        }

        return flag;
    }

    // On + O1
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        ListNode midNode = findMidNode(head);
        ListNode secondHalfHead = reverseLinked(midNode.next);
        ListNode cur1 = head;
        ListNode cur2 = secondHalfHead;

        boolean flag = true;
        while (flag && cur2 != null) {
            if (cur1.val != cur2.val) {
                flag = false;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
        }

        return flag;
    }

    private ListNode reverseLinked(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;
        while (cur != null) {
            ListNode nextTemp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nextTemp;
        }
        return prev;
    }

    private ListNode findMidNode(ListNode head) {
        ListNode fast = head;
        ListNode low = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            low = low.next;
        }
        return low;
    }
}
