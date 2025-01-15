package BSTkth;
import java.util.*;
class Node {
    int data;
    Node lchild,rchild;
    public Node(int d){
        data=d;
        lchild=rchild=null;
    }
}
class BST{
    Node root;
    public BST(){
        root=null;
    }
    public void insert(int key){
        Node newNode= new Node(key);
        if(root==null){
            root=newNode;
            return;
        }else{
            Node cur=root;
            Node parent=null;
            while(true){
                parent=cur;
                if(key<cur.data){
                    cur=cur.lchild;
                    if(cur==null){
                        parent.lchild=newNode;
                        return;
                    }
                }else{
                    cur=cur.rchild;
                    if(cur==null){
                        parent.rchild=newNode;
                        return;
                    }
                }
            }
        }
    }
    public void findKthSmallest(int k){
        int[] count={0};
        Node result =findKthSmallest(root,k,count);
        if(result!=null){
            System.out.println(result.data);
        }else{
            System.out.println("no element");
        }    
    }
    private Node findKthSmallest(Node root,int k,int[] count){
        if (root==null) return null;
        Node left= findKthSmallest(root.lchild, k, count);
        if(left!=null) return left;
        count[0]++;
        if(count[0]==k) return root;
        return findKthSmallest(root.rchild, k, count);
    }
    public void leafCount(){
        int count=leafCount(root);
        System.out.println(count);
    }
    private int leafCount(Node root){
        if(root==null) return 0;
        if(root.lchild==null && root.rchild==null) return 1;
        return leafCount(root.lchild)+leafCount(root.rchild);}
}
class kthValue{
public static void main(String[] args) {
    Scanner sc= new Scanner(System.in);
    BST bst=new BST();
    boolean running = true;
    while(running){
        System.out.println("Menu:");
        System.out.println("1.insert \n2.find kth smallest \n3.count leaves \n4.exit");
        int choice= sc.nextInt();
        switch(choice){
            case 1:
            System.out.println("enter value");
            int  val=sc.nextInt();
            bst.insert(val);
            break;
            case 2:
            System.out.println("enter value to k:");
            int k= sc.nextInt();
            bst.findKthSmallest(k);
            break;
            case 3:
            bst.leafCount();
            break;
            case 4:
            System.out.println("exitting...");
            running =false;
            break;
            default:
            System.out.println("invalid.");
        }
    }
sc.close();
}
}
