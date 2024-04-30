package AI;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SidMutation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //init chromosomes
        int chromosomes[][] = new int[6][4];
        initChromosomes(chromosomes);

        printAllChromosomes(chromosomes);

        int fitness = -1;
        int i = 0;

        for (i = 0; i < 1000; i++) {


            for (int x = 0; x < chromosomes.length; x++) {
                int arr[] = chromosomes[x];
                fitness = calculateFitness(arr);
                if (fitness == 0) {
                    System.out.println("Best Chromosome found after " + i + " generations.");
                    System.out.println("Best Chromosone is " + Arrays.toString(arr));
                    printAllChromosomes(chromosomes);
                    break;
                }
            }
        }

        if (fitness == 0) {

        }
    }

    static void printAllChromosomes(int[][] chromosomes) {
        for (int i = 0; i < chromosomes.length; i++) {
            System.out.print("Chromosome " + (i + 1) + " : ");
            int arr[] = chromosomes[i];
            System.out.println(Arrays.toString(arr));
        }
    }

    static void initChromosomes(int chromosomes[][]) {
        Random random = new Random();
        for (int arr[] : chromosomes) {
            for (int i = 0; i < arr.length; i++) {
                int val = random.nextInt(0, 5);
                arr[i] = val;
            }
        }
    }

    static int calculateFitness(int c[]) {
        int eqn = 1 * c[0] + 2 * c[1] + 3 * c[2] + 4 * c[3] - 30;
        return eqn;
    }
}
