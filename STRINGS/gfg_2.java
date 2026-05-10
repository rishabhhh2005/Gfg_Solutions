// http://geeksforgeeks.org/problems/substrings-of-length-k-with-k-1-distinct-elements/1
// Substrings of length k with k-1 distinct elements

class Solution {
    public int substrCount(String s, int k) {
        // code here
        Map<Character, Integer> map = new HashMap<>();
        int count=0;
        int left =0;
        int right=0;
        
        int n = s.length();
        while(right < n){
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c,0)+1);
            
            while((right-left+1) > k){
                char l =s.charAt(left);
                map.put(l, map.get(l)-1);
                if(map.get(l) == 0) map.remove(l);
                left++;
            }
            
            if(map.size() == k-1 && (right-left+1) == k){
                count++;
            }
            
            right++;
        }
        return count;
        
    }
}