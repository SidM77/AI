package AI;

import java.util.Scanner;

class Node {
    int value;
    Node left;
    Node right;

    Node(int value) {
        Scanner sc = new Scanner(System.in);
        this.value = value;
        System.out.println("Enter value to left of " + this.value + " enter -1 if null");
        value = sc.nextInt();
        if (value != -1)
            left = new Node(value);
        System.out.println("Enter value to right of " + this.value + " enter -1 if null");
        value = sc.nextInt();
        if (value != -1)
            right = new Node(value);
    }

    Node(int value, boolean dummy) {
        this.value = value;
    }

}
