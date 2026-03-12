// https://www.geeksforgeeks.org/problems/count-distinct-elements-in-every-window/1
// Count distinct elements in every window

class Solution {
    ArrayList<Integer> countDistinct(int arr[], int k) {
        // code here
        int n = arr.length;
        if( k > n) return new ArrayList<>();
        ArrayList<Integer> res=  new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<=k-1;i++){
            
            map.put(arr[i], map.getOrDefault(arr[i],0)+1);
        }
        int left =0;
        int right = k-1;
    
        while(right < n){
             res.add(map.size());
            //remove left
            int l = arr[left];
            map.put(l, map.get(l)-1);
            if(map.get(l) == 0) map.remove(l);
            
            //add right
            right++;
            if(right<n){int r = arr[right];
            map.put(r, map.getOrDefault(r,0)+1);}
            
            
            
            
            left++;
            
        }
        return res;
    }
}