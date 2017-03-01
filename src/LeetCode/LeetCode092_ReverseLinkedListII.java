package LeetCode;

/**
 * Reverse Linked List II
 * <p>
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * <p>
 * For example:
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * <p>
 * return 1->4->3->2->5->NULL.
 * <p>
 * Note:
 * Given m, n satisfy the following condition:
 * 1 ≤ m ≤ n ≤ length of list.
 * <p>
 * KeyWords: LinkedList
 * Difficulty: Medium
 */
public class LeetCode092_ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m >= n)
            return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        head = dummy;
        for (int i = 0; i < m - 1; i++) {
            if (head == null)
                return null;
            head = head.next;
        }
        ListNode preN = head;
        ListNode mNode = head.next;
        ListNode nNode = mNode, postN = nNode.next;
        for (int i = m; i < n; i++) {
            if (postN == null) {
                return null;
            }
            ListNode temp = postN.next;
            postN.next = nNode;
            nNode = postN;
            postN = temp;
        }
        mNode.next = postN;
        preN.next = nNode;

        return dummy.next;
    }
}
