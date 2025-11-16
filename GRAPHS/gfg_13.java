// Bellman-Ford


class Solution {
    public int[] bellmanFord(int V, int[][] edges, int src) {
        // code here
        // If we have Negative weights too .. djikstra will fail so we will go with Bellman Ford Algo
        
        double[] distance = new double[V];
        Arrays.fill(distance , 1e8);
        distance[src] =0;
        for(int i=0;i<V-1;i++){
            
            for(int[] e : edges){
                int u = e[0];
                int v =e[1];
                int w = e[2];
                
                if(distance[u] != 1e8 && distance[u] +  w < distance[v]){
                    distance[v] = distance[u] +w;
                }
            }
        }
        // after v-1 times we will achieve the distance array
        //but we need to check one more time to check for negative cycle
        for(int i=V-1;i<V;i++){
            for(int[]e : edges){
                int u = e[0];
                int v = e[1];
                int w = e[2];
                
                if(distance[u] != 1e8 && distance[u] + w < distance[v]){
                    //negative cycle detected..
                    return new int[]{-1};
                }
            }
            
            
        }
        int[] res = new int[distance.length];
        for(int i=0;i<res.length;i++){
            res[i] = (int)distance[i];
        }
        return res;
        
    }
}
