///                                          LeetCode - Row with Minimum 1's
//                                          Problem: Given a binary matrix, find the row with the minimum number of 1's

class Solution {
    int minRow(int mat[][]) {
        // code here
        int m = mat.length;
        int n = mat[0].length;
        
        int min =Integer.MAX_VALUE;
        int min_index =0;
        
        
        for(int  i=m-1;i>=0;i--){
            int count =0;
            
            for(int j=0;j<n;j++){
                
                if(mat[i][j] == 1){
                    count++;
                }
                
            }
            
            if(count <=min){
                min =count;
                min_index=i;
            }
        }
        
        return min_index+1;
    }
};
//since the inside rows are Unsorted , We cannot solve this problem under O(mxn) time complexity
// We have to traverse each row and count the number of 1's in it, then compare it with the minimum count found so far.
// The time complexity of this solution is O(m*n) where m is the number of rows