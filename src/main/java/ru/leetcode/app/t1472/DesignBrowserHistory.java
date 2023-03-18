package ru.leetcode.app.t1472;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DesignBrowserHistory {
    /**
     * https://leetcode.com/problems/design-browser-history/description/
     * You have a browser of one tab where you start on the homepage and you can visit another url, get back in the
     * history number of steps or move forward in the history number of steps.
     *
     * Implement the BrowserHistory class:
     *
     * BrowserHistory(string homepage) Initializes the object with the homepage of the browser.
     * void visit(string url) Visits url from the current page. It clears up all the forward history.
     * string back(int steps) Move steps back in history. If you can only return x steps in the history and steps > x,
     * you will return only x steps. Return the current url after moving back in history at most steps.
     * string forward(int steps) Move steps forward in history. If you can only forward x steps in the history and
     * steps > x, you will forward only x steps. Return the current url after forwarding in history at most steps.
     */
    public static void main(String[] args) {
        var h = new BrowserHistory("leetcode.com");
        h.visit("google.com");
        h.visit("facebook.com");
        h.visit("youtube.com");
        assertEquals("facebook.com", h.back(1));
        assertEquals("google.com", h.back(1));
        assertEquals("facebook.com", h.forward(1));
        h.visit("linkedin.com");
        assertEquals("linkedin.com", h.forward(2));
        assertEquals("google.com", h.back(2));
        assertEquals("leetcode.com", h.back(7));

    }

    static class BrowserHistory {
        private List<String> history = new ArrayList<>();
        private int current = -1;

        public BrowserHistory(String homepage) {
            history.add(homepage);
            current = 0;
        }

        public void visit(String url) {
            history = history.subList(0, current + 1);
            history.add(url);
            current = history.size() - 1;
        }

        public String back(int steps) {
            if (current - steps < 0) {
                current = 0;
            } else {
                current -= steps;
            }
            return history.get(current);
        }

        public String forward(int steps) {
            if (current + steps >= history.size()) {
                current = history.size() - 1;
            } else {
                current += steps;
            }
            return history.get(current);
        }
    }
}
