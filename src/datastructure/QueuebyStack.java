package datastructure;

import java.util.Stack;

/**
 * Created by wesley on 2016/10/11.
 */
public class QueuebyStack {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public static void main(String[] args) {
        QueuebyStack qs = new QueuebyStack();
        qs.enqueue(10);
        qs.enqueue(20);
        qs.enqueue(30);
        int de = qs.dequeue();
        System.out.println(qs.isEmpty());
    }

    public void enqueue(int val) {
        stack1.push(val);
    }

    public int dequeue() {
        while (!stack1.isEmpty()) {
            int tmp = stack1.pop();
            stack2.push(tmp);
        }
        int res = stack2.pop();
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return res;
    }

    public boolean isEmpty() {
        return stack1.isEmpty();
    }
}
