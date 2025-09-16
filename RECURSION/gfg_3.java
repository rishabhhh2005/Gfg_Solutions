// Problem : Generate all binary strings 
class Solution {
    static List<String> list = new ArrayList<>();
    public static List<String> generateBinaryStrings(int n) {
        // code here
        list = new ArrayList<>();
        if (n == 0) return list;
        generateBinaryStrings(n , "");
        return list;
        
        
    }
    
    public static void generateBinaryStrings(int n , String prefix){
        if(n ==0){
            list.add(prefix);
            return;
        }
        
        generateBinaryStrings(n-1 , prefix+"0");
        
        if(prefix.isEmpty() ||  prefix.charAt(prefix.length()-1) =='0'){
            
            generateBinaryStrings(n-1, prefix +"1");
        }
        
    }
}
