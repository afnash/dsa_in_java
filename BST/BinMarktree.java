package BST;
import java.util.*;
class Node{
    int data;
    Node lchild;
    Node rchild;
    String name;
    int mark1,mark2,mark3;
    int total;
    public Node(int d,String name,int mark1,int mark2,int mark3,int total){
        data=d;
        this.name= name;
        this.mark1=mark1;
        this.mark2=mark2;
        this.mark3=mark3;
        this.total=total;
        lchild=rchild=null;
    }
    public void displaynode(){
        System.out.println("Data: " + data + ", Name: " + name + ", Marks: [" + mark1 + ", " + mark2 + ", " + mark3 + "], Total: " + total);
    }
}
class tree {
    Node root;
    public tree(){
        root=null;
    }
    public void insert(int key, String name, int mark1,int mark2,int mark3,int total){
        Node newNode= new Node(key,name,mark1,mark2,mark3,total);
        if(root==null){
            root=newNode;
        }else{
            Node cur= root;
            Node parent;
            while(true){
                parent=cur;
                if(key<=cur.data){
                    cur=cur.lchild;
                    if(cur==null){
                        parent.lchild=newNode;
                        break;
                    }
                }
            }
        }
    }
    public void inorder(){
        System.out.println("Inorder traversal");
        inorder(root);
    }
    private void inorder(Node root){
        if(root!=null){
            inorder(root.lchild);
            root.displaynode();
            inorder(root.rchild);
        }
    }
    public Node topper(){
        if(root==null){
            System.out.println("Tree is empty");
            return null;
        }
        return topper(root,root); 
    }
    private Node topper(Node root, Node maxNode){
        if(root!=null){
            if(root.total>maxNode.total){
                maxNode=root;
            }
            maxNode = topper(root.lchild, maxNode);
            maxNode = topper(root.rchild, maxNode);
        }
        return maxNode;
    }
}
class BinMarktree{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        tree t = new tree();
        while(true){
            System.out.println("Enter your choice: ");
            System.out.println("1. insert\n 2. Inorder traversal\n3. topper\n 4.exit");
            int value= sc.nextInt();
            sc.nextLine();
            switch (value) {
                case 1:
                    System.out.println("enter reg no.");
                    int regNo= sc.nextInt();
                    sc.nextLine();
                    System.out.println("enter your name");
                    String name= sc.nextLine();
                    System.out.println("enter your marks");
                    int mark1= sc.nextInt();
                    int mark2= sc.nextInt();
                    int mark3= sc.nextInt();
                    int total= mark1+mark2+mark3;
                    t.insert(regNo, name, mark1, mark2, mark3, total);
                    break;
                case 2:
                    t.inorder();
                    break;
                case 3:
                    Node topperNode=t.topper();
                    if(topperNode!=null){
                        System.out.println("topper: ");
                        topperNode.displaynode();
                    }
                    break;
                case 4:
                System.out.println("exiting....");
                sc.close();
                break;
            
                default:
                System.out.println("invalid choice");
                    break;
            }
        }
        //sc.close();

    }
}
