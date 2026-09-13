package ru.br1ghtless.ap1_jv_t02.exercise2;

import java.util.Locale;

public class Cat extends Animal {
    Cat(String name, int age, double weight) {
        super(name, age, weight);
    }

    @Override
    public double getFeedInfoKg() {
        return getWeight() * 0.1;
    }

    @Override
    public String toString() {
        return String.format(Locale.US, "Cat name = %s, age = %d, mass = %.2f, feed = %.2f",
                getName(), getAge(), getWeight(), getFeedInfoKg());
    }
}
