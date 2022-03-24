package tree;

import java.util.Stack;

public class BinaryTree {
    
    private TreeNode root;

    private class TreeNode{
        private TreeNode left;
        private TreeNode right;
        private int data; //generic type

        public TreeNode(int data){
            this.data=data;
        }
    }

    //create binary tree
    public void createBinaryTree(){
        TreeNode first=new TreeNode(1);
        TreeNode second=new TreeNode(2);
        TreeNode third=new TreeNode(3);
        TreeNode fourth=new TreeNode(4);
        TreeNode fifth=new TreeNode(5);

        root=first; //root ---> first
        first.left=second;
        first.right=third; // second <--- first ----> third

        second.left=fourth;
        second.right=fifth;
    }

    //recursive preOrder traversal
    public void preOrder(TreeNode root){
        if(root==null){//base case
            return;
        }
        System.out.print(root.data+ " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    //recursive postOrder traversal
    public void postOrder(TreeNode root){
        if(root==null){//base case
            return;
        }
        System.out.print(root.data+ " ");
        postOrder(root.right);
        postOrder(root.left);
    }

    //recursive inOrder traversal
    public void inOrder(TreeNode root){
        if(root==null){//base case
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+ " ");
        inOrder(root.right);
    }

    //iterative preOrder traversal
    public void iterativePreOrder(TreeNode root){
        if(root==null){
            return;
        }
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode temp=stack.pop();
            System.out.print(temp.data+" ");
            if(temp.right!=null){
                stack.push(temp.right);
            }
            if(temp.left!=null){
                stack.push(temp.left);
            }
        }
    }
    //iterative postOrder traversal
    public void iterativePostOrder(TreeNode root){
        if(root==null){
            return;
        }
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode temp=stack.pop();
            System.out.print(temp.data+" ");
            if(temp.left!=null){
                stack.push(temp.left);
            }
            if(temp.right!=null){
                stack.push(temp.right);
            }
        }
    }
    //iterative inOrder traversal
    public void iterativeInOrder(TreeNode root){
        if(root==null){
            return;
        }
        Stack<TreeNode> stack=new Stack<>();
        TreeNode temp=root;
        while(!stack.isEmpty() || temp!=null){
            if(temp!=null){
                stack.push(temp);
                temp=temp.left;
            }else{
                temp=stack.pop();
                System.out.print(temp.data+ " ");
                temp=temp.right;
            }
        }
    }

    public static void main(String[] args) {
        BinaryTree binaryTree=new BinaryTree();
        binaryTree.createBinaryTree();
        System.out.println("Recursive Pre-Order");
        binaryTree.preOrder(binaryTree.root);
        System.out.println("\nRecursive Post-Order");
        binaryTree.postOrder(binaryTree.root);
        //iterative preOrder
        System.out.println("\nIterative Pre-Order");
        binaryTree.iterativePreOrder(binaryTree.root);
    }
}
