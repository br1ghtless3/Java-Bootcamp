package ru.br1ghtless.ap1_jv_t01.exercise1;

import java.lang.Math;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    static double readCorrectData(Scanner scanner) {
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


    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);
        var x1 = readCorrectData(scanner);
        var y1 = readCorrectData(scanner);
        var x2 = readCorrectData(scanner);
        var y2 = readCorrectData(scanner);
        var x3 = readCorrectData(scanner);
        var y3 = readCorrectData(scanner);

        var a = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
        var b = Math.sqrt(Math.pow((x3 - x2), 2) + Math.pow((y3 - y2), 2));
        var c = Math.sqrt(Math.pow((x3 - x1), 2) + Math.pow((y3 - y1), 2));

        if (a + b > c && a + c > b && b + c > a) {
            double perimeter = a + b + c;
            System.out.printf(Locale.US, "Perimeter: %.3f\n", perimeter);
        } else {
            System.out.println("It's not a triangle");
        }

        scanner.close();
    }
}

