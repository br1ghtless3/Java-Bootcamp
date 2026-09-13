package ru.br1ghtless.ap1_jv_t02.exercise4;

public class Cat extends Animal {
    Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public String toString() {
        return  String.format("Cat name = %s, age = %d",
                getName(), getAge());
    }
}
