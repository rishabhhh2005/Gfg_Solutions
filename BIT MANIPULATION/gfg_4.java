//Find XOR of numbers from L to R
class Solution {
    public static int findXOR(int l, int r) {
        if(l ==r) return l;
        
        return findfromzero(r) ^ findfromzero(l-1);
        
    }
    public static int findfromzero(int n){
        if(n%4 == 1) return 1;
        if(n%4 ==2) return n+1;
        if(n%4 == 3) return 0;
        else return n; 
    }

}