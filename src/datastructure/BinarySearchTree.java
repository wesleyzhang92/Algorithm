package datastructure;

/**
 * Created by wesley on 2016/10/12.
 */

public class BinarySearchTree {
    public Node root;

    public Node find(int key){
        if(root == null){
            System.out.println("The tree is empty!");
            return null;
        }
        Node current = root;
        while(current.id != key){
            if(key > current.id)
                current = current.rightChild;
            else
                current = current.leftChild;
            if(current == null){
                //System.out.println("Not in the tree!");
                return null;
            }
        }
        return current;
    }

    public boolean insert(Node node){
        if(root == null){
            root = node;
            return true;
        }
        //树中不允许插入重复的数据项
        if(this.find(node.id) != null){
            System.out.println("Node with id '" +
                    node.id + "' has already existed!");
            return false;
        }
        Node current = root;
        while(current != null){
            if(node.id > current.id){
                if(current.rightChild == null){
                    current.rightChild = node;
                    return true;
                }
                current = current.rightChild;
            }else{
                if(current.leftChild == null){
                    current.leftChild = node;
                    return true;
                }
                current = current.leftChild;
            }
        }
        return false;
    }

    //前序遍历
    public void preorder_iterator(Node node){
        System.out.print(node.id + " ");
        if(node.leftChild != null)
            this.preorder_iterator(node.leftChild);
        if(node.rightChild != null)
            this.preorder_iterator(node.rightChild);
    }

    //中序遍历
    //中序遍历二叉搜索树将会得到包含二叉搜索树
    //所有数据项的有序数列
    public void inorder_iterator(Node node){
        if(node.leftChild != null)
            this.inorder_iterator(node.leftChild);
        System.out.print(node.id + " ");
        if(node.rightChild != null)
            this.inorder_iterator(node.rightChild);
    }

    //后序遍历
    public void postorder_iterator(Node node){
        if(node.leftChild != null)
            this.postorder_iterator(node.leftChild);
        if(node.rightChild != null)
            this.postorder_iterator(node.rightChild);
        System.out.print(node.id + " ");
    }

    //获取树（子树）中的最小节点
    public Node getMinNode(Node node){
        if(this.find(node.id) == null){
            System.out.println("Node dosen't exist!");
            return null;
        }
        if(node.leftChild == null)
            return node;
        Node current = node.leftChild;
        while(current.leftChild != null)
            current = current.leftChild;
        return current;
    }

    //获取树（子树）中的最大节点
    public Node getMaxNode(Node node){
        if(this.find(node.id) == null){
            System.out.println("Node dosen't exist!");
            return null;
        }
        if(node.rightChild == null)
            return node;
        Node current = node.rightChild;
        while(current.rightChild != null)
            current = current.rightChild;
        return current;
    }

    //删除节点需要分3种情况进行讨论
    public boolean delete(int key){
        if(root == null){
            System.out.println("The tree is empty!");
            return false;
        }
        Node targetParent = root;
        Node target = root;
        boolean isLeftChild = true;
        while(target.id != key){
            if(key > target.id){
                targetParent = target;
                target = target.rightChild;
                isLeftChild = false;
            }else{
                targetParent = target;
                target = target.leftChild;
                isLeftChild = true;
            }
            if(target == null)
                break;
        }
        if(target == null){
            System.out.println("Node dosen't exist!"
                    + "Can not delete.");
            return false;
        }
        //被删除节点为叶子节点
        if(target.leftChild == null &&
                target.rightChild == null){
            if(target.id == root.id){
                root = null;
                return true;
            }
            if(isLeftChild)
                targetParent.leftChild = null;
            else
                targetParent.rightChild = null;
        }
        //被删除节点有1个子节点
        //被删除节点只有右子节点
        else if(target.leftChild == null &&
                target.rightChild != null){
            if(target.id == root.id){
                root = root.rightChild;
                return true;
            }
            if(isLeftChild)
                targetParent.leftChild = target.rightChild;
            else
                targetParent.rightChild = target.rightChild;
        }
        //被删除节点只有左子节点
        else if(target.leftChild != null &&
                target.rightChild == null){
            if(target.id == root.id){
                root = root.leftChild;
                return true;
            }
            if(isLeftChild)
                targetParent.leftChild = target.leftChild;
            else
                targetParent.rightChild = target.leftChild;
        }
        //被删除节点有左右子节点，先找到后续节点，将，然后将后续节点插入至待删除节点的位置
        else{
            Node followingNode = this.getFollowingNode(target);
            if(target.id == root.id)
                root = followingNode;
            else if(isLeftChild)
                targetParent.leftChild = followingNode;
            else
                targetParent.rightChild = followingNode;
            followingNode.leftChild = target.leftChild;
            followingNode.rightChild = target.rightChild;
        }
        return true;
    }

    //获取被删除节点的后续节点
    private Node getFollowingNode(Node node2Del){
        Node nodeParent = node2Del;
        //只有被删除节点有左右子节点时，才会调用该方法
        //这里直接调用rightChild是没有问题的
        Node node = node2Del.rightChild;
        while(node.leftChild != null){
            nodeParent = node;
            node = node.leftChild;
        }
        if(node.id != node2Del.rightChild.id)
            nodeParent.leftChild = node.rightChild;
        else
            nodeParent.rightChild = node.rightChild;
        return node;
    }

    public static void main(String[] args) {
        //插入
        BinarySearchTree bst = new BinarySearchTree();
        Node n1 = new Node(20, "root");
        Node n2 = new Node(10, "left");
        Node n3 = new Node(30, "right");
        bst.insert(n1);
        bst.insert(n2);
        bst.insert(n3);
        bst.find(80);
        //遍历
        bst.preorder_iterator(bst.root);
        System.out.println();
        bst.inorder_iterator(bst.root);
        System.out.println();
        bst.postorder_iterator(bst.root);
        System.out.println();
        //删除
        Node n4 = new Node(5, "");
        Node n5 = new Node(15, "");
        Node n6 = new Node(40, "");
        Node n7 = new Node(35, "");
        Node n8 = new Node(45, "");
        bst.insert(n4);
        bst.insert(n5);
        bst.insert(n6);
        bst.insert(n7);
        bst.insert(n8);

        bst.inorder_iterator(bst.root);
        System.out.println();
        bst.delete(20);
        bst.inorder_iterator(bst.root);
        System.out.println();
    }
}
