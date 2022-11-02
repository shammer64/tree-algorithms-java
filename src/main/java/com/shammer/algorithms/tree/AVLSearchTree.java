package com.shammer.algorithms.tree;

public class AVLSearchTree<T extends Comparable<T>> {
    private T value;
    private AVLSearchTree<T> right;
    private AVLSearchTree<T> left;

    public long cardinality() {
        return (this.value == null ? 0 : 1) + rightCardinality() + leftCardinality();
    }

    private long rightCardinality() {
        return (right == null) ? 0 : right.cardinality();
    }

    private long leftCardinality() {
        return (left == null) ? 0 : left.cardinality();
    }

    public long depth() {
        return this.value == null ? 0 : 1 + Math.max(rightDepth(), leftDepth());
    }

    private long rightDepth() {
        return right == null ? 0 : right.depth();
    }

    private long leftDepth() {
        return left == null ? 0 : left.depth();
    }

    public T value() {
        return this.value;
    }

    public void insert(T value) {
        if (this.value == null) {
            this.value = value;
        } else if (value.compareTo(this.value) >= 0) {
            right = new AVLSearchTree<>();
            right.insert(value);
        } else {
            left = new AVLSearchTree<>();
            left.insert(value);
        }
    }
}
