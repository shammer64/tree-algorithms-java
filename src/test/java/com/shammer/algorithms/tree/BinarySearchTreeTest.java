package com.shammer.algorithms.tree;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.shammer.algorithms.tree.BigTenSchools.*;
import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTreeTest {

    // Tree Operations: insert, delete, search, traverse, cardinality, depth
    // Empty tree has cardinality 0, depth 0, search for any item returns null
    // Tree with one item has cardinality 1, depth 1, search for item returns item
    // Tree with two items has cardinality 2, depth 2, search for item returns item
    // Tree with three items (balanced) has cardinality 3, depth 2
    // Tree with three items (unbalanced) has cardinality 3, depth 3

    private static BinarySearchTree<String> createBinarySearchTreeFromValues(String... values) {
        BinarySearchTree<String> bst = new BinarySearchTree<>();
        for (String value : values)
            bst.insert(value);
        return bst;
    }

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
        bst.insert(IOWA);
        assertEquals(1, bst.cardinality());
    }

    @Test
    public void singleItemTreeHasDepthOfOne() {
        BinarySearchTree<String> bst = createBinarySearchTreeFromValues(
            IOWA
        );
        assertEquals(1, bst.depth());
    }

    @Test
    public void singleItemTreeCanBeInsertedAfterAndHasCardinalityOfTwo() {
        BinarySearchTree<String> bst = createBinarySearchTreeFromValues(
            IOWA,
            MICHIGAN_STATE
        );
        assertEquals(2, bst.cardinality());
    }

    @Test
    public void singleItemTreeCanBeInsertedAfterAndHasDepthOfTwo() {
        BinarySearchTree<String> bst = createBinarySearchTreeFromValues(
            IOWA,
            MICHIGAN_STATE
        );
        assertEquals(2, bst.depth());
    }

    @Test
    public void twoItemTreeCanBeInsertedBeforeAndHasCardinalityOfThree() {
        BinarySearchTree<String> bst = createBinarySearchTreeFromValues(
            IOWA,
            MICHIGAN_STATE,
            ILLINOIS
        );
        assertEquals(3, bst.cardinality());
    }

    @Test
    public void threeItemTreeUnbalancedHasDepthOfThree() {
        BinarySearchTree<String> bst = createBinarySearchTreeFromValues(
            IOWA,
            INDIANA,
            ILLINOIS
        );
        assertEquals(3, bst.depth());
    }

    @Test
    public void threeItemTreeBalancedHasDepthOfTwo() {
        BinarySearchTree<String> bst = new BinarySearchTree<>();
        bst.insert(IOWA);
        bst.insert(MICHIGAN_STATE);
        bst.insert(ILLINOIS);
        assertEquals(2, bst.depth());
    }

    @Test
    public void searchForItemInEmptyTreeReturnsNull() {
        BinarySearchTree<String> bst = new BinarySearchTree<>();
        BinarySearchTree<String> found = bst.search(IOWA);
        assertNull(found);
    }

    @Test
    public void searchForItemAtRootReturnsItem() {
        BinarySearchTree<String> bst = createBinarySearchTreeFromValues(
                IOWA
        );
        BinarySearchTree<String> found = bst.search(IOWA);
        assertNotNull(found);
        assertEquals(IOWA, found.value());
    }

    @Test
    public void searchForItemNotAtRootReturnsNull() {
        BinarySearchTree<String> bst = createBinarySearchTreeFromValues(
                IOWA
        );
        BinarySearchTree<String> found = bst.search(MICHIGAN_STATE);
        assertNull(found);
    }

    @Test
    public void inOrderTraverseOfEmptyTree() {
        BinarySearchTree<String> bst = new BinarySearchTree<>();
        List<String> expectedNodes = new ArrayList<>();
        assertEquals(expectedNodes, bst.traverseInOrder());
    }

    @Test
    public void inOrderTraverseOfSingleItemTree() {
        BinarySearchTree<String> bst = createBinarySearchTreeFromValues(
                IOWA
        );
        List<String> expectedNodes = List.of(IOWA);
        assertEquals(expectedNodes, bst.traverseInOrder());
    }

    @Test
    public void inOrderTraverseOfTwoItemTreeLeft() {
        BinarySearchTree<String> bst = createBinarySearchTreeFromValues(
            IOWA,
            ILLINOIS
        );
        List<String> expectedNodes = List.of(ILLINOIS, IOWA);
        assertEquals(expectedNodes, bst.traverseInOrder());
    }

    @Test
    public void inOrderTraverseOneLevelBalancedTree() {
        BinarySearchTree<String> bst = createBinarySearchTreeFromValues(
                INDIANA,
                IOWA,
                ILLINOIS
        );
        List<String> expectedNodes = List.of(ILLINOIS, INDIANA, IOWA);
        assertEquals(expectedNodes, bst.traverseInOrder());
    }

    @Test
    public void inOrderTraverseOfSixItemTree() {
        BinarySearchTree<String> bst = createBinarySearchTreeFromValues(
                PURDUE,
                INDIANA,
                MICHIGAN_STATE,
                IOWA,
                MICHIGAN,
                ILLINOIS
        );
        List<String> expectedNodes = List.of(
                ILLINOIS, INDIANA,
                IOWA, MICHIGAN_STATE,
                MICHIGAN, PURDUE);
        assertEquals(expectedNodes, bst.traverseInOrder());
    }

    @Test
    public void postOrderTraverseOfEmptyTree() {
        var bst = createBinarySearchTreeFromValues();
        assertEquals(new ArrayList<String>(), bst.traversePostOrder());
    }

    @Test
    public void postOrderTraverseOfSingleNode() {
        var bst = createBinarySearchTreeFromValues(IOWA);
        assertEquals(List.of(IOWA), bst.traversePostOrder());
    }

    @Test
    public void postOrderTraverseOfLeftNode() {
        var bst = createBinarySearchTreeFromValues(
                IOWA, INDIANA);
        assertEquals(List.of(INDIANA, IOWA), bst.traversePostOrder());
    }

    @Test
    public void postOrderTraverseOfRightNode() {
        var bst = createBinarySearchTreeFromValues(
                IOWA, MICHIGAN);
        assertEquals(List.of(MICHIGAN, IOWA), bst.traversePostOrder());
    }

    @Test
    public void postOrderTraverseOfLeftAndRightNode() {
        var bst = createBinarySearchTreeFromValues(
                IOWA, INDIANA, MICHIGAN);
        assertEquals(List.of(INDIANA, MICHIGAN, IOWA), bst.traversePostOrder());
    }


}
