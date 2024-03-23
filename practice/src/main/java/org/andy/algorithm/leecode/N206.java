package org.andy.algorithm.leecode;

import org.andy.algorithm.ListNode;

/**
 * @author: Andy
 * @createTime: 2024-03-19 18:41
 * @description: 反转链表
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 */
public class N206 {

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head, next = cur.next, pre = null;
        while (next != null) {
            ListNode temp = next.next;
            next.next = cur;
            cur.next = pre;
            pre = cur;
            cur = next;
            next = temp;
        }
        return cur;
    }
}
