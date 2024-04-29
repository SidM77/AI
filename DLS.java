package AI;

import java.util.Scanner;
import java.util.Stack;

public class DLS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter root node");
        int value = sc.nextInt();
        Node root = null;
        if (value != -1) {
            root = new Node(value);
        }
        System.out.println("Enter the GOAL node");
        int goal = sc.nextInt();

        System.out.println("Enter the maximum depth you want to search into");
        int max_depth = sc.nextInt();
        boolean answer = startDLS(root, goal, max_depth, 0);
        if (!answer)
            System.out.println("Node not found");
    }


    static boolean startDLS(Node node, int goal, int max_depth, int current_depth) {
        if (current_depth > max_depth)
            return false;
        System.out.println("Currently traversing Node -> " + node.value);
        if (node.value == goal) {
            System.out.println("Node has been found!");
            return true;
        }
        if (node.left != null) {
            if (startDLS(node.left, goal, max_depth, current_depth + 1))
                return true;
        }
        if (node.right != null) {
            if (startDLS(node.right, goal, max_depth, current_depth + 1))
                return true;
        }
        return false;
    }


}
