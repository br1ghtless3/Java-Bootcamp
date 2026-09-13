package ru.br1ghtless.ap1_jv_t02.exercise4;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

// List<Animal> хранит не сами абстрактные сущности,
// а ссылки на конкретные объекты классов-наследников — Dog и Cat

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = readInt(scanner);
        List<Animal> pets = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
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
        });
        pets.stream()
                .map(pet -> {
                    if (pet.getAge() > 10) {
                        if (pet instanceof Dog) {
                            return new Dog(pet.getName(), pet.getAge() + 1);
                        } else {
                            return new Cat(pet.getName(), pet.getAge() + 1);
                        }
                    }
                    return pet;
                })
                .forEach(System.out::println);
    }

    static int readInt(Scanner scanner) {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Could not parse a number. Please, try again");
            return readInt(scanner);
        }
    }


    static String readPetType(Scanner scanner) {
        String type = scanner.nextLine().trim();
        if (type.equals("dog") || type.equals("cat")) {
            return type;
        } else return null;
    }
}
