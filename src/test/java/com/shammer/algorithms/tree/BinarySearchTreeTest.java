package com.shammer.algorithms.tree;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.shammer.algorithms.tree.BigTenSchools.*;
import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTreeTest {

    // Tree Operations: insert, delete, search, traverse, cardinality, depth
    // Empty tree has cardinality 0, depth 0, search for any item returns null
    // Tree with one item has cardinality 1, depth 1, search for item returns item
    // Tree with two items has cardinality 2, depth 2, search for item returns item
    // Tree with three items (balanced) has cardinality 3, depth 2
    // Tree with three items (unbalanced) has cardinality 3, depth 3

    private static BinarySearchTree<String> createTreeFromValues(String... values) {
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
        BinarySearchTree<String> bst = createTreeFromValues(IOWA);
        assertEquals(1, bst.cardinality());
    }

    @Test
    public void singleItemTreeHasDepthOfOne() {
        BinarySearchTree<String> bst = createTreeFromValues(IOWA);
        assertEquals(1, bst.depth());
    }

    @Test
    public void singleItemTreeCanBeInsertedAfterAndHasCardinalityOfTwo() {
        BinarySearchTree<String> bst = createTreeFromValues(
                IOWA, MICHIGAN_STATE
        );
        assertEquals(2, bst.cardinality());
    }

    @Test
    public void singleItemTreeCanBeInsertedAfterAndHasDepthOfTwo() {
        BinarySearchTree<String> bst = createTreeFromValues(
                IOWA, MICHIGAN_STATE
        );
        assertEquals(2, bst.depth());
    }

    @Test
    public void twoItemTreeCanBeInsertedBeforeAndHasCardinalityOfThree() {
        BinarySearchTree<String> bst = createTreeFromValues(
                IOWA, MICHIGAN_STATE, ILLINOIS
        );
        assertEquals(3, bst.cardinality());
    }

    @Test
    public void threeItemTreeUnbalancedHasDepthOfThree() {
        BinarySearchTree<String> bst = createTreeFromValues(
                IOWA, INDIANA, ILLINOIS
        );
        assertEquals(3, bst.depth());
    }

    @Test
    public void threeItemTreeBalancedHasDepthOfTwo() {
        BinarySearchTree<String> bst = createTreeFromValues(
                IOWA, MICHIGAN_STATE, ILLINOIS
        );
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
        BinarySearchTree<String> bst = createTreeFromValues(IOWA);
        BinarySearchTree<String> found = bst.search(IOWA);
        assertNotNull(found);
        assertEquals(IOWA, found.value());
    }

    @Test
    public void searchForItemNotAtRootReturnsNull() {
        BinarySearchTree<String> bst = createTreeFromValues(IOWA);
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
        BinarySearchTree<String> bst = createTreeFromValues(IOWA);
        List<String> expectedNodes = List.of(IOWA);
        assertEquals(expectedNodes, bst.traverseInOrder());
    }

    @Test
    public void inOrderTraverseOfTwoItemTreeLeft() {
        BinarySearchTree<String> bst = createTreeFromValues(
                IOWA, ILLINOIS
        );
        List<String> expectedNodes = List.of(ILLINOIS, IOWA);
        assertEquals(expectedNodes, bst.traverseInOrder());
    }

    @Test
    public void inOrderTraverseOneLevelBalancedTree() {
        BinarySearchTree<String> bst = createTreeFromValues(
                INDIANA, IOWA, ILLINOIS
        );
        List<String> expectedNodes = List.of(ILLINOIS, INDIANA, IOWA);
        assertEquals(expectedNodes, bst.traverseInOrder());
    }

    @Test
    public void inOrderTraverseOfSixItemTree() {
        BinarySearchTree<String> bst = createTreeFromValues(
                PURDUE, INDIANA, MICHIGAN_STATE,
                IOWA, MICHIGAN, ILLINOIS
        );
        List<String> expectedNodes = List.of(
                ILLINOIS, INDIANA, IOWA,
                MICHIGAN_STATE, MICHIGAN, PURDUE);
        assertEquals(expectedNodes, bst.traverseInOrder());
    }

    @Test
    public void postOrderTraverseOfEmptyTree() {
        var bst = createTreeFromValues();
        assertEquals(new ArrayList<String>(), bst.traversePostOrder());
    }

    @Test
    public void postOrderTraverseOfSingleNode() {
        var bst = createTreeFromValues(IOWA);
        assertEquals(List.of(IOWA), bst.traversePostOrder());
    }

    @Test
    public void postOrderTraverseOfLeftNode() {
        var bst = createTreeFromValues(
                IOWA, INDIANA
        );
        assertEquals(List.of(INDIANA, IOWA), bst.traversePostOrder());
    }

    @Test
    public void postOrderTraverseOfRightNode() {
        var bst = createTreeFromValues(
                IOWA, MICHIGAN
        );
        assertEquals(List.of(MICHIGAN, IOWA), bst.traversePostOrder());
    }

    @Test
    public void postOrderTraverseOfLeftAndRightNode() {
        var bst = createTreeFromValues(
                IOWA, INDIANA, MICHIGAN
        );
        assertEquals(List.of(INDIANA, MICHIGAN, IOWA), bst.traversePostOrder());
    }

    @Test
    public void postOrderTraverseOfSixItemTree() {
        BinarySearchTree<String> bst = createTreeFromValues(
                PURDUE, INDIANA, MICHIGAN_STATE,
                IOWA, MICHIGAN, ILLINOIS
        );
        List<String> expectedNodes = List.of(
                ILLINOIS, IOWA, MICHIGAN,
                MICHIGAN_STATE, INDIANA, PURDUE
        );
        assertEquals(expectedNodes, bst.traversePostOrder());
    }

    @Test
    public void preOrderTraverseOfEmptyTree() {
        var bst = createTreeFromValues();
        assertEquals(new ArrayList<String>(), bst.traversePreOrder());
    }

    @Test
    public void preOrderTraverseOfSingleNode() {
        var bst = createTreeFromValues(IOWA);
        assertEquals(List.of(IOWA), bst.traversePreOrder());
    }

    @Test
    public void preOrderTraverseOfLeftNode() {
        var bst = createTreeFromValues(
                IOWA, INDIANA
        );
        assertEquals(List.of(IOWA, INDIANA), bst.traversePreOrder());
    }

    @Test
    public void preOrderTraverseOfRightNode() {
        var bst = createTreeFromValues(
                IOWA, MICHIGAN
        );
        assertEquals(List.of(IOWA, MICHIGAN), bst.traversePreOrder());
    }


    @Test
    public void preOrderTraverseOfLeftAndRightNode() {
        var bst = createTreeFromValues(
                IOWA, INDIANA, MICHIGAN
        );
        assertEquals(List.of(IOWA, INDIANA, MICHIGAN), bst.traversePreOrder());
    }

    @Test
    public void preOrderTraverseOfSixItemTree() {
        BinarySearchTree<String> bst = createTreeFromValues(
                PURDUE, INDIANA, MICHIGAN_STATE,
                IOWA, MICHIGAN, ILLINOIS
        );
        List<String> expectedNodes = List.of(
                PURDUE, INDIANA, ILLINOIS,
                MICHIGAN_STATE, IOWA, MICHIGAN
        );
        assertEquals(expectedNodes, bst.traversePreOrder());
    }

    @Test
    public void shouldWorkWithIntegers() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(57);
        bst.insert(23);
        bst.insert(103);
        bst.insert(93);
        bst.insert(8);
        bst.insert(85);
        bst.insert(171);
        List<Integer> expectedNodes = List.of(8, 23, 57, 85, 93, 103, 171);
        assertEquals(expectedNodes, bst.traverseInOrder());
    }

    @Test
    public void shouldWorkWithAClassThatImplementsComparable() {
        // MyComparableThingy comparison is by closest value to 100
        BinarySearchTree<MyComparableThingy> bst = new BinarySearchTree<>();
        bst.insert(new MyComparableThingy(139));
        bst.insert(new MyComparableThingy(27));
        bst.insert(new MyComparableThingy(78));
        bst.insert(new MyComparableThingy(99));
        bst.insert(new MyComparableThingy(127));
        bst.insert(new MyComparableThingy(13));
        List<MyComparableThingy> expectedNodes = List.of(
                new MyComparableThingy(99),
                new MyComparableThingy(78),
                new MyComparableThingy(127),
                new MyComparableThingy(139),
                new MyComparableThingy(27),
                new MyComparableThingy(13)
        );
        assertEquals(expectedNodes, bst.traverseInOrder());
    }

    static class MyComparableThingy implements Comparable<MyComparableThingy> {
        private final int value;

        public MyComparableThingy(int value) {
            this.value = value;
        }

        @Override
        public int compareTo(MyComparableThingy thingy) {
            return this.distanceFrom100() - thingy.distanceFrom100();
        }

        private int distanceFrom100() {
            return Math.abs(100 - value);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof MyComparableThingy)) return false;
            MyComparableThingy that = (MyComparableThingy) o;
            return value == that.value;
        }

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }

        @Override
        public String toString() {
            return "MyComparableThingy{" +
                    "value=" + value +
                    '}';
        }
    }
}
