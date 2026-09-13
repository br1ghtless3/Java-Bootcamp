package ru.br1ghtless.ap1_jv_t02.exercise3;

public class Cat extends Animal implements Omnivore {
    Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public String hunt() {
        return "I can hunt for mice";
    }

    @Override
    public String toString() {
        return  String.format("Cat name = %s, age = %d. %s",
                getName(), getAge(), hunt());
    }
}
