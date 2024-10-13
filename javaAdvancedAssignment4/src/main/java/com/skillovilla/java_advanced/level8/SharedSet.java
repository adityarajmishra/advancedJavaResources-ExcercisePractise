package com.skillovilla.java_advanced.level8;

import java.util.HashSet;
import java.util.Set;

class SharedSet {
    private final Set<Integer> set = new HashSet<>();

    public synchronized void addElement(int element) {
        set.add(element);
    }

    public synchronized Set<Integer> getElements() {

        return new HashSet<>(set);
    }
}
