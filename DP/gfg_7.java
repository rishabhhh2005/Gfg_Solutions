// Rod Cutting
class Solution {
    public int cutRod(int[] price) {
        int N = price.length;
        Integer[][] dp = new Integer[N][N+1];
        return recursion(N-1, price, N, dp);
    }
    
    public int recursion(int index, int[] price, int target, Integer[][] dp) {

        if (target == 0) return 0;

        if (index == 0) {
            return target * price[0];
        }

        if (dp[index][target] != null) return dp[index][target];

        int notTake = recursion(index - 1, price, target, dp);

        int take = Integer.MIN_VALUE;
        int rodLength = index + 1;

        if (rodLength <= target) {
            take = price[index] + recursion(index, price, target - rodLength, dp);
        }

        return dp[index][target] = Math.max(take, notTake);
    }
}
