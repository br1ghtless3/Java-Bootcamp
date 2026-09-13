package ru.br1ghtless.ap1_jv_t02.exercise4;

public class Dog extends Animal {
    Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public String toString() {
        return  String.format("Dog name = %s, age = %d",
                getName(), getAge());
    }
}
