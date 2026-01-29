// https://www.geeksforgeeks.org/problems/replace-elements-by-its-rank-in-the-array/1
class Solution {
    static int[] replaceWithRank(int arr[], int N) {
        // code here
        // SORT + HASHMAP 
        HashMap<Integer, Integer> map = new HashMap<>();
        int []newarr = arr.clone();
        
        heapSort(newarr);
        int rank = 1;
        map.put(newarr[0], rank);

        for(int i = 1; i < N; i++){
          if(newarr[i] != newarr[i - 1]){
             rank++;
        }
    map.put(newarr[i], rank);
}

        int [] ans = new int[N];
        int index=0;
        for(int x : arr){
            ans[index] = map.get(x);
           
            index++;
        }
        return ans;
    }
    static void heapSort(int[]arr){
        int n = arr.length;
        
        for(int i=n/2-1;i>=0;i--){
            heapify(i,n,arr);
        }
        for(int i=n-1; i>0;i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            
            heapify(0,i,arr);
        }
        
        
    }
    static void heapify(int node, int n, int[]arr){
        int largest = node;
        int left = 2*node +1;
        int right = 2*node +2;
        
        if(left < n && arr[left] > arr[largest]) largest = left;
        if(right < n && arr[right] > arr[largest]) largest = right;
        
        if(largest != node){
            int temp = arr[node];
            arr[node] = arr[largest];
            arr[largest] = temp;
            
            heapify(largest ,n , arr);
        }
        
    }
}
