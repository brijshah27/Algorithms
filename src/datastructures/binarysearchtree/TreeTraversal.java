package datastructures.binarysearchtree;
class Node
{
    int key;
    Node left, right;

    public Node(int item)
    {
        key = item;
        left = right = null;
    }
}
public class TreeTraversal {
    Node root;

    TreeTraversal()
    {
        root = null;
    }
    void inOrder(Node node) {
        if (node == null)
            return;

        /* first recur on left child */
        inOrder(node.left);

        /* then print the data of node */
        System.out.print(node.key + " ");

        /* now recur on right child */
        inOrder(node.right);
    }

    /* Given a binary tree, print its nodes in preorder*/
    void preorder(Node node)
    {
        if (node == null)
            return;

        /* first print data of node */
        System.out.print(node.key + " ");

        /* then recur on left sutree */
        preorder(node.left);

        /* now recur on right subtree */
        preorder(node.right);
    }

    /* Given a binary tree, print its nodes in postorder*/
    void postorder(Node node)
    {
        if (node == null)
            return;

        /* now recur on right subtree */
        postorder(node.right);

        /* then recur on left sutree */
        postorder(node.left);

        /* first print data of node */
        System.out.print(node.key + " ");
    }

    // Wrappers over above recursive functions
    void printPostorder()  {     postorder(root);  }
    void printInorder()    {     inOrder(root);   }
    void printPreorder()   {     preorder(root);  }

    public static void main(String[] args)
    {
        TreeTraversal tree = new TreeTraversal();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("Preorder traversal of binary tree is ");
        tree.printPreorder();

        System.out.println("\nInorder traversal of binary tree is ");
        tree.printInorder();

        System.out.println("\nPostorder traversal of binary tree is ");
        tree.printPostorder();
    }
}
