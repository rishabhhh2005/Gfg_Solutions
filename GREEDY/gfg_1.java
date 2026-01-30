// https://www.geeksforgeeks.org/problems/fractional-knapsack-1587115620/1
// Fractional Knapsack
class Solution {
    public double fractionalKnapsack(int[] val, int[] wt, int capacity) {
        // code here
        // we can solve this by Greedy Algorithm 
        // we need to compare ratio 
        
        PriorityQueue<Integer> maxheap = new PriorityQueue<>((a,b) ->
                Double.compare((double) val[b]/ wt[b] , (double) val[a] /wt[a])
                );
        for(int i=0;i<val.length;i++){
            maxheap.offer(i);
        }
        double maxprofit =0;
        int usedweight =0;
        while(usedweight < capacity){
            if(maxheap.isEmpty()) break;
            int index= maxheap.poll();
            
            if(usedweight + wt[index] > capacity){
              double fraction = (double)(capacity - usedweight) / wt[index];
              maxprofit += fraction * val[index];
              break;
            }
            usedweight += wt[index];
            maxprofit += (double)val[index];
            
        }
        return maxprofit;
        
        
        
    }
}