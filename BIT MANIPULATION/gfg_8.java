// https://www.geeksforgeeks.org/problems/swap-two-numbers3844/1
// Swap two numbers
class Solution {
    static List<Integer> get(int a, int b) {
        // code here
        List<Integer> res = new ArrayList<>();
        a = a^b;
        b= a^b;
        a = a^b;
        res.add(a);
        res.add(b);
        return res;
    }
}