package com.shammer.algorithms.tree;

import java.util.ArrayList;
import java.util.List;

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

    public BinarySearchTree<T> search(T searchValue) {
        if (value == null) return null;
        if (value.compareTo(searchValue) == 0) return this;
        return null;
    }

    public T value() {
        return value;
    }

    public List<T> traverseInOrder() {
        if (value != null) {
            List<T> nodeList = new ArrayList<>();
            nodeList.add(value);
            return nodeList;
        }
        return null;
    }
}
