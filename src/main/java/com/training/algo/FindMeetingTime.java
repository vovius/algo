package com.training.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class FindMeetingTime {

    static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

    public static Interval getInterval(int start, int end) {
        return new Interval(start, end);
    }

    public static Interval find(Interval[] arr, int length) {
//        1. Sort the intervals based on increasing order of
//        starting time.
//        2. Push the first interval on to a stack.
//        3. For each interval do the following
//              a. If the current interval does not overlap with the stack top, push it.
//              b. If the current interval overlaps with stack top and ending
//                 time of current interval is more than that of stack top,
//                 update stack top with the ending  time of current interval.
//        4. At the end stack contains the merged intervals.
        Arrays.sort(arr, (o1, o2) -> o1.start-o2.start);
        Stack<Interval> stack = new Stack<>();
        stack.push(arr[0]);
        for (int i=1; i<arr.length; i++) {
            if (overlaps(stack.peek(), arr[i])) {
                Interval interval = stack.pop();
                interval.end = arr[i].end;
                stack.push(interval);
            } else {
                stack.push(arr[i]);
            }
        }

        System.out.println(Arrays.toString(stack.toArray()));

        Interval prior = null;
        for (Interval interval : stack) {
            if (prior == null) {
                prior = interval;
                continue;
            }

            if (interval.start - prior.end >= length) {
                return new Interval(prior.end, interval.start);
            }

            prior = interval;

        }

        return new Interval(0, 0);
    }

    private static boolean overlaps(Interval a1, Interval a2) {
        return a1.end >= a2.start;
    }


    public static void main(String[] args) {
        Interval[] arr = {getInterval(40, 50), getInterval(1, 5), getInterval(7, 9), getInterval(20, 30), getInterval(5, 6), getInterval(15, 17), getInterval(16, 17)};
        System.out.println(find(arr, 10));
    }
}
