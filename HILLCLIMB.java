package AI;

import java.util.Random;

public class HILLCLIMB {
    static double objFunction(double x) {
        return -2 * x * x + 17 * x + 90;
    }

    static double randomNeighbor(double current) {
        Random random = new Random();
        return current + random.nextDouble() * 1.0 - 0.5;
    }

    static double hillClimbing(int maxIterations) {
        Random random = new Random();
        double currentSolution = random.nextDouble() * 20 - 10;
        System.out.println("Initial soln " + currentSolution);
        for (int i = 0; i < maxIterations; i++) {

            double neighbor = randomNeighbor(currentSolution);
            System.out.println("Itn " + i + " Neighbour " + neighbor);
            if (objFunction(neighbor) > objFunction(currentSolution)) {
                currentSolution = neighbor;
            }
        }

        return currentSolution;
    }

    public static void main(String[] args) {
        int maxIterations = 1000;
        double bestSolution = hillClimbing(maxIterations);
        System.out.println("Best solution found: " + bestSolution);
        System.out.println("Objective value at best solution: " + objFunction(bestSolution));
    }
}
