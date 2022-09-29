package com.shammer.algorithms.tree;

public class BinarySearchTree<T extends Comparable<T>> {
    private T value;
    private BinarySearchTree<T> right;
    private BinarySearchTree<T> left;

    public long cardinality() {
        if (value == null) return 0;
        return 1 + leftCardinality() + rightCardinality();
    }

    private long leftCardinality() {
        return (left == null) ? 0 : left.cardinality();
    }

    private long rightCardinality() {
        return (right == null) ? 0 : right.cardinality();
    }

    public long depth() {
        if (value == null) return 0;
        return 1 + childDepth();
    }

    private long childDepth() {
        return Math.max(leftDepth(), rightDepth());
    }

    private long leftDepth() {
        return (left == null) ? 0 : left.depth();
    }

    private long rightDepth() {
        return (right == null) ? 0 : right.depth();
    }

    public void insert(T newValue) {
        if (value == null) value = newValue;
        else if (newValue.compareTo(value) >= 0) {
            if (right == null)
                right = new BinarySearchTree<>();
            right.insert(newValue);
        } else {
            if (left == null)
                left = new BinarySearchTree<>();
            left.insert(newValue);
        }
    }
}
