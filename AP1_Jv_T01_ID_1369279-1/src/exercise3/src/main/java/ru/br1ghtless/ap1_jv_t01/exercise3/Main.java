package ru.br1ghtless.ap1_jv_t01.exercise3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = read(scanner);
        prin(number);
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

    static int fibonachi(int n) {
        if (n <= 0) return 0;
        else if (n == 1) return 1;
        else return fibonachi(n - 1) + fibonachi(n - 2);
    }

    static void prin(int num) {
        try {
            int result = fibonachi(num);
            System.out.println(result);
        } catch (StackOverflowError e) {
            System.out.println("Too large n");
        }
    }
}
