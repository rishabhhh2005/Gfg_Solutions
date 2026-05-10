// https://www.geeksforgeeks.org/problems/smallest-positive-missing-number-1587115621/1
// Smallest Positive Missing
class Solution {
    public int missingNumber(int[] arr) {
        // code here
        // we can keep track of smallest positive ignoring the negative Numbers
 // We need to find the smallest element whose next  is not present in the array       
        Set<Integer> set = new HashSet<>();
        int max = 0;
        for(int x : arr){ set.add(x); max = Math.max(max, x);}
        
        int missing =1;
        
        while(missing <=max){
            if(!set.contains(missing)) return missing;
            missing++;
        }
        return max+1;
    }
}
