package ru.br1ghtless.ap1_jv_t02.exercise6;

public interface BaseIterator<T> {
    T next();
    boolean hasNext();
    void reset();
}
