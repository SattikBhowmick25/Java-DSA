import java.util.Scanner;
import java.util.Stack;

class BinaryTree{
    private static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val=val;
            this.left=null;
            this.right=null;
        }
    }
    private Node root;
    public void populate(Scanner scanner){
        System.out.println("Enter the value of the node:");
        int val=scanner.nextInt();
        root=new Node(val);
        populate(scanner,root);
    }
    private void populate(Scanner scanner,Node node){
        System.out.println("Do you want to insert left child of the node-"+node.val+": ");
        boolean left=scanner.nextBoolean();
        if(left){
            System.out.println("Enter the value of the left child: ");
            int val=scanner.nextInt();
            node.left=new Node(val);
            populate(scanner,node.left);
        }
        System.out.println("Do you want to insert right child of the node-"+node.val+": ");
        boolean right=scanner.nextBoolean();
        if(right){
            System.out.println("Enter the value of the right child: ");
            int val=scanner.nextInt();
            node.right=new Node(val);
            populate(scanner,node.right);
        }
    }
    public void preorder(){
        Stack<Node> st=new Stack<>();
        if(root==null){
            System.out.println("Binary tree is empty");
            return;
        }
        System.out.print("Preorder:");
        st.push(root);
        while(!st.empty()){
            Node node=st.pop();
            System.out.print(node.val+" ");
            if(node.left!=null){
                st.push(node.left);
            }
            if(node.right!=null){
                st.push(node.right);
            }
        }
        System.out.println();
    }
}
public class TreeImplementation {
    public static void main(String[] args) {
        BinaryTree tree=new BinaryTree();
        Scanner sc=new Scanner(System.in);
        tree.populate(sc);
        tree.preorder();
    }
}
