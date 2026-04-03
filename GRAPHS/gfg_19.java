// Graph is Tree or Not
class Solution {
    boolean[]visited;
    int[]parent;
    public boolean isTree(int n, int m, ArrayList<ArrayList<Integer>> edges) {
        if(m != n-1) return false;
        // we need to do DFS
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i =0;i<n;i++) adj.add(new ArrayList<>());
        for(ArrayList<Integer> e : edges){
            int u = e.get(0);
            int v = e.get(1);
            
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        

        
        // 1) we need to take care of Cycle in This graph
        // we will use visited + parent
        
        this.visited = new boolean[n];
        this.parent = new int[n];
        Arrays.fill(parent , -1);
        for(int i=0;i<n;i++){
            if(!visited[i]){
                if( dfs(i, adj)) return false;
            }
        }
        // 2) we need to check if any node is unvisited or not because that would be isolated node
        for(boolean v : visited){
            if(!v) return false;
        }
        return true;
        
    }
    public boolean dfs( int node , ArrayList<ArrayList<Integer>> adj ){
        visited[node] = true;
        
        for(int neigh : adj.get(node)){
            if(!visited[neigh]){
                parent[neigh] = node;
                if(dfs (neigh, adj)) return true;
            }
            else{
                if( parent[node] != neigh) return true;
            }
            
        }
        return false;
    }
}
