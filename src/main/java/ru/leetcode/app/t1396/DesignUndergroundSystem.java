package ru.leetcode.app.t1396;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DesignUndergroundSystem {
    /**
     * https://leetcode.com/problems/design-underground-system/
     */

    static class UndergroundSystem {
        public static void main(String[] args) {
            var u = new UndergroundSystem();
            u.checkIn(45,"Leyton",3);
            u.checkIn(27,"Leyton",10);
            u.checkOut(45,"Waterloo",15);
            u.checkOut(27,"Waterloo",20);
            u.getAverageTime("Leyton", "Waterloo");
            u.checkIn(10,"Leyton",24);
            u.checkOut(10,"Waterloo",38);
            u.getAverageTime("Leyton", "Waterloo");
        }

        Map<String, AvgInf> averageTime = new HashMap<>();
        Map<Integer, Road> mapRoad = new HashMap<>();

        public UndergroundSystem() {

        }

        public void checkIn(int id, String stationName, int t) {
            mapRoad.put(id, new Road(stationName, t));
        }

        public void checkOut(int id, String stationName, int t) {
            var road = mapRoad.get(id);
            String path = String.format("%s-%s", road.from, stationName);
            if (averageTime.containsKey(path)) {
                var avgInf = averageTime.get(path);
                double avg = (avgInf.avg * avgInf.count + t - road.time) / (avgInf.count + 1);
                averageTime.put(path, new AvgInf(avg, avgInf.count + 1));
            } else {
                averageTime.put(path, new AvgInf(t - road.time/ 1d, 1));
            }
        }

        public double getAverageTime(String startStation, String endStation) {
            var path = String.format("%s-%s", startStation, endStation);
            return averageTime.get(path).avg;
        }

        class Road {
            String  from;
            int time;

            Road(String from, int time) {
                this.from = from;
                this.time = time;
            }
        }

        class AvgInf{
            double avg;
            int count;

            AvgInf(double avg, int count) {
                this.avg = avg;
                this.count = count;
            }
        }

    }

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
}
