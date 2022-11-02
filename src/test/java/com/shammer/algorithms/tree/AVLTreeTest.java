package com.shammer.algorithms.tree;

import org.junit.jupiter.api.Test;

import static com.shammer.algorithms.tree.BigTenSchools.IOWA;
import static com.shammer.algorithms.tree.BigTenSchools.MICHIGAN_STATE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class AVLTreeTest {

    @Test
    public void emptyTreeHasCardinalityOfZero() {
        AVLSearchTree<String> ast = new AVLSearchTree<>();
        assertEquals(0, ast.cardinality());
    }

    @Test
    public void emptyTreeHasDepthOfZero() {
        AVLSearchTree<String> ast = new AVLSearchTree<>();
        assertEquals(0, ast.depth());
    }

    @Test
    public void emptyTreeHasNullValueAndHasCardinalityOfZero() {
        AVLSearchTree<String> ast = new AVLSearchTree<>();
        assertEquals(0, ast.cardinality());
        assertNull(ast.value());
    }

    @Test
    public void emptyTreeCanBeInsertedIntoAndHasCardinalityOfOne() {
        AVLSearchTree<String> ast = new AVLSearchTree<>();
        ast.insert(IOWA);
        assertEquals(1, ast.cardinality());
        assertEquals(IOWA, ast.value());
    }

    @Test
    public void singleItemTreeHasDepthOfOne() {
        AVLSearchTree<String> ast = new AVLSearchTree<>();
        ast.insert(IOWA);
        assertEquals(1, ast.depth());
    }

    @Test
    public void singleItemTreeCanBeInsertedAfterAndHasCardinalityOfTwo() {
        AVLSearchTree<String> ast = this.createTreeFromValues(
                IOWA, MICHIGAN_STATE
        );
        assertEquals(2, ast.cardinality());
    }

    private AVLSearchTree<String> createTreeFromValues(String... values) {
        AVLSearchTree<String> ast = new AVLSearchTree<>();
        for (String value : values)
            ast.insert(value);
        return ast;
    }

}
