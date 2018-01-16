package com.training.algo;

public class KFromTheEnd {

    static class Item {
        Object value;
        Item next;
    }

    public static Item getFromEnd(Item top, int num) {
        Item currentFast = top;

        int i=0;
        Item currentSlow = num == 0 ? top : null;
        while (currentFast != null) {
            currentFast = currentFast.next;
            i++;
            if (i == num+1) {
                currentSlow = top;
                continue;
            }

            if (currentSlow != null) {
                currentSlow = currentSlow.next;
            }
        }

        return currentSlow != null ? currentSlow : currentFast;
    }
}
