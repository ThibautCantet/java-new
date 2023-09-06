package org.example.sequenced_collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sequenced {

    private final List<Integer> collection = new ArrayList<>();

    public Sequenced() {
        collection.addAll(List.of(1, 2, 3, 4, 5));
    }

    List<Integer> get() {
        return collection;
    }

    List<Integer> reverse() {
        return collection.reversed();
    }

    Integer getLast() {
        return collection.getLast();
    }

    void addLast(int i) {
        collection.addLast(i);
    }

    void removeLast() {
        collection.removeLast();
    }

    Integer getFirst() {
        return collection.getFirst();
    }

    void addFirst(int i) {
        collection.addFirst(i);
    }

    void removeFirst() {
        collection.removeFirst();
    }
}
