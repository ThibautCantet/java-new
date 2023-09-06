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
        return collection.stream()
                .sorted(Collections.reverseOrder())
                .toList();
    }

    Integer getLast() {
        return collection.get(collection.size()-1);
    }

    void addLast(int i) {
        collection.add(i);
    }

    void removeLast() {
        collection.remove(collection.size() - 1);
    }

    Integer getFirst() {
        return collection.get(0);
    }

    void addFirst(int i) {
        collection.add(0, i);
    }

    void removeFirst() {
        collection.remove(0);
    }
}
