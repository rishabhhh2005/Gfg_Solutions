// https://www.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1
// Max Sum Subarray of size K
class Solution {
    int max =0;
    public int maxSubarraySum(int[] arr, int k) {
        
        int n = arr.length;
        // Code here
        int left =0;
        int right =0;
        int currsum =0;
        while(right <n){
            currsum += arr[right];
            
            while(right-left+1 >k){
                currsum -= arr[left];
                left++;
            }
            max = Math.max(max, currsum);
            right++;
            
        }
        return max;
        
    }
 
}