package com.training.util;

public class DoublyLL<T> {

    public class Node<T> {
        public T payload;
        public Node<T> prior;
        public Node<T> next;
    }

    public Node<T> head = null;
    public Node<T> end = null;

    public DoublyLL(T[] sequence) {
        Node<T> current = null;
        Node<T> prior = null;
        for (T entity : sequence) {
            current = new Node<>();
            if (head == null) {
                head = current;
            }

            current.payload = entity;
            if (prior != null) {
                prior.next = current;
            }
            current.prior = prior;
            prior = current;
        }

        end = current;
    }

    public String toStringPlain() {
        String result = "";
        Node<T> current = head;
        while (current != null) {
            result += current.payload;
            current = current.next;
        }

        return result;
    }
}
