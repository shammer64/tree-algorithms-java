package com.shammer.algorithms.tree;

public class BinarySearchTree<T> {
    private T value;
    private BinarySearchTree<T> right;

    public long cardinality() {
        if (value == null) return 0;
        return 1 + rightCardinality();
    }

    private long rightCardinality() {
        return (right == null) ? 0 : right.cardinality();
    }

    public long depth() {
        if (value == null) return 0;
        return 1 + rightDepth();
    }

    private long rightDepth() {
        return (right == null) ? 0 : right.depth();
    }

    public void insert(T newValue) {
        if (value == null) value = newValue;
        else {
            right = new BinarySearchTree<>();
            right.insert(newValue);
        }
    }
}
