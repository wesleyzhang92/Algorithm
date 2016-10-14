package datastructure;

/**
 * Created by wesley on 2016/10/11.
 */
public class ReverseLinkedList {
    public void reverse(LinkedList ls){
        Node q = ls.first;
        Node p = null,r = null;
        while(true)
        {
            r = q.next;
            q.next = p;
            if(r == null)
            {
                ls.first = q;
                break;
            }
            p = q;
            q = r;
        }
    }
    public static void main(String[] args){
        LinkedList ls = new LinkedList();
        ls.addFirst(10);
        ls.addFirst(20);
        ls.addFirst(30);
        ReverseLinkedList rl = new ReverseLinkedList();
        rl.reverse(ls);
        System.out.println(ls.first.next.data);
    }
}
