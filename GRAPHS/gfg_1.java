 // BFS of graph
class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int v = adj.size();
        boolean[] visited = new boolean[v];
        ArrayList<Integer> res = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        
        visited[0]=true;
        q.offer(0);
        
        while(!q.isEmpty()){
            int curr = q.poll();
            res.add(curr);
            
            for(int x : adj.get(curr)){
                if(visited[x] == false){
                    visited[x] = true;
                    q.add(x);
                }
            }
            
        }
        return res;
    }
}