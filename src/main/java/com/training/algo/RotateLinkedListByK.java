package com.training.algo;

public class RotateLinkedListByK {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }

        ListNode first = head;
        ListNode second = head;
        while (k > 0) {
            second = second.next;
            if (second == null) {
                second = head;
            }
            k--;
        }

        while (second.next != null) {
            first = first.next;
            second = second.next;
        }

        second.next = head;
        head = first.next;
        first.next = null;

        return head;
    }

}
