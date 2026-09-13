package ru.br1ghtless.ap1_jv_t01.exercise4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = read(scanner);

        if (number <= 0) System.out.println("Input error. Size <= 0");
        else {
            int[] arr = new int[number];

            for (int i = 0; i < number; i++) {
                int n = read(scanner);
                arr[i] = n;
            }

            int ctn = 0, sum = 0;
            for (int i = 0; i < number; i++) {
                if (arr[i] < 0) {
                    ctn += 1;
                    sum += arr[i];
                }
            }

            if (ctn == 0) System.out.println("There are no negative elements");
            else System.out.println(sum / ctn);
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
}
