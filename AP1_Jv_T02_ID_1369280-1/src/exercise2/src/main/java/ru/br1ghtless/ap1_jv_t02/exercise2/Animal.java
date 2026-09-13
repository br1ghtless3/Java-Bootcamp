package ru.br1ghtless.ap1_jv_t02.exercise2;

abstract class Animal {
    private String name;
    private int age;
    private double weight;

    Animal (String name, int age, double weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public double getWeight() {
        return this.weight;
    }

    abstract double getFeedInfoKg();
}
