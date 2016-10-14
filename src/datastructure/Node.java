package datastructure;

/**
 * Created by wesley on 2016/10/12.
 */
public class Node {
    public int id;
    public String name;
    public Node leftChild;
    public Node rightChild;

    public Node(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int data;
    public Node next;
    public Node(){
    }
    public Node(int data){
        this.data=data;
    }
    public void display(){
        System.out.print(data+"");
    }
}
