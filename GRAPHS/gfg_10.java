// Dijkstra Algorithm
class Solution {
    public int[] dijkstra(int V, int[][] edges, int src) {
        // code here
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        for(int i=0;i<V;i++) adj.add(new ArrayList<>());
        
        for(int []e : edges){
            int e1 = e[0];
            int e2 = e[1];
            int w = e[2];
            ArrayList<Integer> curr = new ArrayList<>();
            curr.add(e2);
            curr.add(w);
            adj.get(e1).add(curr);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] -  b[1]); // min heap
        int[] distance = new int[V];
        Arrays.fill(distance , Integer.MAX_VALUE);
        distance[src]=0;
        pq.add( new int[]{src, 0});
        
        
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int node = curr[0];
            int dist = curr[1];
            if(dist > distance[node]) continue;
            
            for(ArrayList<Integer> a : adj.get(node)){
                int neigh = a.get(0);
                int neigh_dist = a.get(1);
                
                if( 
                    dist + neigh_dist < distance[neigh]){
                    distance[neigh] = dist + neigh_dist;
                    pq.offer( new int[]{neigh , dist+ neigh_dist});
                }
            }
            
        }
        for(int i=0;i<distance.length;i++){
            if(distance[i] == Integer.MAX_VALUE){
                distance[i]=-1;
            }
        }
        return distance;
    }
}