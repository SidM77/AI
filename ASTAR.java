package AI;

import java.util.HashMap;
import java.util.Scanner;

public class ASTAR {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] matrix = {
                {0, 3, 0, 0, 4, 0, 0, 0},
                {3, 0, 4, 0, 5, 0, 0, 0},
                {0, 4, 0, 4, 0, 5, 0, 0},
                {0, 0, 4, 0, 0, 0, 0, 0},
                {4, 5, 0, 0, 0, 2, 0, 0},
                {0, 0, 5, 0, 2, 0, 4, 0},
                {0, 0, 0, 0, 0, 4, 0, 3},
                {0, 0, 0, 0, 0, 0, 3, 0}};
        int[] heuristics = {15, 14, 10, 8, 12, 10, 10, 0};
        int predecessor[] = {9, 9, 9, 9, 9, 9, 9, 9};
        int distance_so_far[] = {0, 0, 0, 0, 0, 0, 0, 0};
        HashMap<Integer, Integer> open = new HashMap<>();
        HashMap<Integer, Integer> closed = new HashMap<>();
        System.out.println("Enter start node");
        int start = sc.nextInt();
        System.out.println("Enter goal node");
        int goal = sc.nextInt();
        open.put(start, heuristics[start]);

        while (true) {
            int smallest_key = 9;
            int smallest_value = 9999;
            for (HashMap.Entry<Integer, Integer> entry : open.entrySet()) {
                if (entry.getValue() < smallest_value) {
                    smallest_value = entry.getValue();
                    smallest_key = entry.getKey();
                }
            }
            open.remove(smallest_key);
            if (smallest_key == goal) {
                System.out.println("Found");
                break;
            }
            closed.put(smallest_key, smallest_value);
            int nexts[] = matrix[smallest_key];
            for (int i = 0; i < 8; i++) {

                if (nexts[i] != 0) {
                    int val1 = distance_so_far[smallest_key];
                    val1 += nexts[i] + heuristics[i];
                    if (!open.containsKey(i) && !closed.containsKey(i)) {
                        open.put(i, val1);
                        predecessor[i] = smallest_key;
                        distance_so_far[i] = val1 - heuristics[i];
                    } else if (open.containsKey(i)) {
                        if (val1 < open.get(i)) {
                            open.remove(i);
                            open.put(i, val1);
                            predecessor[i] = smallest_key;
                            distance_so_far[i] = val1 - heuristics[i];
                        }
                    } else if (closed.containsKey(i)) {
                        //do nothing
                    }
                }
            }
        }
        System.out.println();
        int status = goal;
        while (status != start) {
            System.out.print(status + "<-");
            status = predecessor[status];
        }
        System.out.print(start);
    }
}