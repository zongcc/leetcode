package com.carlosli.leetcode.linkedlist;

/**
 * Created by yulongli on 2016/11/18.
 */
public class IntersectionofTwoLinkedLists160 {

    // 该方法不符合题目要求，要求不允许改变list结构
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        while (headA.next != null) {
            if (headA == headA.next) return headA;
            // 将当前节点的next置为自己，节点向下移动一位
            ListNode next = headA.next;
            headA.next = headA;
            headA = next;
        }
        while (headB.next != null) {
            if (headB == headB.next) return headB;
            // 节点向下移动一位
            headB = headB.next;
        }
        return null;
    }

    /*
    先判断长度
    将长的，移动到与短的平行的位置
    遍历，直到遇到相同的
     */
    public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        int lenA = length(headA), lenB = length(headB);
        // move headA and headB to the same start point
        while (lenA > lenB) {
            headA = headA.next;
            lenA--;
        }
        while (lenA < lenB) {
            headB = headB.next;
            lenB--;
        }
        // find the intersection until end
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    private static int length(ListNode node) {
        int length = 0;
        while (node != null) {
            node = node.next;
            length++;
        }
        return length;
    }

    /*
        假设 两个长度为6、8
        此方法会走两遍   两条路的总长度都为 14，只不过一个是6+8，另一个是8+6
        两遍后都会同时走到最后的结尾，所以若有相同，必会相遇
     */
    public static ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        // 边界检测
        if (headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        // 若 a & b 长度不同, 将在第二次遍历链表时停止循环
        while (a != b) {
            // 第一次遍历后，将指针设定为另一个链表的开头
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }

        return a;
    }

    public static void main(String[] args) {
        ListNode c1 = new ListNode(31);
        ListNode c2 = new ListNode(32);
        c1.next = c2;
        c2.next = null;
        ListNode a1 = new ListNode(11);
        ListNode a2 = new ListNode(12);
        a1.next = a2;
        a2.next = c1;
        ListNode b1 = new ListNode(21);
        ListNode b2 = new ListNode(22);
        ListNode b3 = new ListNode(23);
        b1.next = b2;
        b2.next = b3;
        b3.next = c1;

        ListNode intersectionNode = getIntersectionNode2(a1, b1);
        System.out.println(intersectionNode.val);

    }
}
