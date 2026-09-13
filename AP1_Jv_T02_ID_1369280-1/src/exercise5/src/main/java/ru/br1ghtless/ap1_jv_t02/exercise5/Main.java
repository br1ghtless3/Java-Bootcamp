package ru.br1ghtless.ap1_jv_t02.exercise5;

import java.util.Locale;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

// List<Animal> хранит не сами абстрактные сущности,
// а ссылки на конкретные объекты классов-наследников — Dog и Cat

public class Main {
    public static void main(String[] args) {
        long programStartTime = System.currentTimeMillis();
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);
        int n = readInt(scanner);
        List<Animal> pets = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = readPetType(scanner);
            if (type == null) {
                System.out.println("Incorrect input. Unsupported pet type");
            } else {
                String petName = scanner.nextLine();
                int petAge = readInt(scanner); // возраст
                if (petAge <= 0) System.out.println("Incorrect input. Age <= 0");
                else {
                    if (type.equals("dog")) {
                        pets.add(new Dog(petName, petAge));
                    } else {
                        pets.add(new Cat(petName, petAge));
                    }
                }
            }
        }

        List<Thread> threads = new ArrayList<>();

        for (Animal pet : pets) {
            var thread = new Thread(() -> {
                double startTime = (System.currentTimeMillis() - programStartTime) / 1000.0;

                try {
                    pet.goToWalk();
                } catch (Exception e) {
                    Thread.currentThread().interrupt();
                }

                double endTime = (System.currentTimeMillis() - programStartTime) / 1000.0;

                System.out.println(String.format(Locale.US, "%s, start time = %.2f, end time = %.2f",
                        pet, startTime, endTime));
            });
            threads.add(thread);
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    static int readInt(Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Could not parse a number. Please, try again");
            }
        }
    }

    static String readPetType(Scanner scanner) {
        String type = scanner.nextLine().trim();
        if (type.equals("dog") || type.equals("cat")) {
            return type;
        } else return null;
    }
}
