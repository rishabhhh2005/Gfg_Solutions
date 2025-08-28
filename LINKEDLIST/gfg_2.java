// Add 1 to a Linked List Number
class Solution {
    public Node addOne(Node head) {
        Node rhead = reverse(head);
        Node t = rhead;
        Node r = rhead;
        boolean found = false;

        while (t != null) {
            if (t.data < 9) {
                found = true;
                t.data += 1;
               
                while (r != t) {
                    r.data = 0;
                    r = r.next;
                }
                break;
            }
            t = t.next;
        }

        if (!found) {
            
            Node z = new Node(1);
          
            t = rhead;
            while (t.next != null) {
                t = t.next;
            }
            t.next = z;
            z.next = null;

           
            t = rhead;
            while (t != z) {
                t.data = 0;
                t = t.next;
            }
        }

        return reverse(rhead);
    }

    public Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
