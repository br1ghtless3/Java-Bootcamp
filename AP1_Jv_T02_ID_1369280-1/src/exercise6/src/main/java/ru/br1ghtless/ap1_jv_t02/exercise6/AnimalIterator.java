package ru.br1ghtless.ap1_jv_t02.exercise6;

import java.util.List;

public class AnimalIterator implements BaseIterator<Animal>{
    private List<Animal> animals;
    private int currentIndex;

    AnimalIterator (List<Animal> animals) {
        this.animals = animals;
        this.currentIndex = 0;
    }

    @Override
    public Animal next() {
        return animals.get(currentIndex++);
    }

    @Override
    public boolean hasNext() {
        return currentIndex < animals.size();
    }

    @Override
    public void reset() {
        currentIndex = 0;
    }
}
