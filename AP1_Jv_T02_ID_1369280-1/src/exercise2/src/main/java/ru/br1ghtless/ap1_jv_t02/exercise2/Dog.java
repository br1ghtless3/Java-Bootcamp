package ru.br1ghtless.ap1_jv_t02.exercise2;

import java.util.Locale;

public class Dog extends Animal{
    Dog(String name, int age, double weight) {
        super(name, age, weight);
    }

    @Override
    public double getFeedInfoKg() {
        return getWeight() * 0.3;
    }

    @Override
    public String toString() {
        return String.format(Locale.US, "Dog name = %s, age = %d, mass = %.2f, feed = %.2f",
                getName(), getAge(), getWeight(), getFeedInfoKg());
    }

}
