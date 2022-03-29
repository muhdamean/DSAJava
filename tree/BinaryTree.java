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
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+ " "); 
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
        TreeNode current=root;
        Stack<TreeNode> stack=new Stack<>();
        while(current!=null || !stack.isEmpty()){
            if(current!=null){
                stack.push(current);
                current=current.left; //traverse the left node
            }else{
                //traverse the right node if left is null
                TreeNode temp=stack.peek().right; 

                if(temp==null){//check right node is null
                    temp=stack.pop(); //pop the parent node from stack
                    System.out.print(temp.data+ " "); //print the parent node

                    //check if the temp is the right node of the current prent in stack
                    while(!stack.isEmpty() && temp==stack.peek().right){ 
                        temp=stack.pop();
                        System.out.print(temp.data+ " ");
                    }
                }else{
                    current=temp;
                }
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
        binaryTree.createBinaryTree(); //create binary tree

        System.out.println("Recursive PreOrder");
        binaryTree.preOrder(binaryTree.root);
        System.out.println("\nRecursive PostOrder");
        binaryTree.postOrder(binaryTree.root);
        System.out.println("\nRecursive InOrder");
        binaryTree.inOrder(binaryTree.root);
        System.out.println();
        //iterative preOrder
        System.out.println("\nIterative PreOrder");
        binaryTree.iterativePreOrder(binaryTree.root);
        //iterative postOrder
        System.out.println("\nIterative PostOrder");
        binaryTree.iterativePostOrder(binaryTree.root);
        //iterative postOrder
        System.out.println("\nIterative InOrder");
        binaryTree.iterativeInOrder(binaryTree.root);
    }
}
