package com.training.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
class DoublyLLTest {

    @Test
    public void test() {
        DoublyLL<Character> ll = new DoublyLL<>(new Character[]{'a','b','c','d','e'});
        assertEquals("abcde", ll.toStringPlain());
    }
}