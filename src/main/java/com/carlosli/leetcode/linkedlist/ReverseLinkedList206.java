package com.carlosli.leetcode.linkedlist;

/**
 * Created by yulongli on 2016/11/21.
 */
public class ReverseLinkedList206 {

    /*
    (n+1)n/2
    复杂度n^2
     */
    public static ListNode reverseList(ListNode head) {

        if (head == null) return null;
        if (head.next == null) return head;

        // 计算长度
        ListNode lengthNode = head;
        int length = 0;
        while (lengthNode.next != null) {
            lengthNode = lengthNode.next;
            length++;
        }
        length++;

        // 临时变量，指定list头
        ListNode gummy = new ListNode(Integer.MIN_VALUE);
        gummy.next = head;

        // 第一次把第一位挪到最后，第二次把第二位挪到倒数第二，第三次把第三位挪到倒数第三。。。。。
        for (int i = length; i - 1 > 0; i--) {
            ListNode innerHead = gummy;
            for (int j = 0; j < i - 1; j++) { // 有点类似冒泡
                ListNode innerFirst = innerHead;
                ListNode innerSecond = innerHead.next;
                ListNode innerThird = innerHead.next.next;
                ListNode innerFour = innerHead.next.next.next;
                innerFirst.next = innerThird;
                innerThird.next = innerSecond;
                innerSecond.next = innerFour;
                innerHead = innerHead.next;
            }
        }
        return gummy.next;
    }

    // 1>2>3>4>5  变为  1<2<3<4<5
    public static ListNode reverseList2(ListNode head) {
        ListNode pre = null;
        ListNode foot = head;
        while (foot != null) {
            ListNode nextFoot = foot.next;
            foot.next = pre;
            pre = foot;
            foot = nextFoot;
        }
        return pre;
    }

    /*
    递归询问终止节点p再哪里，同时将关联关系进行转换
    如 1>2>3>4<5<6
     */
    public static ListNode reverseList3(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList3(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;
        ListNode.printList(reverseList3(node1));
    }
}
