package LeetCode;

/**
 * Reverse Linked List
 * <p>
 * Reverse a singly linked list.
 * Hint:
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 * <p>
 * KeyWords: LinkedList
 * Difficulty: Easy
 */
public class LeetCode206_ReverseLinkedList {
    // Iteratively Solution
    public ListNode reverseList(ListNode head) {
        ListNode first = null;
        while (head != null) {
            ListNode tmp = new ListNode(head.val);
            tmp.next = first;
            first = tmp;
            head = head.next;
        }
        return first;
    }

    // Recursive Solution
    public ListNode reverseList2(ListNode head) {
        return reverseListInt(head, null);
    }

    private ListNode reverseListInt(ListNode head, ListNode newHead) {
        if (head == null)
            return newHead;
        ListNode next = head.next;
        head.next = newHead;
        return reverseListInt(next, head);
    }

    public ListNode reverseList3(ListNode head) {
        if (head == null)
            return null;
        ListNode prev = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = prev;
            prev = head;
            head = tmp;
        }
        return prev;

    }
}
