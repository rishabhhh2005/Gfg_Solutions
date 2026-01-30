// https://www.geeksforgeeks.org/problems/-minimum-number-of-coins4426/1
// Minimum number of Coins
class Solution {
    public int findMin(int n) {
        // code here
        int[]coins = new int[4];
        coins[0]=1;
        coins[1]=2;
        coins[2]=5;
        coins[3]=10;
        
        int maxcoins=0;
        int p=3;
        int amtleft =n;
        while(p>=0){
            if( coins[p] > amtleft){
                p--;
                continue;
            }
            amtleft = amtleft - coins[p];
            maxcoins++;
            
            
        }
        return maxcoins;
    }
}
