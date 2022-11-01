package com.shammer.algorithms.tree;

public class AVLSearchTree<T> {
    private T value;

    public long cardinality() {
        return this.value == null ? 0 : 1;
    }

    public long depth() {
        return 0;
    }

    public T value() {
        return this.value;
    }

    public void insert(T value) {
        this.value=value;
    }
}
