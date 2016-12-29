package LeetCode;

/**
 * Palindrome Linked List
 * <p>
 * Given a singly linked list, determine if it is a palindrome.
 * Could you do it in O(n) time and O(1) space?
 * <p>
 * KeyWords: LinkedList, Two Pointers
 * Difficulty: Easy
 */
public class LeetCode234_PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;
        ListNode first = null;
        ListNode headNew = head;
        while (head != null) {
            ListNode tmp = new ListNode(head.val);
            tmp.next = first;
            first = tmp;
            head = head.next;
        }

        while (first.next != null) {
            if (first.val != headNew.val)
                return false;
            first = first.next;
            headNew = headNew.next;
        }
        return true;
    }

    //O(1) Space Solution
    public boolean isPalindrome2(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode p1 = head;
        ListNode p2 = head;
        ListNode p3 = p1.next;
        ListNode pre = p1;
        //find mid pointer, and reverse head half part
        while (p2.next != null && p2.next.next != null) {
            p2 = p2.next.next;
            pre = p1;
            p1 = p3;
            p3 = p3.next;
            p1.next = pre;
        }

        //odd number of elements, need left move p1 one step
        if (p2.next == null) {
            p1 = p1.next;
        } else {   //even number of elements, do nothing

        }
        //compare from mid to head/tail
        while (p3 != null) {
            if (p1.val != p3.val) {
                return false;
            }
            p1 = p1.next;
            p3 = p3.next;
        }
        return true;

    }
}
