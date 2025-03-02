package com.itangcent.springboot.demo.common.dto;

/**
 * Tree Node Data Transfer Object
 * Used to represent hierarchical data structures
 */
public class Node {
    /**
     * Node ID
     * Unique identifier
     */
    private Long id;

    /**
     * Node Name
     * Text identifier for display
     */
    private String name;

    /**
     * Parent Node
     * Points to the parent node of the current node, forming a tree structure
     */
    private Node parent;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }
} 