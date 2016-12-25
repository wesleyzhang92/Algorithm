package LeetCode;

/**
 * Intersection of Two Linked Lists
 * <p>
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * For example, the following two linked lists:
 * A:        a1 → a2
 * ↘
 * c1 → c2 → c3
 * ↗
 * B:   b1 → b2 → b3
 * begin to intersect at node c1.
 * Notes:
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 * <p>
 * KeyWords: LinkedList
 * Difficulty: Easy
 */
public class LeetCode160_IntersectionofTwoLinkedLists {


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //boundary check
        if (headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        //if a & b have different len, then we will stop the loop after second iteration
        while (a != b) {
            //for the end of first iteration, we just reset the pointer to the head of another linkedlist
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }

        return a;
    }

    public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        int lengthA = 0, lengthB = 0;
        ListNode tempA = headA, tempB = headB;
        while (tempA != null) {
            tempA = tempA.next;
            lengthA++;
        }
        while (tempB != null) {
            tempB = tempB.next;
            lengthB++;
        }
        if (lengthB > lengthA) {
            tempA = headA;
            headA = headB;
            headB = tempA;
            int temp = lengthA;
            lengthA = lengthB;
            lengthB = temp;
        }
        int length = lengthA - lengthB;
        while (length-- > 0)
            headA = headA.next;
        while (headA != null) {
            if (headA == headB)
                return headA;
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

}


