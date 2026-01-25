// https://www.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1
// Longest Substring with K Uniques

import java.util.*;

class Solution {
    public int longestKSubstr(String s, int k) {
        // HashMap me character ka last seen index store kar rahe hain
        HashMap<Character, Integer> map = new HashMap<>();
        
        int left = 0;   // sliding window ka left pointer
        int right = 0;  // sliding window ka right pointer
        int maxi = -1;  // maximum length of substring, default -1

        char[] str = s.toCharArray();
        int n = str.length;

        while (right < n) {
            char curr = str[right];
            map.put(curr, right); // current character ka last index update kar do

            // Agar distinct characters k se zyada ho gaye
            if (map.size() > k) {
                // leftmost character ka index find karo
                int minindex = Collections.min(map.values());
                char chartoremove = str[minindex];
                
                // use map se remove karo
                map.remove(chartoremove);
                
                // left ko next index pe shift karo
                left = minindex + 1;
            }

            // agar exactly k distinct characters hai to max length update karo
            int windowlen = right - left + 1;
            if (map.size() == k) {
                maxi = Math.max(maxi, windowlen);
            }

            // window ka right pointer aage badhao
            right++;
        }

        // maximum length return karo, agar nahi mila to -1
        return maxi;
    }
}
