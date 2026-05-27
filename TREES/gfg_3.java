// https://www.geeksforgeeks.org/problems/print-a-binary-tree-in-vertical-order/1
// Vertical Tree Traversal

class Pair{
    Node node;
    int axis;
    
    Pair(Node node, int axis){
        this.node = node;
        this.axis = axis;
        
    }
}
class Solution {
    public ArrayList<ArrayList<Integer>> verticalOrder(Node root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        // Vertical Line Approach
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        
        
        Queue<Pair> q = new LinkedList<>();
        q.offer( new Pair(root, 0));
        
        while(!q.isEmpty()){
            Pair p = q.poll();
        
            Node currNode = p.node;
            int currAxis = p.axis;
            
           if( map.containsKey(currAxis) ) map.get(currAxis).add(currNode.data);
           else {
               map.put(currAxis , new ArrayList<>());
               map.get(currAxis).add(currNode.data);   
           }
            
            if(currNode.left != null) q.offer( new Pair(currNode.left, currAxis-1));
            if( currNode.right != null) q.offer( new Pair(currNode.right, currAxis+1));
            
        }
        
        for(ArrayList<Integer> ax : map.values()){
            res.add(ax);
        }
        return res;
        
    }
}