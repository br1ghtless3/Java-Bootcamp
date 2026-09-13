package ru.br1ghtless.ap1_jv_t02.exercise1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            return;
        }

        int n = scanner.nextInt();
        int k = scanner.nextInt();
        String s = scanner.next();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int result = calculateWeight(n, k, s, arr);
        System.out.println(result);
        scanner.close();
    }

    static int calculateWeight(int n, int k, String s, int[] arr) {
        int[][][] line = new int[n][n][k + 1];

        initCase(line, arr, n, k);
        table(line, s, arr, n, k);

        return line[0][n - 1][k];
    }

    static void initCase(int[][][] line, int[] arr, int n, int k) {
        for (int i = 0; i < n; i++) {
            int sing = Math.max(0, arr[i]);
            for (int j = 0; j <= k; j++) {
                line[i][i][j] = sing;
            }
        }
    }

    static void table(int[][][] line, String s, int[] arr, int n, int k) {
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= n - i; j++) {
                int r = j + i - 1;

                boolean sameCh = (s.charAt(j) == s.charAt(r));

                for (int l = 0; l <= k; l++) {
                    line[j][r][l] = transition(line, arr, j, r, i, l, sameCh);

                }
            }
        }
    }

    static int transition(int[][][] line, int[] arr, int j, int r, int i, int l, boolean sameCh) {
        int bb = Math.max(line[j + 1][r][l], line[j][r - 1][l]);

        int summ = arr[j] + arr[r];
        boolean hasIn = i > 2;

        if (sameCh) {
            int inner = hasIn ? line[j + 1][r - 1][l] : 0;

            bb = Math.max(bb, summ + inner);
        } else if (l > 0) {
            int inner = hasIn ? line[j + 1][r - 1][l - 1] : 0;
            bb = Math.max(bb, summ + inner);
        }
        return bb;
    }
}
