package LeetCode;

/**
 * Linked List Cycle
 *
 * Given a linked list, determine if it has a cycle in it.
 * Follow up:
 * Can you solve it without using extra space?
 *
 * KeyWords: LinkedList, Two Pointers
 * Difficulty: Easy
 */
public class LeetCode141 {

    //Use two pointers, walker and runner.
    //walker moves step by step. runner moves two steps at time.
    //if the Linked List has a cycle walker and runner will meet at some point.
    //考虑两个指针first, second在linked list上遍历，一个跑得快，一个跑得慢。如果linked list成环，那么慢指针终将被快指针追上。
    public boolean hasCycle(ListNode head) {
        ListNode first = head;
        while(head!=null&&first!=null&&first.next!=null){
            head=head.next;
            first=first.next.next;
            if(head==first)
                return true;

        }
        return false;
    }
}
