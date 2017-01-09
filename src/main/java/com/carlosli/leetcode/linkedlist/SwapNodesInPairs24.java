package com.carlosli.leetcode.linkedlist;

/**
 * Created by yulongli on 2016/12/2.
 */
public class SwapNodesInPairs24 {
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode gummy = new ListNode(Integer.MIN_VALUE);
        gummy.next = head;

        ListNode first = head;
        ListNode second = head.next;
        ListNode pre = gummy;
        while (first != null && second != null) {
            pre.next = second;
            first.next = second.next;
            second.next = first;
            //结尾何时判断停止是个问题。两种情况   有一个 ，和没有元素
            pre = first;
            first = first.next;
            if (first != null) {
                second = first.next;
            }
        }
        return gummy.next;
    }

    public static ListNode swapPairs2(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;
        while (current.next != null && current.next.next != null) {
            ListNode first = current.next;
            ListNode second = current.next.next;
            first.next = second.next;
            second.next = first;
            current.next = second;
//            current.next = second;
//            current.next.next = first;
            current = current.next.next;
        }
        return dummy.next;
    }

    /**
     * 12  34  56
     * 每两位作为一个整体，内部交换，同时获取下一个整体的头
     */
    public static ListNode swapPairs3(ListNode head) {
        if ((head == null) || (head.next == null))
            return head;
        ListNode n = head.next;
        head.next = swapPairs3(head.next.next);
        n.next = head;
        return n;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        /*---------------情况1  后头没有节点了--------------*/
        node6.next = null;
        /*---------------情况2  后头有1个节点了--------------*/
//        node6.next = node7;
//        node7.next = null;

        ListNode listNode = swapPairs2(node1);
        ListNode.printList(listNode);
    }
}
