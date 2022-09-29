package com.shammer.algorithms.tree;

public class BinarySearchTree<T> {
    private T value;

    public long cardinality() {
        if (value == null) return 0;
        return 1;
    }

    public long depth() {
        if (value == null) return 0;
        return 1;
    }

    public void insert(T newValue) {
        this.value = newValue;
    }
}
