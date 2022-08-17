package ru.leetcode.app.t729;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

class MyCalendar {

    public static void main(String[] args) {
        var it = new MyCalendar();


        it.book(23,32);
        it.book(42,50);
        it.book(6,14);
        it.book(0,7);
        it.book(21,30);
        it.book(26,31);
        it.book(46,50);
        it.book(28,36);
        it.book(0,6);
        it.book(27,36);
        it.book(6,11);
        it.book(20,25);
        it.book(32,37);
        it.book(14,20);
        it.book(7,16);//,[13,22],[39,47],[37,46],[42,50],[9,17],[49,50],[31,37],[43,49],[2,10],[3,12],[8,14],[14,21],[42,47],[43,49],[36,43]]


        assertTrue(it.book(10, 20));
        assertFalse(it.book(15, 30));
        assertTrue(it.book(20, 30));
    }

    Set<Event> set = new HashSet<>();

    public MyCalendar() {
        set = new HashSet<>();
    }

    public boolean book(int start, int end) {
        return set.add(new Event(start, end));
    }

    class Event {
        int start;
        int end;

        Event(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Event event = (Event) o;
            return (start < event.start && event.start < end) || (start < event.end && event.end < end)
                    || (event.start < start && event.end > start) || (event.start == start && event.end == end)
                    || (start < event.end && event.end < end);
        }

        @Override
        public int hashCode() {
            return 1;
        }
    }
}
