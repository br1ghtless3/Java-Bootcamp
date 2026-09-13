package ru.br1ghtless.ap1_jv_t01.exercise9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();

        List<String> strok = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            strok.add(scanner.nextLine());
        }

        String filter = scanner.nextLine();

        List<String> result = filterString(filter, strok);

        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i));
            if (i < result.size() - 1) System.out.print(", ");
            else System.out.print("\n");
        }
    }

    static List<String> filterString(String filter, List<String> strok) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < strok.size(); i++) {
            if (strok.get(i).contains(filter)) result.add(strok.get(i));
        }
        return result;
    }
}
