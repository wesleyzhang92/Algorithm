package datastructure;

/**
 * Created by wesley on 2016/10/11.
 */

import java.util.LinkedList;
import java.util.Queue;

public class StackbyQueue {
    Queue<Integer> queue1= new LinkedList<Integer>();
    Queue<Integer> queue2= new LinkedList<Integer>();
    public void push(int val){
        queue1.add(val);
    }
    public int pop(){
        while(!queue1.isEmpty()){
            queue2.add(queue1.poll());
        }
        int res = queue2.poll();
        while(!queue2.isEmpty()){
            queue1.add(queue2.poll());
        }
        return res;
    }
    public boolean isEmpty(){
        return queue1.isEmpty();
    }
    public static void main(String[] args){
        StackbyQueue sq = new StackbyQueue();
        sq.push(10);
        sq.push(20);
        sq.push(30);
        int res = sq.pop();
        System.out.println(res);
        System.out.println(sq.isEmpty());
    }
}
