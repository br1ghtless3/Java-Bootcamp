package ru.br1ghtless.ap1_jv_t02.exercise1;

public class Dog extends Animal{
    Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public String toString() {
        return "Dog name = " + getName() + ", age = " + getAge();
    }

}
