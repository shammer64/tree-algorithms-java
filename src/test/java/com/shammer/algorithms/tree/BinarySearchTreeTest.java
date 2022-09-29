package com.shammer.algorithms.tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinarySearchTreeTest {

    // Tree Operations: insert, delete, search, traverse, cardinality, depth
    // Empty tree has cardinality 0, depth 0, search for any item returns null
    // Tree with one item has cardinality 1, depth 1, search for item returns item
    // Tree with two items has cardinality 2, depth 2, search for item returns item
    // Tree with three items (balanced) has cardinality 3, depth 2
    // Tree with three items (unbalanced) has cardinality 3, depth 3

    @Test
    public void emptyTreeHasCardinalityOfZero() {
        BinarySearchTree<String> bst = new BinarySearchTree<>();
        assertEquals(0, bst.cardinality());
    }

    @Test
    public void emptyTreeHasDepthOfZero() {
        BinarySearchTree<String> bst = new BinarySearchTree<>();
        assertEquals(0, bst.depth());
    }

    @Test
    public void emptyTreeCanBeInsertedIntoAndHasCardinalityOfZero() {
        BinarySearchTree<String> bst = new BinarySearchTree<>();
        bst.insert("Iowa Hawkeyes");
        assertEquals(1, bst.cardinality());
    }

    @Test
    public void singleItemTreeHasDepthOfOne() {
        BinarySearchTree<String> bst = new BinarySearchTree<>();
        bst.insert("Iowa Hawkeyes");
        assertEquals(1, bst.depth());
    }

    @Test
    public void singleItemTreeCanBeInsertedAfterAndHasCardinalityOfTwo() {
        BinarySearchTree<String> bst = new BinarySearchTree<>();
        bst.insert("Iowa Hawkeyes");
        bst.insert("Michigan State Spartans");
        assertEquals(2, bst.cardinality());
    }

    @Test
    public void singleItemTreeCanBeInsertedAfterAndHasDepthOfTwo() {
        BinarySearchTree<String> bst = new BinarySearchTree<>();
        bst.insert("Iowa Hawkeyes");
        bst.insert("Michigan State Spartans");
        assertEquals(2, bst.depth());
    }

    @Test
    public void twoItemTreeCanBeInsertedBeforeAndHasCardinalityOfThree() {
        BinarySearchTree<String> bst = new BinarySearchTree<>();
        bst.insert("Iowa Hawkeyes");
        bst.insert("Michigan State Spartans");
        bst.insert("Illinois Fighting Illini");
        assertEquals(3, bst.cardinality());
    }

    @Test
    public void threeItemTreeUnbalancedHasDepthOfThree() {
        BinarySearchTree<String> bst = new BinarySearchTree<>();
        bst.insert("Iowa Hawkeyes");
        bst.insert("Indiana Hoosiers");
        bst.insert("Illinois Fighting Illini");
        assertEquals(3, bst.depth());
    }

    @Test
    public void threeItemTreeBalancedHasDepthOfTwo() {
        BinarySearchTree<String> bst = new BinarySearchTree<>();
        bst.insert("Iowa Hawkeyes");
        bst.insert("Michigan State Spartans");
        bst.insert("Illinois Fighting Illini");
        assertEquals(2, bst.depth());
    }

}
