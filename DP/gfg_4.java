// Partitions with Given Difference

class Solution {
    public int countPartitions(int[] arr, int diff) {
        // code here
        int n= arr.length;
        int total = 0;
        for(int x : arr) total += x;
        if(diff > total) return 0;
        if((total-diff) %2 !=0) return 0;
        
        //we would need a target sum to be (total-diff)/2
        int target = (total-diff)/2;
        Integer[][] dp = new Integer[n][target+1];
        return recursion(0,0,target,arr,n,dp);
    }
    
    public int recursion(int index,  int currsum , int target , int[]arr, int n,Integer[][]dp){
       if(currsum > target) return 0;
        if(index == n) return (currsum == target)?1:0;
        if(dp[index][currsum] != null) return dp[index][currsum];
        
        int take = recursion(index+1, currsum+arr[index] , target, arr, n,dp);
        int notake = recursion(index+1, currsum , target , arr, n,dp);
        dp[index][currsum] = take + notake;
        return dp[index][currsum];
        
    }
}
