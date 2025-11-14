// Shortest Path in Undirected Graph
class Solution {
    public int[] shortestPath(int V, int[][] edges, int src) {
        // code here
        //  
        // we will use BFS to fing the shortest path
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++) adj.add( new ArrayList<>());
        for(int e[] : edges){
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        Queue<int[]> q = new LinkedList<>();
        int[] distance = new int[V];
        Arrays.fill(distance , Integer.MAX_VALUE);
        distance[src] = 0;

        
        q.offer( new int[]{src, 0});
        
        while(!q.isEmpty()){
            int[]curr = q.poll();
            int node = curr[0];
            int dis = curr[1];
            
           
            for(int neigh : adj.get(node)){
                if (distance[neigh] > dis + 1) {
                    distance[neigh] = dis + 1;
                    q.offer(new int[]{neigh, dis + 1});
                }

            }
        }
        
        for(int i=0;i<distance.length;i++){
            if(distance[i] ==  Integer.MAX_VALUE){
                distance[i] = -1;
            }
        }
        return distance;
    }
}
