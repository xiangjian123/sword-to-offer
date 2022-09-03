package com.company.normal;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 *
 * 不允许修改 链表。
 *
 * 提示：
 *
 * 链表中节点的数目范围在范围 [0, 104] 内
 * -105 <= Node.val <= 105
 * pos 的值为 -1 或者链表中的一个有效索引
 *  
 *
 * 进阶：你是否可以使用 O(1) 空间解决此题？
 */

public class P142_Circle_Link {
    public static void main(String[] args) {

    }

    // 思路1：
    // 首先使用快慢指针，判断是否存在环
    // 然后计算在环中的节点的数量，将环中节点，放入集和中。
    // 从头遍历，如果发现节点在集和中，则是入口
    public static ListNode detectCycle(ListNode head) {
        // 快慢指针？
        if (head == null) {
            return null;
        }

        ListNode temp = head;
        ListNode quick = temp;
        ListNode slow = temp;
        boolean circle = false;

        while (slow.next != null && quick.next != null && quick.next.next != null) {
            slow = slow.next;
            quick = quick.next.next;
            if (slow == quick) {
                circle = true;
                break;
            }
        }

        if (!circle) {
            return null;
        }

        // all nodes in circle
        List<ListNode> list = new ArrayList<>();
        list.add(slow);
        ListNode temp1 = slow.next;
        while (temp1 != null && temp1 != slow) {
            list.add(temp1);
            temp1 = temp1.next;
        }

        while (temp != null) {
            if (list.contains(temp)) {
                return temp;
            }
            temp = temp.next;
        }

        return null;
    }
}
