// Minimum Spanning Tree - Kruskal's Algorithm
class DisjointSet{
    
    int[] parent , rank;
    
    DisjointSet(int n) {
        parent = new int[n];
        rank = new int[n];
        
        for(int i=0 ;i<n;i++){
            parent[i] =i;
            rank[i] =0;
        }
    }
    
    int findPar(int x){
        if( parent[x] == x) return x;
        
        return parent[x] = findPar(parent[x]);// path compression along with return
        
    }
    
    void unionByRank(int x , int y){
        int px = findPar(x);
        int py = findPar(y);
        if(px == py) return;
        
        if(rank[px] < rank[py]){
            parent[px] = py;
        }
        else if (rank[px] > rank[py]){
            parent[py] = px;
        }
        else{
            parent[py] =px;
            rank[px]++;
        }
    }
}


class Solution {
    static int kruskalsMST(int V, int[][] edges) {
        // code here
        //we will apply kruksal algorithm because
        // for this we will need Disjoint sets
        DisjointSet ds = new DisjointSet(V);
        int count=0; // when we reach V-1. we stop our Iteration
        Arrays.sort(edges , Comparator.comparingInt(e -> e[2])); 
        // sort the array acc to weight
        int min_sum=0;
        for(int[]e : edges){
            int u =e[0];
            int v = e[1];
            int w = e[2];
            
            if(ds.findPar(u) != ds.findPar(v)){ // make sure they are not from same component
                ds.unionByRank(u,v);
                min_sum += w;
                if(++count == V-1) break;
            }
            
        }
        return min_sum;
        
        
        
        
    }
}
