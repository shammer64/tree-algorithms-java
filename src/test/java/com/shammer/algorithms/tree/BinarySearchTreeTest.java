package com.shammer.algorithms.tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinarySearchTreeTest {
    @Test
    public void foo() {
        assertEquals("bar", "foo");
    }

    // Tree Operations: insert, delete, search, traverse, cardinality, depth
    // Empty tree has cardinality 0, depth 0, search for any item returns null
    // Tree with one item has cardinality 1, depth 1, search for item returns item
    // Tree with two items has cardinality 2, depth 2, search for item returns item
    // Tree with three items (balanced) has cardinality 3, depth 2
    // Tree with three items (unbalanced) has cardinality 3, depth 3

    @Test
    public void emptyTreeHasCardinalityOfZero() {
        BinarySearchTree<String> bst = new BinarySearchTree();

        assertEquals(0, bst.cardinality());
    }

    @Test
    public void emptyTreeHasDepthOfZero() {
        BinarySearchTree<String> bst = new BinarySearchTree();

        assertEquals(0, bst.depth());
    }

}
