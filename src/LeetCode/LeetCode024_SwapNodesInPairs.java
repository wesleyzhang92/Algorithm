package LeetCode;

/**
 * Swap Nodes in Pairs
 *
 * Given a linked list, swap every two adjacent nodes and return its head.
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 *
 * KeyWords: LinkedList
 * Difficulty: Easy
 */
public class LeetCode024_SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode first = head;
        int i=1;
        if(head==null)
            return head;
        while(head.next!=null){
            if(i%2!=0){
                int tmp=head.val;
                head.val=head.next.val;
                head.next.val=tmp;
            }
            i++;
            head=head.next;
        }

        return first;
    }

    //Better Solution: Use Recursion
    public ListNode swapPairs2(ListNode head) {
        if ((head == null)||(head.next == null))
            return head;
        ListNode n = head.next;
        head.next = swapPairs2(head.next.next);
        n.next = head;
        return n;
    }

    public ListNode swapPairs3(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;
        while (current.next != null && current.next.next != null) {
            ListNode first = current.next;
            ListNode second = current.next.next;
            first.next = second.next;
            current.next = second;
            current.next.next = first;
            current = current.next.next;
        }
        return dummy.next;
    }
}
