// https://www.geeksforgeeks.org/problems/find-the-number-of-islands/1
// Find the number of islands
class Solution {
    public int countIslands(char[][] grid) {
        // Code here
        int a =grid.length;
        int b = grid[0].length;
        
        int noOfislands  =0;
        boolean[][] visited = new boolean[a][b];
        for(int i=0;i<a;i++){
            for(int j =0; j<b;j++){
                if(!visited[i][j] && grid[i][j] == 'L' ){
                    dfs(i,j,grid,a,b, visited);
                    noOfislands++;
                }
            }
        }
        return noOfislands;
        
    }
    public void dfs(int i, int j , char[][] grid,int m , int n, boolean[][] visited){
        if(i < 0 || j < 0 || i >= m || j >= n) return;
        if(visited[i][j] || grid[i][j] != 'L') return;
       
        visited[i][j] = true;
        
        if(i>0 && grid[i-1][j] == 'L') dfs(i-1, j, grid,m,n, visited);
        if(i<m-1 && grid[i+1][j] == 'L') dfs(i+1, j, grid,m,n, visited);
        if(j>0 && grid[i][j-1] == 'L') dfs(i, j-1, grid,m,n, visited);
        if(j<n-1 && grid[i][j+1] == 'L') dfs(i, j+1, grid,m,n, visited);
        if(i>0 && j>0 && grid[i-1][j-1] == 'L') dfs(i-1, j-1, grid,m,n, visited);
        if(i>0 && j<n-1 && grid[i-1][j+1] == 'L') dfs(i-1, j+1, grid,m,n, visited);
        if(i<m-1 && j>0 && grid[i+1][j-1] == 'L') dfs(i+1, j-1, grid,m,n, visited);
        if(i<m-1 && j<n-1 && grid[i+1][j+1] == 'L') dfs(i+1, j+1 , grid,m,n, visited);
        
    }
}