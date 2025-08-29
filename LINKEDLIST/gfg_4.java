//Find pairs with given sum in doubly linked list

class Solution {
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target,
                                                                      Node head) {
        // code here
        if(head == null || target<0 || head.next==null) return new ArrayList<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Set<ArrayList<Integer>> set = new LinkedHashSet<>();
        Node curr = head;
        while(curr.next!=null){
            curr = curr.next;
        }
        Node tail =curr;
        
        Node p1 = head;
        Node p2 =tail;
        while(p1!=null && p2!=null && p1 != p2 ){
            if(p1.data + p2.data == target){
                ArrayList<Integer> current = new ArrayList<>();
                current.add(p1.data);
                current.add(p2.data);
                Collections.sort(current);
                set.add(current);
                p1 =p1.next;
                p2=p2.prev;
                
            }
            else if(p1.data + p2.data > target){
                p2 = p2.prev;
                
            }
            else{
                p1 =p1.next;
                
            }
            
        }
        return new ArrayList<>(set);
        
       
    }
}
