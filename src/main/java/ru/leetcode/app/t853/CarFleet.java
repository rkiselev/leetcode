package ru.leetcode.app.t853;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

import static org.junit.Assert.assertEquals;

public class CarFleet {
    public static void main(String[] args) {
        assertEquals(1, new Solution().carFleet(100, new int[]{0,4,2}, new int[]{2,1,3}));
        assertEquals(3, new Solution().carFleet(12, new int[]{10,8,0,5,3}, new int[]{2,4,1,1,3}));
        assertEquals(2, new Solution().carFleet(10, new int[]{6,8}, new int[]{3, 2}));
    }
    static class Solution {
        public int carFleet(int target, int[] position, int[] speed) {
            List<Car> cars = new ArrayList<>();
            for (int i = 0; i < speed.length; i++) {
                cars.add(new Car(speed[i], position[i]));
            }
            cars.sort(Comparator.comparingInt(a -> a.position));
            Stack<Float> stack = new Stack<>();
            for (int i = cars.size() - 1; i >= 0; i--) {
                Car car = cars.get(i);
                float time = (target - car.position) / (car.speed * 1.0f);
                if (!stack.isEmpty()) {
                    float catchUpTime = stack.peek();
                    if (time <= catchUpTime) {
                        time = stack.pop();
                    }
                }
                stack.push(time);
            }
            return stack.size();
        }

        private static class Car {
            int speed;
            int position;
            Car(int speed, int position) {
                this.speed = speed;
                this.position = position;
            }
        }
    }

}
