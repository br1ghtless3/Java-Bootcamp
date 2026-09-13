package ru.br1ghtless.ap1_jv_t01.exercise8;

import java.util.Scanner;

// 1 3 5 6 d 2  - что выводит в этом случае????

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) System.out.println("Input error");
        else {
            int previos = scanner.nextInt();
            int ctn = 1;
            while (scanner.hasNextInt()) {
                int current = scanner.nextInt();
                if (current <= previos) {
                    System.out.println(
                            "The sequence is not ordered from the ordinal number of the number " + ctn);
                    return;
                } else {
                    ctn++;
                    previos = current;
                }
            }
            System.out.println("The sequence is ordered in ascending order");
        }
    }
}
