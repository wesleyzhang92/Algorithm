package LeetCode;

/**
 * Remove Duplicates from Sorted List
 *
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 *
 * KeyWords: LinkedList
 * Difficulty: Easy
 */
public class LeetCode083_RemoveDuplicatesfromSortedList {
    public ListNode deleteDuplicates3(ListNode head) {
        ListNode tmp=head;
        if(head==null||head.next==null){
            return head;
        }
        while(tmp!=null&&tmp.next!=null){
            if(tmp.val==tmp.next.val){
                tmp.next=tmp.next.next;
            }else{
                tmp=tmp.next;
            }
        }
        return head;
    }


    //Recursive Solution

    public ListNode deleteDuplicates2(ListNode head) {
        if(head == null || head.next == null)return head;
        head.next = deleteDuplicates2(head.next);
        return head.val == head.next.val ? head.next : head;
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode first = head.next;
        while (first != null && head.val == first.val) {
            first = first.next;
        }
        head.next = deleteDuplicates(first);
        return head;
    }

    public static void main(String[] args) {
        LeetCode083_RemoveDuplicatesfromSortedList lc = new LeetCode083_RemoveDuplicatesfromSortedList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        ListNode tmp = lc.deleteDuplicates(head);

    }
}
