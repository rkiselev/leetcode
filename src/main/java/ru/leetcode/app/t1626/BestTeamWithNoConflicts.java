package ru.leetcode.app.t1626;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class BestTeamWithNoConflicts {
    /**
     * https://leetcode.com/problems/best-team-with-no-conflicts/description/
     * You are the manager of a basketball team. For the upcoming tournament, you want to choose the team with the
     * highest overall score. The score of the team is the sum of scores of all the players in the team.
     *
     * However, the basketball team is not allowed to have conflicts. A conflict exists if a younger player has a
     * strictly higher score than an older player. A conflict does not occur between players of the same age.
     *
     * Given two lists, scores and ages, where each scores[i] and ages[i] represents the score and age of the ith
     * player, respectively, return the highest overall score of all possible basketball teams.
     *
     *
     *
     * Example 1:
     *
     * Input: scores = [1,3,5,10,15], ages = [1,2,3,4,5]
     * Output: 34
     * Explanation: You can choose all the players.
     * Example 2:
     *
     * Input: scores = [4,5,6,5], ages = [2,1,2,1]
     * Output: 16
     * Explanation: It is best to choose the last 3 players. Notice that you are allowed to choose multiple people of
     * the same age.
     * Example 3:
     *
     * Input: scores = [1,2,3,5], ages = [8,9,10,1]
     * Output: 6
     * Explanation: It is best to choose the first 3 players.
     */

    public static void main(String[] args) {
        new Solution().bestTeamScore(new int[]{319776,611683,835240,602298,430007,574,142444,858606,734364,896074}, new int[]{1,1,1,1,1,1,1,1,1,1});
        new Solution().bestTeamScore(new int[]{4,5,6,5}, new int[]{2,1,2,1});
        new Solution().bestTeamScore(new int[]{1,3,5,10,15}, new int[]{1,2,3,4,5});
    }
    static class Solution {
        public int bestTeamScore(int[] scores, int[] ages) {
            var players = new ArrayList<Player>();
            for (int i = 0; i < ages.length; i++) {
                players.add(new Player(scores[i], ages[i]));
            }
            Collections.sort(players);
            int[]dp = new int[scores.length];
            dp[0] = players.get(0).score;
            int ans = dp[0];
            for (int i = 1; i < players.size(); i++) {
                dp[i] = players.get(i).score;
                for(int j = 0; j < i; j++) {
                    if(players.get(i).score >= players.get(j).score)
                        dp[i] = Math.max(dp[i], dp[j] + players.get(i).score);
                }
                ans = Math.max(ans, dp[i]);
            }
            return ans;
        }

        private boolean isDivisor(int i, String str1, String str2) {
            if (str1.length() % i != 0) return false;
            if (str2.length() % i != 0) return false;

            String part = str1.substring(0, i);
            int factor1 = str1.length() / i;
            int factor2 = str2.length() / i;
            return (part.repeat(factor1).equals(str1) && part.repeat(factor2).equals(str2));
        }

        class Player implements Comparable<Player>{
            int score;
            int age;
            Player(int score, int age) {
                this.score = score;
                this.age = age;
            }

            @Override
            public int compareTo(Player o) {
                if (age == o.age) return Integer.compare(score, o.score);
                return Integer.compare(age, o.age);
            }

            @Override
            public String toString() {
                return "age = " + age + " score = "+ score;
            }
        }
    }
}
