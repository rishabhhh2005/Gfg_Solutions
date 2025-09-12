//  Problem : Sort a stack 
class GfG {
    public Stack<Integer> sort(Stack<Integer> s) {
        if(s.isEmpty()) return s;
        
        int top = s.pop();
        sort(s);
        sortedinsert(top,s);
        // add code here.
        return s;
        
    }
    public void sortedinsert(int elem , Stack<Integer>s){
        
        if(s.isEmpty() || elem > s.peek()){
            s.push(elem);
            return;
            
            
        }
        int top = s.pop();
        sortedinsert(elem, s);
        s.push(top);
        
    }
}