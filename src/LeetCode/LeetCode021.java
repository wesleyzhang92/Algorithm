package LeetCode;

/**
 * Merge Two Sorted Lists
 * <p>
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 * <p>
 * KeyWords: LinkedList,Recursive
 * Difficulty: Easy
 */
public class LeetCode021 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head, p;
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val > l2.val) {
            p = l2;
            l2 = l2.next;
        } else {
            p = l1;
            l1 = l1.next;
        }
        head = p;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                p.next = l2;
                l2 = l2.next;
            } else {
                p.next = l1;
                l1 = l1.next;
            }
            p = p.next;
        }
        if (l1 == null)
            p.next = l2;
        else
            p.next = l1;
        return head;
    }

    //Better Solution:利用递归，简化代码
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }
}
