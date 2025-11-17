// Minimum Spanning Tree
class Solution {
    public int spanningTree(int V, int[][] edges) {
        // To find the Minimum SUM OF Spanning Tree we would need to perfom PRIM.s ALGORITHM
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        for(int i=0;i<V;i++) adj.add( new ArrayList<>());
        
        for(int[]e : edges){
            int u = e[0];
            int v = e[1];
            int w = e[2];
            // u->v
            ArrayList<Integer> curr =new ArrayList<>();
            curr.add(v);
            curr.add(w);
            adj.get(u).add(curr);
            ///v->u
            ArrayList<Integer> curr2 = new ArrayList<>();
            curr2.add(u);
            curr2.add(w);
            adj.get(v).add(curr2);

        }
        boolean[]visited = new boolean[V];  // visited to keep track of unvisited nodes
        PriorityQueue<int[]> pq = new PriorityQueue<>( (a,b) -> a[0]-b[0]);
        //(PQ wil automatically pick the smallest weight node  first)
        
      
        
        pq.offer( new int []{0 , 0, -1}); // weight ,  node , parent 
        
        ArrayList<ArrayList<Integer>> MST = new ArrayList<>(); // arraylist to store nodes
        
        int sum=0; // sum to keep track of minimum spanning tree sum
        //PRIM'S ALGO START
        while(!pq.isEmpty()){
            int [] curr = pq.poll();
            int weight = curr[0];
            int node = curr[1];
            int parent = curr[2];
            
            if(visited[node]) continue;
            visited[node] = true;
            if( parent != -1){
                MST.add(new ArrayList<>(Arrays.asList(parent, node)));
                sum = sum + weight;
                
            } 
            for(ArrayList<Integer> a : adj.get(node)){
                    int neigh = a.get(0);
                    int neigh_weight = a.get(1);
                    
                    if(!visited[neigh]){
                        pq.offer( new int[] {neigh_weight , neigh , node}); 
                        // pasing neigh as node and node as parent
                    }
            }
        }
        
        // MST will have The minimum spanning tree nodes
        // and sum will have Minimum Spnning Tree weight
        return sum;
    }
}
