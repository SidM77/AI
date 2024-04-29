package AI;

import java.util.Scanner;
import java.util.Stack;

public class DFID {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter root node");
//        int value = sc.nextInt();
        Node root = new Node(9, false);
        Node node8 = new Node(8, false);
        Node node6 = new Node(6, false);
        Node node7 = new Node(7, false);
        Node node5 = new Node(5, false);
        Node node3 = new Node(3, false);
        Node node4 = new Node(4, false);

        // Set up tree
        root.left = node8;
        root.right = node6;
        node8.left = node7;
        node8.right = node5;
        node6.left = node3;
        node6.right = node4;


        System.out.println("Enter value to search");
        int goal = sc.nextInt();
        int i = 0;
        while (true) {
            System.out.println("\nRunning at max_depth = " + i);
            boolean answer = DLS.startDLS(root, goal, i, 0);
            if (answer)
                break;
            i++;
        }

    }
}
