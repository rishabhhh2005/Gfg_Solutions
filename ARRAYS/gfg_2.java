// https://www.geeksforgeeks.org/problems/spirally-traversing-a-matrix-1587115621/1
// Spirally traversing a matrix
class Solution {
    public ArrayList<Integer> spirallyTraverse(int[][] mat) {

        ArrayList<Integer> res = new ArrayList<>();

        int m = mat.length;
        int n = mat[0].length;

        int top = 0, bottom = m - 1;
        int left = 0, right = n - 1;

        while (top <= bottom && left <= right) {

            // left -> right
            for (int j = left; j <= right; j++) {
                res.add(mat[top][j]);
            }
            top++;

            // top -> bottom
            for (int i = top; i <= bottom; i++) {
                res.add(mat[i][right]);
            }
            right--;

            // right -> left
            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    res.add(mat[bottom][j]);
                }
                bottom--;
            }

            // bottom -> top
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    res.add(mat[i][left]);
                }
                left++;
            }
        }

        return res;
    }
}
