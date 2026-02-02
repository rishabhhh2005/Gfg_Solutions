// https://www.geeksforgeeks.org/problems/count-the-paths4332/1
// Count the paths
class Solution {
    //This is a Classical Graph + BackTracking Problem
    // Since it will give TLE
    // We will solve it by   DP on Graph
    public int count =0;
    public Integer[] dp;
    public int countPaths(int[][] edges, int V, int src, int dest) {
   
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i =0;i<V;i++) adj.add( new ArrayList<>());
        // Since We are using DP.. We do not need visited 
        for(int[] e : edges){
            int u = e[0];
            int v= e[1];
            adj.get(u).add(v); // directed graph so we will only add Node one way
            
        }
        dp = new Integer[V];
        // dp[node] -> will represent No of paths to that node
        
        return dfs(src, adj , dest, dp);
       
        // Code here
        
    }
    public int dfs(int node , ArrayList<ArrayList<Integer>> adj , int dest , Integer[] dp){
        if(node ==  dest) return 1;
        if(dp[node] != null) return dp[node]; 
        
       int ways =0;
        for(int neigh : adj.get(node)){
            ways += dfs(neigh , adj , dest, dp);
        }
        return dp[node] = ways;
        
    }
}