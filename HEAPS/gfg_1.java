// https://www.geeksforgeeks.org/problems/does-array-represent-heap4345/1
// Does array represent Heap
class Solution {

    public boolean countSub(long arr[], long n) {
        // Your code goes here
        if(n ==0) return true;
        
        return isMaxHeap(arr,0);
        
    }
    public boolean isMaxHeap(long[] arr, int root){
        
        int left = 2*root +1;
        int right = 2*root+2;
        
        if(left >= arr.length) return true;
        if(arr[root] < arr[left]) return false;
        if(right <arr.length && arr[right] > arr[root]) return false;
        
       
        
       return isMaxHeap(arr, left) &&
       (right < arr.length ? isMaxHeap(arr, right) : true);

   
        
    }
}