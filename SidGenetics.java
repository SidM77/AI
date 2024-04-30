package AI;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class SidGenetics {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //init chromosomes
        int chromosomes[][] = new int[6][4];
        System.out.println("Chromosomes Initially");
        initChromosomes(chromosomes);
        printAllChromosomes(chromosomes);

        int fitness = -1;
        int i = 0;

        while (true) {
//            System.out.println(i);

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
            if (fitness == 0)
                break;

            //Now Do Cross-overs
//            int j = new Random().nextInt(0, 5);
            for (int j = 0; j < chromosomes.length; j += 2) {
                doCrossover(j, chromosomes);
            }
            i++;
//            printAllChromosomes(chromosomes);
        }
    }

    static void doCrossover(int target, int[][] chromosomes) {
        Random random = new Random();
        int randomTarget2;
        do {
            randomTarget2 = random.nextInt(0, 6);
        } while (randomTarget2 == target);
        int split = random.nextInt(1, 4);
//        System.out.println("Crossing " + (target + 1) + " and " + (randomTarget2 + 1) + " at split " + split);
        int split_arr1[] = Arrays.copyOfRange(chromosomes[target], 0, split);
//        System.out.println(Arrays.toString(split_arr1));
        int split_arr2[] = Arrays.copyOfRange(chromosomes[randomTarget2], split, 4);
//        System.out.println(Arrays.toString(split_arr2));
        int neue_array1[] = new int[4];
        int pos = 0;
        for (int i : split_arr1) {
            neue_array1[pos] = i;
            pos++;
        }
        for (int i : split_arr2) {
            neue_array1[pos] = i;
            pos++;
        }
//        System.out.println("NeueArray = " + Arrays.toString(neue_array));

        int split_arr3[] = Arrays.copyOfRange(chromosomes[randomTarget2], 0, split);
        int split_arr4[] = Arrays.copyOfRange(chromosomes[target], split, 4);
        int neue_array2[] = new int[4];
        pos = 0;
        for (int i : split_arr3) {
            neue_array2[pos] = i;
            pos++;
        }
        for (int i : split_arr4) {
            neue_array2[pos] = i;
            pos++;
        }
//        System.out.println("NeueArray = " + Arrays.toString(neue_array));
        chromosomes[randomTarget2] = neue_array2;
        chromosomes[target] = neue_array1;
//        return chromosomes[target];
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
                int val = random.nextInt(0, 6);
                arr[i] = val;
            }
        }
    }

    static int calculateFitness(int c[]) {
        int eqn = 1 * c[0] + 2 * c[1] + 3 * c[2] + 4 * c[3] - 30;
        return eqn;
    }


}


