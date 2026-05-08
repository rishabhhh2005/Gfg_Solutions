// https://www.geeksforgeeks.org/problems/leaders-in-an-array-1587115620/1
// Array Leaders
class Solution {
    static ArrayList<Integer> leaders(int arr[]) {
        ArrayList<Integer> res = new ArrayList<>();
        int n  = arr.length;
        if( n ==0) return res;
        res.add(arr[n-1]);
        int maxSeen = arr[n-1];
        int ptr = n-2;  
        while(ptr >=0){
            int curr = arr[ptr]; 
            if(maxSeen <= curr){
                res.add(0, curr);
                maxSeen = curr;
            }
            ptr--;
        }
        return res;  
    }
}
