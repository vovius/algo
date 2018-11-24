package com.training.algo;

import com.training.util.DoublyLL;

public class ReverseLinkedList {

    private static void reverse(DoublyLL<Integer> list) {
        DoublyLL.Node curr = list.head;
        DoublyLL.Node prev = null;
        DoublyLL.Node next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        list.head = prev;
    }

    public static void main(String[] args) {
        DoublyLL<Integer> list = new DoublyLL<>(new Integer[]{1, 2, 3, 4});
        System.out.println(list.toStringPlain());
        reverse(list);
        System.out.println(list.toStringPlain());

    }
}
