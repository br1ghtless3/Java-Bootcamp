package ru.br1ghtless.ap1_jv_t01.exercise6;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = read(scanner);

        if (number <= 0) System.out.println("Input error. Size <= 0");
        else {
            int[] arr = new int[number];
            int[] result = new int[number];
            int ctn = 0;
            int i = 0;

            while (i < number) {
                int n = read(scanner);
                arr[i] = n;
                if (findNumber(n)) {
                    result[ctn] = n;
                    ctn += 1;
                }
                i++;
            }

            //            for (int i = 0; i < number; i++) {
            //              int n = read(scanner);
            //              arr[i] = n;
            //              if (findNumber(n)) {
            //                result[ctn] = n;
            //                ctn += 1;
            //              }
            //            }

            if (ctn == 0) {
                System.out.println("There are no such elements");
            } else {
                int j = 0;
                while (j < ctn) {
                    System.out.print(result[j]);
                    if (j < ctn - 1) System.out.print(" ");
                    j++;
                }
                //        for (int i = 0; i < ctn; i++) {
                //          System.out.print(result[i]);
                //          if (i < ctn - 1) System.out.print(" ");
                //        }
                System.out.print("\n");
            }
        }
        scanner.close();
    }

    static int read(Scanner scanner) {
        while (true) {
            try {
                int num = scanner.nextInt();
                return num;
            } catch (InputMismatchException e) {
                System.out.println("Could not parse a number. Please, try again");
                scanner.next();
            }
        }
    }

    static boolean findNumber(int n) {
        if (n <= 0) n = (-1) * n;
        int a = n % 10;
        int b = n;
        while (b >= 10) {
            b /= 10;
        }
        return a == b;
    }
}
