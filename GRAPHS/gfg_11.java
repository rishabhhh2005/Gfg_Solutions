// Shortest path in Directed Acyclic Graph

class Solution {

    public int[] shortestPath(int V, int E, int[][] edges) {
        // Code here
        //Since this is a Directed GRaph we might need to use Topo sorting first to avoid processing child before parent
        //parent -> child must be performed inorder to get shortest distance
        
       //making adj list
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        for(int i=0;i<V;i++) adj.add( new ArrayList<>());
        
        for(int[]e : edges){
            int e1=e[0];
            int e2=e[1];
            int w=e[2];
            ArrayList<Integer> curr = new ArrayList<>();
            curr.add(e2);
            curr.add(w);
            adj.get(e1).add(curr);
        }
        //now we have proper desired adjacency list
        
         //topo sort
        Stack<Integer> stack = new Stack<>();
        boolean[]visited = new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
                dfs(i , adj , visited, stack);
            }
        }
        // now we  have topo order in stack we will go with ( Shortest Path Algo array)
        int[] distance = new int[V];
        Arrays.fill(distance , Integer.MAX_VALUE);
        distance[0] = 0; // it is mentioned in the question that src = 0
       
        while(!stack.isEmpty()){
            //now we will apply Shortest path algo
            int node = stack.pop();
            int dis = distance[node];
            for(  ArrayList<Integer> curr : adj.get(node)){
                // {4,2}
                int curr_neigh = curr.get(0);
                int curr_dist = curr.get(1);
                if(distance[node] != Integer.MAX_VALUE &&
                   distance[curr_neigh] > distance[node] + curr_dist){
                       
                    distance[curr_neigh] = distance[node] + curr_dist;
                }
            }
            
        }
        for(int i=0;i<distance.length;i++){
            if(distance[i] == Integer.MAX_VALUE){
                distance[i] =-1;
            }
        }
        return distance;
        
    }
    
    public void dfs( int node , 
                    ArrayList<ArrayList<ArrayList<Integer>>> adj ,
                    boolean[] visited,
                    Stack<Integer> stack
                    ){
                        if(visited[node]) return;
                        visited[node] = true;
                        
                        for (ArrayList<Integer> edge : adj.get(node)) {
                            int neigh = edge.get(0);
                            if (!visited[neigh]) dfs(neigh, adj, visited, stack);
                        }

                        stack.push(node);
                    }
}