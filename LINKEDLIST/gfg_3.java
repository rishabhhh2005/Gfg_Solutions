// Delete all occurrences of a given key in a doubly linked list
class Solution {
    static Node deleteAllOccurOfX(Node head, int x) {
        // Write your code here
        if(head == null) return head;
        
        Node curr = head;
        while(curr!=null){
            if(curr.data == x && curr==head){
                //first element is the key
                curr = curr.next;
                head =curr;
                continue;
            }
            if(curr.data == x){
                if(curr.next!=null){
                    curr.prev.next = curr.next;
                    curr.next.prev = curr.prev;
                    Node temp =curr.next;
                    curr.prev=null;
                    curr.next=null;
                    curr=temp;
                    continue;
                    
                    
                }
                else{
                    curr.prev.next =null;
                    curr.prev=null;
                    break;
                }
            }
            curr =curr.next;
            
            
            
        }
        return head;
    }
}