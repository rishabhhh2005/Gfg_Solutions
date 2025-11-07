// Connected Components in an Undirected Graph
class Solution {
    public ArrayList<ArrayList<Integer>> getComponents(int v, int[][] edges) {
        
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<v;i++) adj.add(new ArrayList<Integer>());
        
        for(int[] e : edges){
            int x =e[0];
            int y =e[1];
            adj.get(x).add(y);
            adj.get(y).add(x);
        }
        boolean[]visited = new boolean[v];
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        
        for(int i=0;i<v;i++){
            
            if(!visited[i]){
                ArrayList<Integer> component = new ArrayList<>();
                dfs(i,adj, component, visited);
                res.add(component);
            }
        }
        return res;
        
    }
    
    public void dfs(int node ,ArrayList<ArrayList<Integer>> adj , ArrayList<Integer> component, boolean[]visited){
        visited[node] =true;
        component.add(node);
        
        for(int i : adj.get(node)){
            if(!visited[i]){
                dfs(i , adj , component , visited);
            }
        }
    }
}