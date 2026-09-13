package ru.br1ghtless.ap1_jv_t01.exercise7;

import java.io.*;
import java.util.Locale;
import java.util.Scanner;

// src/exercise7/src/main/java/ru/br1ghtless/ap1_jv_t01/exercise7/file1.txt
// src/exercise7/src/main/java/ru/br1ghtless/ap1_jv_t01/exercise7/file2.txt
// src/exercise7/src/main/java/ru/br1ghtless/ap1_jv_t01/exercise7/file3.txt
// src/exercise7/src/main/java/ru/br1ghtless/ap1_jv_t01/exercise7/file4.txt

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    scanner.useLocale(Locale.US);
    String path = scanner.nextLine();
    File file = new File(path);

    if (file.exists()) {
      try (Scanner scannerFile = new Scanner(file)) {
          scannerFile.useLocale(Locale.US);
        if (!scannerFile.hasNextInt()) {
          System.out.println("Input error. Insufficient number of elements");
          return;
        }

        int n = scannerFile.nextInt();

        if (n <= 0) System.out.println("Input error. Size <= 0");
        else {
          double[] arr = new double[n];
          int ctn = 0;
          while (ctn < n && scannerFile.hasNext()) {
            if (scannerFile.hasNextDouble()) {
              arr[ctn] = scannerFile.nextDouble();
              ctn++;
            } else {
              scannerFile.next();
            }
          }

          if (ctn < n) System.out.println("Input error. Insufficient number of elements");
          else {
            System.out.println(n);
            for (int i = 0; i < ctn; i++) {
              System.out.print(arr[i]);
              if (i < ctn - 1) System.out.print(" ");
            }
            System.out.print("\n");

            double min = arr[0], max = arr[0];
            for (int i = 0; i < n; i++) {
              if (arr[i] < min) min = arr[i];
              if (arr[i] > max) max = arr[i];
            }

            try (PrintWriter writer = new PrintWriter("src/exercise7/src/main/java/ru/br1ghtless/ap1_jv_t01/exercise7/result.txt")) {
              writer.println(min + " " + max);
            }
            System.out.println("Saving min and max values in file");
          }
        }
      } catch (FileNotFoundException e) {
        System.out.println("Input error. File doesn't exist");
      }
    } else {
      System.out.println("Input error. File doesn't exist");
    }
  }
}
