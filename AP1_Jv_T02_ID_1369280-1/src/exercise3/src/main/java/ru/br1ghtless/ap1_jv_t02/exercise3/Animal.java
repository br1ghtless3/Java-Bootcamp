package ru.br1ghtless.ap1_jv_t02.exercise3;

abstract class Animal {
    private String name;
    private int age;

    Animal (String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }
}
