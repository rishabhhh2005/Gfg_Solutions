// 0-1 KnapSack Problem
class Solution {
    public int knapsack(int W, int val[], int wt[]) {
        // try out all possible ways
        int  n = val.length;
        Integer[][] dp = new Integer[n+1][W+1];
        return recursion(0,0,0,W,val,wt,n,dp);
        
      
        
    }
    int maxcap=0;

    public int recursion(int index ,int currweight,int currval, int W , int[] val , int wt[] , int n, Integer[][] dp){
       if(currweight > W) return Integer.MIN_VALUE;
       if(index == n) return 0;
       if(dp[index][currweight] != null) return dp[index][currweight];

        
        
         int take = Integer.MIN_VALUE;
         if(currweight + wt[index] <= W)
             take = val[index] + recursion(index+1, currweight + wt[index], currval, W, val, wt, n, dp);

         int notake = recursion(index+1, currweight, currval, W, val, wt, n, dp);

         return dp[index][currweight] = Math.max(take, notake);

        
        
        
    }
    
}
