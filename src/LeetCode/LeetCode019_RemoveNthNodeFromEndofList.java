package LeetCode;

/**
 * Remove Nth Node From End of List
 * <p>
 * Given a linked list, remove the nth node from the end of list and return its head.
 * For example,
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass.
 * <p>
 * KeyWords: LinkedList,Two pointers
 * Difficulty: Easy
 */
public class LeetCode019_RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null)
            return null;
        if (head.next.next == null) {
            if (n == 2)
                return head.next;
            if (n == 1) {
                head.next = null;
                return head;
            }
        }
        int size = 0;
        ListNode first = head;
        for (; first.next != null; first = first.next) {
            size++;
        }
        first = head;
        if (size == n - 1) {
            head = head.next;
            return head;
        }
        for (int i = 0; i < size - n; i++) {
            first = first.next;
        }
        first.next = first.next.next;

        return head;
    }

    //Better Solution: 一次遍历
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode node = dummy;
        while (n-- > 0) head = head.next;
        while (head != null) {
            head = head.next;
            node = node.next;
        }
        node.next = node.next.next;
        return dummy.next;
    }
}
