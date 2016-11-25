package com.carlosli.leetcode.linkedlist;

import java.util.HashSet;

/**
 * Created by yulongli on 2016/11/10.
 */
public class LinkedListCycle141 {

    /**
     * 有bug 若 1-2-3-4-2  也有圈，该方法将无限循环
     * 这种方法只能应对收尾相连的  1-2-3-4-1
     *
     * @param head
     * @return
     */
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode first = head;
        while (first.next != null) {
            if (first.next == head) {
                return true;
            }
            first = first.next;
        }
        return false;
    }

    /**
     * 用hashset
     *
     * @param head
     * @return
     */
    public static boolean hasCycle1(ListNode head) {
        if (head == null || head.next == null) return false;
        HashSet<ListNode> set = new HashSet<ListNode>();
        while (head.next != null) {
            if (set.contains(head)) {
                return true;
            } else {
                set.add(head);
            }
            head = head.next;
        }
        return false;
    }

    public static boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) return false;
        if (head.next == head) return true;
        ListNode nextNode = head.next;
        // 下面的有啥用，但是去掉后  Exception in thread "main" java.lang.StackOverflowError
        // 1.等到下次转到这个head的时候就是，就可以判断出有圈了
        // 2.异常是因为，若没有，会成行圈，会一直递归调用下去
        head.next = head;
        boolean isCycle = hasCycle2(nextNode);
        return isCycle;
    }

    /**
     * 想象2个人在操场跑步，快的最后肯定要和慢的相遇（第一次相遇时，快的比慢的多跑了一圈（这个与该题无关））
     *
     * @param head
     * @return
     */
    public static boolean hasCycle3(ListNode head) {
        if (head == null) return false;
        ListNode walker = head;
        ListNode runner = head;
        while (runner.next != null && runner.next.next != null) {
            walker = walker.next;
            runner = runner.next.next;
            if (walker == runner) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node3;

        boolean b = LinkedListCycle141.hasCycle2(node1);
        System.out.println(b);
        boolean b2 = LinkedListCycle141.hasCycle1(node1);
        System.out.println(b2);

    }

}
