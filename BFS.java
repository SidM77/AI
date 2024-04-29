package AI;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter root node");
//        System.out.println("Enter the left of this node");
        int value = sc.nextInt();
        Node root = new Node(value);
        // BFS TRAVERSAL
        System.out.print("Traversal is -> ");
        System.out.print(root.value + ", ");
        BFSTraversal(root);
        //BFS ACTUAL SEARCH PART
        System.out.println();
        Queue<Node> order = new LinkedList<>();
        System.out.println("Enter GOAL Node");
        int goal = sc.nextInt();
        order.add(root);
        boolean found = startBFS(order, goal);
        if (!found)
            System.out.println("Node Not found");

    }


    static void BFSTraversal(Node root) {
        if (root.left != null)
            System.out.print(root.left.value + ", ");
        if (root.right != null)
            System.out.print(root.right.value + ", ");
        if (root.left != null)
            BFSTraversal(root.left);
        if (root.right != null)
            BFSTraversal(root.right);
    }

    static boolean startBFS(Queue<Node> queue, int goal) {
        if (!queue.isEmpty()) {
            Node current = queue.remove();
            System.out.println("Currently traversing Node -> " + current.value);
            if (current.value == goal) {
                System.out.println("Node has been found!");
                return true;
            }
            if (current.left != null)
                queue.add(current.left);
            if (current.right != null)
                queue.add(current.right);
            return (startBFS(queue, goal));
        }
        return false;
    }
}

