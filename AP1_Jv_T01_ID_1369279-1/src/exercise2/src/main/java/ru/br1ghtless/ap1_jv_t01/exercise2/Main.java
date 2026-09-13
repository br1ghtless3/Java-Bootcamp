package ru.br1ghtless.ap1_jv_t01.exercise2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static int hours;
    static int minutes;
    static int seconds;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sec = readSec(scanner);

        if (sec < 0) System.out.println("Incorrect time");
        else {
            calculations(sec);
            printTime(hours, minutes, seconds);
        }
        scanner.close();
    }

    static int readSec(Scanner scanner) {
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

    static void calculations(int sec) {
        hours = sec / 3600;
        seconds = sec % 3600;
        minutes = seconds / 60;
        seconds %= 60;
    }

    static void printTime(int h, int m, int s) {
        System.out.printf("%02d:%02d:%02d\n", h, m, s);
    }
}
