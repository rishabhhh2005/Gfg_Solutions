// Number of Distinct Islands

class Solution {
    

    int countDistinctIslands(int[][] grid) {
        // Iterate + DFS + count+ Keep track of order in a String + save to set + return set size
        //
        int n = grid.length;
        int m= grid[0].length;
        boolean[][]visited = new boolean[n][m];
        Set<String> myset = new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j =0;j<m;j++){
                if(!visited[i][j] && grid[i][j] == 1){
                    StringBuilder order = new StringBuilder();
                    dfs(i,j,grid, visited, order );
                    myset.add(order.toString());
                   
                }
            }
        }
        return myset.size();
        
        
    }
    void dfs(int i , int j , int[][] grid , boolean[][] visited , StringBuilder order){
        int n= grid.length;
        int m = grid[0].length;
        if(visited[i][j])  return;
        if(grid[i][j] == 0 ) return;
        visited[i][j] =true;
        
        
        if ( i-1 >=0 && grid[i-1][j] == 1){
            order.append('U');
            dfs(i-1, j , grid , visited , order);
            order.append('B');
        }
        if ( i+1 <n && grid[i+1][j] == 1){
            order.append('D');
            dfs(i+1, j , grid , visited , order);
            order.append('B');
        }
        if ( j-1 >=0 && grid[i][j-1] == 1){
            order.append('L');
            dfs(i, j-1 , grid , visited , order);
            order.append('B');
        }
        if ( j+1 <m && grid[i][j+1] == 1){
            order.append('R');
            dfs(i, j+1 , grid , visited , order);
            order.append('B');
        }
    }
}
