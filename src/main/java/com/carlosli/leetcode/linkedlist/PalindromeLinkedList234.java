package com.carlosli.leetcode.linkedlist;

/**
 * Created by yulongli on 2016/12/1.
 * 回文串是指一个字符串从左读到右与从右读到左是一样的
 * 1->2->1 就是一个回文链表
 * 1 2 2 1 也是
 */
public class PalindromeLinkedList234 {
    public static boolean isPalindrome(ListNode head) {
        ListNode line1 = head;
        // 查找中间的点
        ListNode middleNode = findMiddleNode(head);
        // 分段
        ListNode line2 = middleNode.next;
        middleNode.next = null;
        // 旋转后半段
        line2 = ReverseLinkedList206.reverseList3(line2);
        ListNode.printList(line2);

        // 两个链表对比，是否相同。（肯定是line1长，或者两个都相等长度）
        while (line1 != null && line2 != null) {
            if (line1.val != line2.val) return false;
            line1 = line1.next;
            line2 = line2.next;
        }
        return true;
    }

    /**
     * 查找中间的
     * 基数 - 返回 中间 后面的元素
     * 偶数 - 返回 中线 后面的元素
     *
     * @param head
     * @return
     */
    public static ListNode findMiddleNode(ListNode head) {
        ListNode gummy = new ListNode(Integer.MIN_VALUE);
        gummy.next = head;
        ListNode slow = gummy;
        ListNode fast = gummy;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /*----------------------------------------------------------*/

    public static boolean isPalindrome2(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode middle = head;
        ListNode fast = head;
        ListNode slow = middle.next;
        ListNode pre = middle;
        //查找中间的元素，同时对前半截进行翻转
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            pre = middle;
            middle = slow;
            slow = slow.next;
            middle.next = pre;
        }

        //若是基数，需要对前半截的头元素，往前走一步
        // 如 12321  middle为3  ，而对比的时候对比 12  21
        if (fast.next == null) {
            middle = middle.next;
        } else {
            //若是偶数，什么都不需要做
        }
        //比较两段
        while (slow != null) {
            if (middle.val != slow.val) {
                return false;
            }
            middle = middle.next;
            slow = slow.next;
        }
        return true;

    }

    /*----------------------------------------------------------*/
    /*递归调用
    找到最后一个点，往前回退的同时与之对应前面的数值进行比较
    （有个问题，其实回退到中间点就可以停止了，但是该方法则回退到起点） */
    private static ListNode root;
    public static boolean isPalindrome3(ListNode head) {
        root = head;
        return (head == null) ? true : _isPalindrome3(head);
    }
    public static boolean _isPalindrome3(ListNode head) {
        boolean flag = true;
        if (head.next != null) {
            flag = _isPalindrome3(head.next);
        }
        if (flag && root.val == head.val) {
            root = root.next;
            System.out.println(head+":"+head.val);
            return true;
        }
        return false;
    }

    /*----------------------------------------------------------*/

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(2);
        ListNode node7 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = null;

        // 打开就是偶数个元素
//        ListNode node8 = new ListNode(11);
//        node7.next = node8;
//        node8.next = null;
        ListNode.printList(node1);

        boolean palindrome = isPalindrome3(node1);
        System.out.println(palindrome);

    }
}
