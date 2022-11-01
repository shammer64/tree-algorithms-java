package com.shammer.algorithms.tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AVLTreeTest {

    @Test
    public void emptyTreeHasCardinalityOfZero() {
        AVLSearchTree<String> ast = new AVLSearchTree<>();
        assertEquals(0, ast.cardinality());
    }

//    @Test
//    public void emptyTreeHasDepthOfZero() {
//        BinarySearchTree<String> bst = new BinarySearchTree<>();
//        assertEquals(0, bst.depth());
//    }

}
