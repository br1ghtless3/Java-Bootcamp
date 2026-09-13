package ru.br1ghtless.ap1_jv_t01.exercise10;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.*;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = readInt(scanner);
    scanner.nextLine();

    List<User> users = new ArrayList<>();

    while (users.size() < n) {
      String namee = scanner.nextLine();
      int agee = readInt(scanner);

      scanner.nextLine();

      if (agee <= 0) System.out.println("Incorrect input. Age <= 0");
      else {
        var us = new User(namee, agee);
        users.add(us);
      }
    }
    String result =
        users.stream()
            .filter(u -> u.getAge() >= 18)
            .map(User::getName)
            .collect(Collectors.joining(", "));

    if (!result.isEmpty()) {
      System.out.println(result);
    }
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
}
