package ru.br1ghtless.ap1_jv_t02.exercise3;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

// List<Animal> хранит не сами абстрактные сущности,
// а ссылки на конкретные объекты классов-наследников — Dog и Cat

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
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
                    } else if (type.equals("cat")) {
                        pets.add(new Cat(petName, petAge));
                    } else if (type.equals("hamster")) {
                        pets.add(new Hamster(petName, petAge));
                    } else {
                        pets.add(new GuineaPig(petName, petAge));
                    }
                }
            }
        }

        for (Animal pet : pets) {
            if (pet instanceof Herbivore) System.out.println(pet);
        }

        for (Animal pet : pets) {
            if (pet instanceof Omnivore) System.out.println(pet);
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
        if (type.equals("dog") || type.equals("cat") || type.equals("hamster") || type.equals("guinea")) {
            return type;
        } else return null;
    }
}
