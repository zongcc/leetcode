package com.carlosli.leetcode.linkedlist;

/**
 * Created by yulongli on 2016/11/17.
 */
public class MergeTwoSortedLists21 {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode head = dummy;

        while (l1 != null || l2 != null) {
            /*
            其实真正有用的是
            l1 != null && l2 == null    l1都用完了，l2还没用完
            l1.val <= l2.val            l1的值比l2小 (中间的l1 != null && l2 != null 只是防止空指针异常)
             */
            if ((l1 != null && l2 == null) || (l1 != null && l2 != null && l1.val <= l2.val)) {
                head.next = l1;
                l1 = l1.next;
                head.next.next = null;
                head = head.next;
                continue;
            }
            /*
            其实真正有用的是
            l1 == null && l2 != null    l2都用完了，l1还没用完
            l1.val > l2.val             l2的值比l1小 (中间的l1 != null && l2 != null 只是防止空指针异常)
             */
            if ((l1 == null && l2 != null) || (l1 != null && l2 != null && l1.val > l2.val)) {
                head.next = l2;
                l2 = l2.next;
                head.next.next = null;
                head = head.next;
                continue;
            }
        }
        return dummy.next;
    }

    /*
     方法1改造过来的
     方法1中,第一个if语句 l1 != null && l2 == null(l1都用完了，l2还没用完)后，其实只要把l2移动过去就好了，不需要每个l2的节点再循环一遍
     方法2中同上
     */
    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode head = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                head.next = l1;
                l1 = l1.next;
                head.next.next = null;
                head = head.next;
                continue;
            }
            if (l1.val > l2.val) {
                head.next = l2;
                l2 = l2.next;
                head.next.next = null;
                head = head.next;
                continue;
            }
        }
        if (l1==null) head.next = l2;
        if (l2==null) head.next = l1;

        return dummy.next;
    }

    public static ListNode mergeTwoLists3(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }

        ListNode mergeHead;
        if(l1.val < l2.val){
            mergeHead = l1;
            mergeHead.next = mergeTwoLists(l1.next, l2);
        }
        else{
            mergeHead = l2;
            mergeHead.next = mergeTwoLists(l1, l2.next);
        }
        return mergeHead;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node6 = new ListNode(6);
        node1.next = node3;
        node3.next = node4;
        node4.next = node6;
        node6.next = null;

        ListNode node2 = new ListNode(2);
        ListNode node5 = new ListNode(5);
        ListNode node7 = new ListNode(7);
        node2.next = node5;
        node5.next = node7;
        node7.next = null;
        ListNode listNode = mergeTwoLists2(node1, node2);

        ListNode.printList(listNode);
    }
}
