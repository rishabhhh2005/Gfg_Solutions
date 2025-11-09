//Undirected Graph Cycle
class Solution {
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i=0;i<V;i++) adj.add( new ArrayList<>());
        
        for(int[] e : edges){
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        boolean[]visited = new boolean[V];
        
        for(int i=0;i<V;i++){
            if(!visited[i]){
                if(bfs(i,visited, adj)) return true;
            }
        }
        return false;
        
    }
    
    public boolean bfs(int start , boolean[]visited, ArrayList<ArrayList<Integer>> adj ){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start,-1});
        visited[start] = true;
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int node = curr[0];
            int parent = curr[1];
            for(int neighbour : adj.get(node)){
                if(!visited[neighbour]){
                    visited[neighbour] = true;
                    q.offer(new int[]{neighbour,node});
                }
                else if(neighbour != parent){
                    return true;
                }
            }
            
        }
        return false;
    
        
    }
}