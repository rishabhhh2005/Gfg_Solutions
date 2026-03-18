// Strongly Connected Components (Kosaraju's Algorithm)
class Solution {
    // Function to find number of strongly connected components in the graph
    public int kosaraju(int V, int[][] edges) {
        //BUILD GRAPH
         ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i =0; i<V;i++) adj.add(new ArrayList<>());
        
        for(int[] e : edges){
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v);
        }
        //graph formation is done
        
        // OKAY WE WILL USE KOSARAJU ALGORITHM
        
        //Gyaan :- sun.. SCC1 ---> SCC2 ---> SCC3
        // saare SCC components ek order me hote hai and ham agar graph reverse krde to one SCC
        //cant reach another scc. to ham us scc me hi rehjayege .. jis se ham dfs se no of SCC
        // nikal skte hai
        // idea is to find the topo order of nodes in scc  
        //put them in stack
        //reverse the graph
        // do dfs + visited
        
        //STEP 1 : TOPO SORT + STACK
        Stack<Integer> st = new Stack<>();
        boolean[] vis  = new boolean[V];
        for(int i=0;i<V;i++){
            if(!vis[i]) dfs1(i,adj,vis,st);
        }
        //stack building is done
        
        // STEP -2 Reverse the Graph
         ArrayList<ArrayList<Integer>> rev = new ArrayList<>();
        for(int i =0; i<V;i++) rev.add(new ArrayList<>());
        
        for(int[] e : edges){
            int u = e[0];
            int v = e[1];
            rev.get(v).add(u);
        }
        
        // STEP -3 DO simple dfs and count scc
        int components=0;
        boolean[] visited = new boolean[V];
        while(!st.isEmpty()){
            int node = st.pop();
            if(!visited[node]){
                components++;
                dfs2(node, rev, visited);
            }
        }
        return components;
        

    }
    // dfs 1 to push into stack
    public void dfs1(int node, ArrayList<ArrayList<Integer>> adj , boolean[] vis, Stack<Integer> st){
        
        vis[node] = true;
        for(int neigh : adj.get(node)){
            if(!vis[neigh]) dfs1(neigh,adj,vis,st);
        }
        st.push(node); // at last push the node if no neighbours left
    }
    //dfs2 for last step
    public void dfs2(int node, ArrayList<ArrayList<Integer>> adj , boolean[] visited){
        
        visited[node] = true;
        for(int neigh : adj.get(node)){
            if(!visited[neigh]) dfs2(neigh,adj,visited);
        }
      
    }
}