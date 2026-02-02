// https://www.geeksforgeeks.org/problems/minimum-depth-of-a-binary-tree/1
// Minimum Depth of a Binary Tree
class Solution {
    int minDepth(Node root) {
        // code here
        if(root == null) return 0;
        if(root.left == null) return 1 + minDepth(root.right);
        if(root.right == null) return 1 + minDepth(root.left);
        int leftlen = 1 + minDepth(root.left);
        int rightlen = 1 + minDepth(root.right);
        return Math.min(leftlen , rightlen);
    }
}