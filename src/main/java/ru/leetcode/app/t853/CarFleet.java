package ru.leetcode.app.t853;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class CarFleet {
    public static void main(String[] args) {
        new Solution().carFleet(10, new int[]{6,8}, new int[]{3, 2});
        new Solution().carFleet(12, new int[]{10,8,0,5,3}, new int[]{2,4,1,1,3});
    }
    static class Solution {
        public int carFleet(int target, int[] position, int[] speed) {
            List<Car> cars = new ArrayList<>();
            for (int i = 0; i < speed.length; i++) {
                cars.add(new Car(speed[i], position[i]));
            }
            cars.sort(Comparator.comparingInt(a -> a.position));
            Stack<Car> stack = new Stack<>();
            for(Car car: cars) {
                boolean slow = false;
                while(!stack.isEmpty() && !slow && stack.peek().speed > car.speed) {
                    float time = (target - car.position) / (car.speed * 1.0f);
                    float catchUpTime = (target - stack.peek().position) / (stack.peek().speed * 1.0f);
                    if (time >= catchUpTime) {
                        stack.pop();
                    } else {
                        slow = true;
                    }
                }
                stack.push(car);
            }
            return stack.size();
        }

        private class Car {
            int speed;
            int position;
            Car(int speed, int position) {
                this.speed = speed;
                this.position = position;
            }
        }
    }

}
