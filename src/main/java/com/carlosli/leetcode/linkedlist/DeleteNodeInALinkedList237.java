package com.carlosli.leetcode.linkedlist;

/**
 * Created by yulongli on 2017/1/9.
 */
public class DeleteNodeInALinkedList237 {

    public static void deleteNode(ListNode node) {
        if (node != null && node.next != null) {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;

        deleteNode(node3);

        ListNode.printList(node1);
    }
}
