// https://www.geeksforgeeks.org/problems/immediate-smaller-element1142/1\
//Next Smaller Element

class Solution {
    static ArrayList<Integer> nextSmallerEle(int[] arr) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        
        int[]res = new int[arr.length];
        
        res[res.length-1] = -1;
        
        int pos = res.length-2;
        st.push(arr[arr.length-1]);
        
        while(pos >=0){
            
            int curr = arr[pos];
            
            while (!st.isEmpty() && st.peek() >= curr) {
                st.pop();
            }
            
            if (st.isEmpty()) {
                res[pos] = -1;
            } else {
                res[pos] = st.peek();
            }
            
            st.push(curr);
            pos--;
        }
        
        for(int n : res){
            result.add(n);
            
        }
        return result;
    }
}