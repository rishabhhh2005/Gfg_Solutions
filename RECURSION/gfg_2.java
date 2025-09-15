// Problem: Reverse a stack
class Solution {
    static List<Integer> list = new ArrayList<>();
    static void reverse(Stack<Integer> St) {
        
        if(!St.isEmpty()){
            int top = St.pop();
            list.add(top);
            reverse(St);
        }
        
        if(!list.isEmpty()){
            St.push(list.remove(0));
        }
        
        
    }
}
