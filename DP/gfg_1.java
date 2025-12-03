import java.util.*;
// Simple Top Down Approach
class Solution {
    int[][] dp;

    public int solve(int day, int last, int[][] arr) {
        if (day == arr.length) return 0;
        if (dp[day][last] != -1) return dp[day][last];

        int max = 0;
        for (int task = 0; task < 3; task++) {
            if (task != last) {
                int points = arr[day][task] + solve(day + 1, task, arr);
                max = Math.max(max, points);
            }
        }
        return dp[day][last] = max;
    }

    public int maximumPoints(int arr[][]) {
        int n = arr.length;
        dp = new int[n][4];
        for (int[] row : dp) Arrays.fill(row, -1);

        return solve(0, 3, arr);  // last = 3 → meaning no activity done yesterday
    }
}
 // Simple Bottom Up Approach
 import java.util.Arrays;

class Solution {

    public int maximumPoints(int arr[][]) {
        int n = arr.length;
        int[][] dp = new int[n][4];

        // Base cases
        dp[0][0] = Math.max(arr[0][1], arr[0][2]);
        dp[0][1] = Math.max(arr[0][0], arr[0][2]);
        dp[0][2] = Math.max(arr[0][0], arr[0][1]);
        dp[0][3] = Math.max(arr[0][0], Math.max(arr[0][1], arr[0][2]));

        // Fill dp table for days 1..n-1
        for (int day = 1; day < n; day++) {
            for (int last = 0; last < 4; last++) {
                dp[day][last] = 0;
                for (int task = 0; task < 3; task++) {
                    if (task != last) {
                        dp[day][last] = Math.max(
                            dp[day][last],
                            arr[day][task] + dp[day - 1][task]
                        );
                    }
                }
            }
        }

        return dp[n - 1][3];
    }
}
