package LeetCode;

/**
 * Remove Linked List Elements
 * <p>
 * Remove all elements from a linked list of integers that have value val.
 * Example
 * Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 * Return: 1 --> 2 --> 3 --> 4 --> 5
 * <p>
 * KeyWords: LinkedList
 * Difficulty: Easy
 */
public class LeetCode203_RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {
        ListNode first = new ListNode(0);
        ListNode result = first;
        first.next = head;
        if (head == null)
            return null;
        while (head.next != null) {
            if (head.val != val) {
                head = head.next;
                first = first.next;
            } else {
                first.next = head.next;
                head = head.next;
            }
        }
        if (head.next == null && head.val == val)
            first.next = null;
        return result.next;
    }

    //Recursive Solution
    public ListNode removeElements2(ListNode head, int val) {
        if (head == null) return null;
        head.next = removeElements2(head.next, val);
        return head.val == val ? head.next : head;
    }

}
