package ru.br1ghtless.ap1_jv_t01.exercise6;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);
        int number = readInt(scanner);

        if (number <= 0) System.out.println("Input error. Size <= 0");
        else {
            double[] arr = new double[number];

            for (int i = 0; i < number; i++) {
                arr[i] = readDouble(scanner);
            }

            selectionSort(arr);

            for (int i = 0; i < number; i++) {
                System.out.print(arr[i]);
                if (i < number - 1) System.out.print(" ");
            }
            System.out.print("\n");
        }
        scanner.close();
    }

    static int readInt(Scanner scanner) {
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

    static double readDouble(Scanner scanner) {
        while (true) {
            try {
                double num = scanner.nextDouble();
                return num;
            } catch (InputMismatchException e) {
                System.out.println("Could not parse a number. Please, try again");
                scanner.next();
            }
        }
    }

    static void selectionSort(double[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIdx = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIdx]) minIdx = j;
            }

            double temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }
}
