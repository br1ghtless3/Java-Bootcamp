package ru.br1ghtless.ap1_jv_t02.exercise5;

import java.util.concurrent.TimeUnit;

public class Dog extends Animal {
    Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public String toString() {
        return  String.format("Dog name = %s, age = %d",
                getName(), getAge());
    }

    @Override
    public double goToWalk() {
        double timeToWalk = getAge() * 0.5;
        long seconds = (long) timeToWalk;
        long milliseconds = (long) ((timeToWalk - seconds) * 1000);

        try {
            TimeUnit.SECONDS.sleep(seconds);
            if (milliseconds > 0) {
                TimeUnit.MILLISECONDS.sleep(milliseconds);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return timeToWalk;
    }
}
