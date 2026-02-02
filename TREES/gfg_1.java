// https://www.geeksforgeeks.org/problems/right-view-of-binary-tree/1
// Right View of Binary Tree
class Solution {
    public ArrayList<Integer> rightView(Node root) {
        // code here
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        ArrayList<Integer> res = new ArrayList<>();
        while(!q.isEmpty()){
            int size = q.size();
            ArrayList<Integer> level = new ArrayList<>();
            for(int i=0; i<size;i++){
                Node curr = q.poll();
                level.add(curr.data);
            
            
                if(curr.left != null) q.offer(curr.left);
                if(curr.right !=  null ) q.offer(curr.right);
            }
            res.add(level.get(level.size()-1));
            
        }
        return res;
    }
}