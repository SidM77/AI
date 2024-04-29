package AI;

import java.util.Scanner;
import java.util.Stack;

public class DFS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter root node");
        int value = sc.nextInt();
        Node root = new Node(value);

        System.out.println("Enter value to search");
        int goal = sc.nextInt();
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        boolean answer = startDFS(stack, goal);
    }

    static boolean startDFS(Stack<Node> stack, int goal) {
        if (!stack.isEmpty()) {
            Node current = stack.pop();
            System.out.println("Currently traversing Node -> " + current.value);
            if (current.value == goal) {
                System.out.println("Node has been found!");
                return true;
            }
            if (current.right != null)
                stack.push(current.right);
            if (current.left != null)
                stack.push(current.left);
            return startDFS(stack, goal);
        }
        return false;
    }
}
