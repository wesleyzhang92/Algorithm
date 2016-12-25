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
    public ListNode deleteDuplicates(ListNode head) {
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
}
