package com.carlosli.leetcode.linkedlist;

/**
 * Created by yulongli on 2016/11/21.
 */
public class RemoveLinkedListElements203 {

    public static ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode pre = dummy;
        while (head != null) {
            if (head.val == val) pre.next = head.next;
            else pre = pre.next;
            head = head.next;
        }
        return dummy.next;
    }

    // 与第一个方法最大的区别是不需要dummy临时节点
    public static ListNode removeElements2(ListNode head, int val) {
        // 将head 移动到第一个非val的地方（过滤掉前面连续几个都是等于val的情况）
        while (head != null && head.val == val) head = head.next;
        ListNode curr = head;
        while (curr != null && curr.next != null)
            if (curr.next.val == val) curr.next = curr.next.next;
            else curr = curr.next;
        return head;
    }

    public static ListNode removeElements3(ListNode head, int val) {
        if (head == null) return null;
        head.next = removeElements2(head.next, val);
        return head.val == val ? head.next : head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        ListNode.printList(removeElements(node1, 1));
    }
}
