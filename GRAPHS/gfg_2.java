// DFS of graph
class Solution {
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int v = adj.size();
        boolean[]visited= new boolean[v];
        int a =0;
        ArrayList<Integer> res = new ArrayList<>();
        dfs(adj , visited , a , res);
        return res;
    }
    public void dfs(ArrayList<ArrayList<Integer>> adj , boolean[]visited, int a, ArrayList<Integer> res){
        visited[a] =true;
        res.add(a);
        
        
        for(int i : adj.get(a)){
            if(!visited[i]){
                dfs(adj , visited, i, res);
            }
        }
        
    }
}