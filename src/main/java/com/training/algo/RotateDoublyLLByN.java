package com.training.algo;

import com.training.util.DoublyLL;

public class RotateDoublyLLByN {
    public DoublyLL<Character> list;

    public RotateDoublyLLByN(DoublyLL<Character> list) {
        this.list = list;
    }

    public void rotateByN(int n) {
        DoublyLL.Node nodeN = list.head;

        for (int i=0 ; i < n; i++) {
            nodeN = nodeN.next;
        }


        DoublyLL.Node oldHead = list.head;
        DoublyLL.Node oldEnd = list.end;

        list.head = nodeN;
        list.end = nodeN.prior;
        list.head.prior = null;
        list.end.next = null;
        oldHead.prior = oldEnd;
        oldEnd.next = oldHead;

    }
}
