package datastructure;

/**
 * Created by wesley on 2016/10/11.
 */
public class LinkedList{
    public Node first;
    private int pos=0;
    public LinkedList(){
        this.first=null;
    }

    public void addFirst(int data){
        Node node = new Node(data);
        node.next=first;
        first=node;
    }

    public Node search(int data){
        Node x = first;
        while(x!=null&&x.next!=null){
            if(x.next.data==data)
                return x;
            x=x.next;
        }
        return null;
    }

    public void delete(int data){
        Node x = this.search(data);
        x.next=x.next.next;
    }

    public static void main(String[] args){
        LinkedList ls = new LinkedList();
        ls.addFirst(10);
        ls.addFirst(20);
        ls.addFirst(30);
        Node x = ls.search(20);
        System.out.println(x.next.data);
        ls.delete(20);
        x=ls.search(20);
        System.out.println(x);
    }

}
