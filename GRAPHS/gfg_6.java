// Topological Sort
class Solution {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add( new ArrayList<Integer>());
        }
        
        for(int[] e : edges){
            int u= e[0];
            int v = e[1];
            adj.get(u).add(v);
            
        }
        boolean[] visited = new boolean[V];
        Stack<Integer> topo = new Stack<>();
        for(int i=0;i<V;i++){
            if(!visited[i]){
                dfs_topo_sort(i , adj , visited, topo);
            }
            
        }
        ArrayList<Integer> res = new ArrayList<>();
        while(!topo.isEmpty()) res.add(topo.pop());
        return res;
        
    }
    public void dfs_topo_sort(int node , ArrayList<ArrayList<Integer>> adj, boolean[] visited, Stack<Integer> topo){
        if(visited[node]){

            return;
        }
        visited[node] =true;
        for(int neighbour : adj.get(node)){
            if(!visited[neighbour]){
                dfs_topo_sort(neighbour , adj , visited, topo);
                
            }
            
        }
        topo.push(node);
    }
}