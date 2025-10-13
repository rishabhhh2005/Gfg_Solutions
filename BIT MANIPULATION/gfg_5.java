//Two Odd Occuring

class Solution {
    ArrayList<Integer> twoOddNum(int[] arr) {
        // find all xors
        int res =0;
        for( int  num : arr){
            res^=num;
            
        }
        //finding set bit
        int mask = res & -res;
        
        int num1=0;
        int num2=0;
        
        for(int num : arr){
            if((num & mask) == 0){
                num1^= num; //group 1
            }
            else{
                num2^= num; // group 2
            }
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        if(num1 > num2){
            result.add(num1);
            result.add(num2);
        }
        else{
            result.add(num2);
            result.add(num1);
            
        }
        return result;
    }
}
