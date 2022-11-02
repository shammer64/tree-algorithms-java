package com.shammer.algorithms.tree;

public class AVLSearchTree<T extends Comparable<T>> {
    private T value;
    private AVLSearchTree<T> right;

    public long cardinality() {
        return (this.value == null ? 0 : 1) + rightCardinality();
    }

    private long rightCardinality() {
        return (right == null) ? 0 : right.cardinality();
    }

    public long depth() {
        return this.value == null ? 0 : 1;
    }

    public T value() {
        return this.value;
    }

    public void insert(T value) {
        if (this.value == null) {
            this.value = value;
        } else {
            right = new AVLSearchTree<>();
            right.insert(value);
        }
    }
}
