package com.shammer.algorithms.tree;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
        bst.insert(BigTenSchools.IOWA);
        assertEquals(1, bst.cardinality());
    }

    @Test
    public void singleItemTreeHasDepthOfOne() {
        BinarySearchTree<String> bst = new BinarySearchTree<>();
        bst.insert(BigTenSchools.IOWA);
        assertEquals(1, bst.depth());
    }

    @Test
    public void singleItemTreeCanBeInsertedAfterAndHasCardinalityOfTwo() {
        BinarySearchTree<String> bst = new BinarySearchTree<>();
        bst.insert(BigTenSchools.IOWA);
        bst.insert(BigTenSchools.MICHIGAN_STATE);
        assertEquals(2, bst.cardinality());
    }

    @Test
    public void singleItemTreeCanBeInsertedAfterAndHasDepthOfTwo() {
        BinarySearchTree<String> bst = new BinarySearchTree<>();
        bst.insert(BigTenSchools.IOWA);
        bst.insert(BigTenSchools.MICHIGAN_STATE);
        assertEquals(2, bst.depth());
    }

    @Test
    public void twoItemTreeCanBeInsertedBeforeAndHasCardinalityOfThree() {
        BinarySearchTree<String> bst = new BinarySearchTree<>();
        bst.insert(BigTenSchools.IOWA);
        bst.insert(BigTenSchools.MICHIGAN_STATE);
        bst.insert(BigTenSchools.ILLINOIS);
        assertEquals(3, bst.cardinality());
    }

    @Test
    public void threeItemTreeUnbalancedHasDepthOfThree() {
        BinarySearchTree<String> bst = new BinarySearchTree<>();
        bst.insert(BigTenSchools.IOWA);
        bst.insert(BigTenSchools.INDIANA);
        bst.insert(BigTenSchools.ILLINOIS);
        assertEquals(3, bst.depth());
    }

    @Test
    public void threeItemTreeBalancedHasDepthOfTwo() {
        BinarySearchTree<String> bst = new BinarySearchTree<>();
        bst.insert(BigTenSchools.IOWA);
        bst.insert(BigTenSchools.MICHIGAN_STATE);
        bst.insert(BigTenSchools.ILLINOIS);
        assertEquals(2, bst.depth());
    }

    @Test
    public void searchForItemInEmptyTreeReturnsNull() {
        BinarySearchTree<String> bst = new BinarySearchTree<>();
        BinarySearchTree<String> found = bst.search(BigTenSchools.IOWA);
        assertNull(found);
    }

    @Test
    public void searchForItemAtRootReturnsItem() {
        BinarySearchTree<String> bst = new BinarySearchTree<>();
        bst.insert(BigTenSchools.IOWA);
        BinarySearchTree<String> found = bst.search(BigTenSchools.IOWA);
        assertNotNull(found);
        assertEquals(BigTenSchools.IOWA, found.value());
    }

    @Test
    public void searchForItemNotAtRootReturnsNull() {
        BinarySearchTree<String> bst = new BinarySearchTree<>();
        bst.insert(BigTenSchools.IOWA);
        BinarySearchTree<String> found = bst.search(BigTenSchools.MICHIGAN_STATE);
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
        BinarySearchTree<String> bst = new BinarySearchTree<>();
        bst.insert(BigTenSchools.IOWA);
        List<String> expectedNodes = List.of(BigTenSchools.IOWA);
        assertEquals(expectedNodes, bst.traverseInOrder());
    }

}
