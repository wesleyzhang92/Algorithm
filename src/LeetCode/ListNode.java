package LeetCode;

import java.util.ArrayList;

/**
 * Created by wesley on 2016/12/18.
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
    static ListNode first =null;
    public ListNode append(ArrayList<Integer> a){
        for(int i : a){
            ListNode tmp = new ListNode(i);
            tmp.next=first;
            first=tmp;
        }
        return first;
    }
    @Override
    public String toString() {
        String ret="";
        ListNode ts=first;
        while(ts.next!=null){
            ret+=ts.val+" ";
            ts=ts.next;
        }
        return ret+ts.val;
    }

}