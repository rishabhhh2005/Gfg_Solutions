// Directed Graph Cycle
class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        //easy topo sort with kahn's algo
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++) adj.add( new ArrayList<>());
        
        for(int []e : edges){
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v);
        }
        int[] indegree = new int[V];
        for(int i=0;i<adj.size();i++){
            for(int node : adj.get(i)){
                indegree[node]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<indegree.length;i++){
            if( indegree[i] == 0) q.offer(i);
        }
        ArrayList<Integer> res = new ArrayList<>();
        while(!q.isEmpty()){
            int curr = q.poll();
            for( int node : adj.get(curr)){
                indegree[node]--;
                if(indegree[node] == 0) q.offer(node);
            }
            res.add(curr);
        }
        if(res.size() != V) return true; // cyclic graph will leave a node in topo sort everytime
        return false;
        
    }
}