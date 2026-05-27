//  https://www.geeksforgeeks.org/problems/check-if-two-nodes-are-cousins/1
// Check if two Nodes are Cousins
class Pair{
    Node node;
    Node parent;
    
    Pair(Node node , Node parent){
        this.node = node;
        this.parent = parent;
    }
}
class Solution {

    // Returns true if the nodes with values 'a' and 'b' are cousins. Else returns false
    public boolean isCousins(Node root, int a, int b) {
        // code here
        // DO BFS AND CHECK SIMPLE
        
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, null));
        
        while(!q.isEmpty()){
            int size = q.size();
            
            boolean containsA = false;
            boolean containsB = false;
            boolean sameParent = true;
            
            Node parentA = null;
            Node parentB= null;
            for(int i=0;i<size;i++){
                Pair curr = q.poll();
                
                if(curr.node.data == a) {containsA =  true; parentA = curr.parent;}
                if(curr.node.data == b) {containsB = true; parentB = curr.parent;}
                
                if(curr.node.left != null) q.offer( new Pair(curr.node.left, curr.node));
                if(curr.node.right != null) q.offer(new Pair(curr.node.right,curr.node));
                
            }
            if(parentA != parentB) sameParent = false;
            
            if(containsA && containsB &&  !sameParent) return true;
        }
        return false;
    }
}