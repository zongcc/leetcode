package com.carlosli.leetcode.linkedlist;

/**
 * Created by yulongli on 2016/11/21.
 */
public class RemoveDuplicatesFromSortedList83 {
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = head;
        while (head != null && head.next != null) {
            if (head.next.val == head.val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return dummy;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode listNode = deleteDuplicates(node1);
        ListNode.printList(listNode);

        System.out.println("----------------");

        ListNode node10 = new ListNode(1);
        ListNode.printList(deleteDuplicates(node10));

        System.out.println("----------------");

        ListNode node20 = new ListNode(1);
        ListNode node21 = new ListNode(1);
        ListNode node22 = new ListNode(1);
        node20.next = node21;
        node21.next = node22;
        ListNode.printList(deleteDuplicates(node20));
    }
}
