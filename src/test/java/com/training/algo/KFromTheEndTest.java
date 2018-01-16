package com.training.algo;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static com.training.algo.KFromTheEnd.Item;
import static com.training.algo.KFromTheEnd.getFromEnd;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
class KFromTheEndTest {

    Item top = createAmount(10);

    @BeforeAll
    public void init() {
        print(top);
    }


    @Test
    public void test1() {
        System.out.println("5th: " + getFromEnd(top, 5).value);
    }

    @Test
    public void test2() {
        System.out.println("7th: " + getFromEnd(top, 7).value);
    }

    @Test
    public void test3() {
        System.out.println("1st: " + getFromEnd(top, 1).value);
    }

    @Test
    public void test4() {
        System.out.println("0th: " + getFromEnd(top, 0).value);
    }

    @Test
    public void test5() {
        System.out.println("9th: " + getFromEnd(top, 9).value);
    }

    @Test
    public void test6() {
        assertThrows(Exception.class, () -> System.out.println("10th: " + getFromEnd(top, 10).value));
    }

    private Item createAmount(int amount) {
        Item top = createItem(null, 0);
        Item current = top;
        for (int i=1; i < amount; i++) {
            current = createItem(current, i);
        }

        return top;
    }

    private void print(Item top) {
        StringBuilder stringBuilder = new StringBuilder();
        while (top != null) {
            stringBuilder.append(top.value);
            top = top.next;
            if (top != null) {
                stringBuilder.append(",");
            }
        }

        System.out.println(stringBuilder);
    }

    private Item createItem(Item root, int i) {
        Item item = new Item();
        item.value = i;
        if (root == null) {
            return item;
        }

        item.value = i;
        root.next = item;
        return item;
    }
}