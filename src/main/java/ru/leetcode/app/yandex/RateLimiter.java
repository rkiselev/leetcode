package ru.leetcode.app.yandex;

import java.util.*;

public class RateLimiter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int requestsPerSecond = scanner.nextInt();
        int rowCount = scanner.nextInt();
        scanner.nextLine();

        List<String> output = new ArrayList<>();

        Map<String, TimeToCount> userToTime = new HashMap<>();


        for (int i = 0; i < rowCount; i++) {
            String[] inputLine = scanner.nextLine().split(" ");
            long timestamp = Long.parseLong(inputLine[0]);
            String user = inputLine[1];
            var t = userToTime.get(user);
            if (t == null) {
                t = new TimeToCount(timestamp, 0);
                userToTime.put(user, t);
            }
            if (timestamp - t.time >= 1000) {
                t = new TimeToCount(timestamp, 1);
                userToTime.put(user, t);
            } else {
                t.count++;
            }

            if (t.count <= requestsPerSecond) {
                output.add(inputLine[0] + " " + inputLine[1]);
            }
        }

        for (String line : output) {
            System.out.println(line);
        }
    }

    static class TimeToCount {
        int count;
        long time;
        TimeToCount(long time, int count) {
            this.time = time;
            this.count = count;
        }
    }
}
