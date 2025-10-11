// Number of 1 Bits
class Solution {
    static int setBits(int n){
        if(n == 0) return 0;
        int count =0;
        
        while(n >0){
            if(n%2 ==1 ) count++;
            n=n/2;
        }
        
        return count;
        
    
        
        
        
    }
}
