package ru.br1ghtless.ap1_jv_t02.exercise5;

import java.util.concurrent.TimeUnit;

public class Cat extends Animal {
    Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public String toString() {
        return  String.format("Cat name = %s, age = %d",
                getName(), getAge());
    }

    @Override
    public double goToWalk() {
        double timeToWalk = getAge() * 0.25;
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

