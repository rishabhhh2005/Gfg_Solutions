//Sort a linked list of 0s, 1s and 2
class Solution {
    public Node segregate(Node head) {
        // code here
       int[]count = new int[3];
        Node curr = head;
        while(curr!=null){
            if(curr.data == 0) count[curr.data]++;
            else if(curr.data == 1) count[curr.data]++;
            else if(curr.data ==2)count[curr.data]++;
            curr =curr.next;
            
        }
        curr = head;
        int data=0;
        while(curr!=null){
            if(count[data] == 0) data++;
            else{
                curr.data = data;
                count[data]--;
                curr=curr.next;
            }
        }
        return head;
        
        
    }
}