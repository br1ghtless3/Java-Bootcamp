package ru.br1ghtless.ap1_jv_t02.exercise6;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

// List<Animal> хранит не сами абстрактные сущности,
// а ссылки на конкретные объекты классов-наследников — Dog и Cat

public class Main {
    public static void main(String[] args) {
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

        AnimalIterator iterator = new AnimalIterator(pets);

        while (iterator.hasNext()) {
            Animal pet = iterator.next();
            System.out.println(pet);
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
