//All divisors of a number
class Solution {
    public static void print_divisors(int n) {
        // code here
        List<Integer> list = new ArrayList<>();
        
        for(int i=1;i*i<=n;i++){
            if(n%i==0){
                list.add(i);
            }
        }
        //
        for(int i=(int)Math.sqrt(n);i>=1;i--){
            if(n%i ==0 && !list.contains(n/i)){
                list.add(n/i);
                
            }
            
        }
        for(int num : list){
            System.out.print(num + " ");
        }
        
        
    }
}
