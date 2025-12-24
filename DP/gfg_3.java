// Perfect Sum Problem
class Solution {
    // Function to calculate the number of subsets with a given sum
    
    public int perfectSum(int[] nums, int target) {
        // code here
        int n = nums.length;
        Integer[][] dp = new Integer[n+1][target+1];
        return recursion(0,0,target, nums,n,dp);
        
    }
    public int recursion(int index ,int currsum, int target, int[] nums , int n, Integer[][]dp){
        if(index == n) {
            return currsum == target ? 1 : 0;
        }

        if(index == n || currsum > target) return 0 ;
        if(dp[index][currsum] != null) return dp[index][currsum];
      
        int take = recursion(index+1 , currsum + nums[index] , target, nums, n,dp);
        int notake = recursion(index +1 , currsum , target , nums , n,dp);
        dp[index][currsum] = take + notake;
        return dp[index][currsum];
        
    }
}