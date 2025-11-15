// Shortest Path in Weighted undirected graph
class Solution {
    public List<Integer> shortestPath(int n, int m, int edges[][]) {
        // DIJKSTRA'S ALGORITHM
        ArrayList<ArrayList<ArrayList<Integer>>> adj  = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        
        // building undirected graph
        for(int e[] : edges){
            int e1 = e[0] - 1;
            int e2 = e[1] - 1;
            int w = e[2];

            ArrayList<Integer> curr = new ArrayList<>();
            curr.add(e2);
            curr.add(w);
            adj.get(e1).add(curr);

            ArrayList<Integer> rev = new ArrayList<>();
            rev.add(e1);
            rev.add(w);
            adj.get(e2).add(rev);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);

        int[] distance = new int[n];
        Arrays.fill(distance , Integer.MAX_VALUE);
        distance[0] = 0;

        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        parent[0] = 0;   // source ka parent khud

        pq.offer(new int[]{0,0}); // node, distance

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int node = curr[0];
            int dist = curr[1];

            if(dist > distance[node]) continue;

            for(ArrayList<Integer> a : adj.get(node)){
                int neigh = a.get(0);
                int neigh_dist = a.get(1);
                
                if(distance[neigh] > dist + neigh_dist){
                    distance[neigh] = dist + neigh_dist;
                    parent[neigh] = node;
                    pq.offer(new int[] {neigh , dist + neigh_dist});
                }
            }
        }


          // at the end we will be left with the  parent array and distance array
        // this will be for the path thing
        
    //     List<Integer> shortestPath = new ArrayList<>();
    //     int curr = n-1;
    //   if(distance [curr] ==  Integer.MAX_VALUE) return Arrays.asList(-1);
    //     while(parent[curr] != -1 && parent[curr] != curr){ // loop until we reach to starting where parent is itself
    //         shortestPath.add(curr+1);
    //         curr = parent[curr];
            
    //     }
    //     shortestPath.add(curr + 1);
    //     Collections.reverse(shortestPath);
    //     return shortestPath;
    //but in this q it is asking for shortest distance
        // PATH RECONSTRUCTION
        int dest = n - 1;

        if(distance[dest] == Integer.MAX_VALUE){
            return Arrays.asList(-1);
        }

        List<Integer> path = new ArrayList<>();
        int curr = dest;

        // building path using parent[]
        while(parent[curr] != curr){
            path.add(curr + 1);
            curr = parent[curr];
        }
        path.add(curr + 1); // add source
        Collections.reverse(path);

        // now final output: [totalWeight, path...]
        List<Integer> ans = new ArrayList<>();
        ans.add(distance[dest]);
        ans.addAll(path);

        return ans;
    }
}


    