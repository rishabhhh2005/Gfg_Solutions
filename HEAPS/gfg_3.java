// https://www.geeksforgeeks.org/problems/heap-sort/1
// Heap Sort
class Solution {
    // Function to sort an array using Heap Sort.
    public void heapSort(int arr[]) {
        // code here
        int n = arr.length;
        
        for(int i=n/2-1;i>=0;i--){
            heapify(arr,n,i);
            //convert to Max Heap first
        }
        // Now to sort the array, Swap the first and last elem and then call heapify to
        // restructure then do this again by decreasing the size by 1 as we may not need the 
        // last elem because that is already max val i.e sorted in maxheap
        for(int i=n-1;i>0;i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            
            heapify(arr, i,0);
            
        }
        
    }
    public void heapify(int[]arr,int n , int node){
     
        int largest = node;
        int left = 2*node +1;
        int right = left+1;
        
        if(left < n && arr[left] > arr[largest]){
            largest = left;
        }
        if(right < n && arr[right] > arr[largest]){
            largest = right;
        }
        
        if(largest!=node){
            int temp = arr[node];
            arr[node] = arr[largest];
            arr[largest] = temp;
            
            heapify(arr,n, largest);
        }
    }
}