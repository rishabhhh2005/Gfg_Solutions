// Subset Sum Problem
class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        int n = arr.length;
        int[][] dp = new int[n][sum+1];
        for(int[]x : dp) Arrays.fill(x,-1);
        return recursion(n-1,sum,arr,dp);
        
        
    }
    public static boolean recursion(int index , int target,int[] arr,int[][]dp){
        if(target == 0) return true;
        if(index == 0 )return arr[0] == target;
        if(dp[index][target] != -1) 
            if(dp[index][target] == 1) return true;
            else return false;
        
        boolean notake = recursion(index-1, target,arr,dp);
        boolean take = false;
        
        if(target >= arr[index]){
            take = recursion(index-1 , target-arr[index],arr,dp);
        }
        dp[index][target] = take || notake ?1 :0;
        return take || notake;
        
        
    }
}