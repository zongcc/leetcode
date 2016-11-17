package com.carlosli.leetcode.linkedlist;

/**
 * Created by yulongli on 2016/11/10.
 */
public class RemoveNthNodeFromEndofList19 {

    /**
     * 这个方法太复杂，不好
     *
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // 先都初始化有个默认值
        ListNode pre = head;
        ListNode after = head;
        ListNode original = head;

        int i = 0;

        while (head.next != null) {
            i++;
            if (i == n) pre = original;
            if (i > n) pre = pre.next;

            // 删除最后一个的情况
            if (n == 1) after = null;
            if (n >= 2) {
                // i<n时，不需要删除任何数据
                // i=n-2时，after准备开始移动
                if (i == n - 2) after = original;
                // i>n-2时，随着i的增加，n也需要增加，既往后移动
                if (i > n - 2) after = after.next;
            }
            head = head.next;
        }
        // 单独考虑，n为长度-1的情况
        if (i == n - 1) return original.next;
        // n大于长度的时候，直接返回，既不需要删除任何元素
        if (i < n - 1) return original;
        // 通常情况
        if (i >= n) pre.next = after;

        return original;
    }


    // 要删除L-n+1的节点，将L-n和L-n+2节点连接起来
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        // dummy是加入的一个头节点，当list只有一个节点，或者要删除第一个节点的时候，方便使用
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int length = 0; // list 的长度
        ListNode first = head;
        while (first != null) {
            length++;
            first = first.next;
        }

        // 标记要被删除的前一个的位置
        length -= n;

        first = dummy;
        while (length > 0) {
            length--;
            first = first.next;
        }
        // 将被删的前一个与后一个进行连接
        first.next = first.next.next;
        return dummy.next;
    }

    /*
    跟第一种类似，但更精炼，易懂
    思想与第四个相同
     */
    public static ListNode removeNthFromEnd3(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;

        int step = 0;
        while (first.next != null) {
            step++;
            first = first.next;
            if (step > n) second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

    public ListNode removeNthFromEnd4(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        // Advances first pointer so that the gap between first and second is n nodes apart
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        // Move first to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }


    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
//        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(3);
//        ListNode node4 = new ListNode(4);
//        ListNode node5 = new ListNode(5);
//        ListNode node6 = new ListNode(6);
//        ListNode node7 = new ListNode(7);
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
        node1.next = null;
//        node5.next = node6;
//        node6.next = node7;
//        node7.next = null;

        ListNode listNode = RemoveNthNodeFromEndofList19.removeNthFromEnd3(node1, 1);

        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
