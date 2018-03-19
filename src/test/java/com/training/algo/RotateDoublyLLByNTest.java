package com.training.algo;


import com.training.util.DoublyLL;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
class RotateDoublyLLByNTest {

    @Test
    public void testRotate2() {
        DoublyLL<Character> ll = new DoublyLL<>(new Character[]{'a','b','c','d','e'});
        assertEquals("abcde", ll.toStringPlain());

        RotateDoublyLLByN rotate = new RotateDoublyLLByN(ll);
        rotate.rotateByN(2);
        assertEquals("cdeab", rotate.list.toStringPlain());

    }
}