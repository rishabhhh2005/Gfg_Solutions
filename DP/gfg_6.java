// Knapsack with Duplicate Items
class Solution {
    public int knapSack(int val[], int wt[], int capacity) {
        // code here
        int n = val.length;
        Integer[][] dp = new Integer[n+1][capacity+1];
        return recursion(0,0,0,val,wt,capacity,n,dp);

    }
 
    public int recursion(int index, int currweight, int currval , int val[] , int wt [], int capacity, int n, Integer dp[][]){
       if(currweight > capacity) return -1000000000;
       if(index >= n) return 0;

        if(dp[index][currweight] != null) return dp[index][currweight];
        int take = val[index] + recursion(index,currweight+wt[index], currval+val[index],val,wt,capacity,n,dp);
        int notake =recursion(index+1,currweight, currval,val,wt,capacity,n,dp);
        return dp[index][currweight] = Math.max(take, notake);
    }
}