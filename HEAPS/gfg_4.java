// https://www.geeksforgeeks.org/problems/kth-smallest-element5635/1
// Kth Smallest
class Solution {
    public int kthSmallest(int[] arr, int k) {
        // Code here
        // Most Optimal Approahch
        // Create Map Heap of size K then fill till k then 
        //compare if the next elem < root of max heap then swap otherwise dont consider
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i =0; i<k;i++){
            maxheap.offer(arr[i]);
        }
        int i =k;
        
        while(i < arr.length){
            int curr = arr[i];
            if(curr < maxheap.peek()){
                //swap
                maxheap.poll();
                maxheap.offer(curr);
            }
            i++;
        }
        
        return maxheap.poll();
    }
}
