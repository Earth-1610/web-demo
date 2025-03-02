package com.itangcent.springboot.demo.common.dto;

/**
 * 树形节点数据传输对象
 * 用于表示具有层级关系的数据结构
 */
public class Node {
    /**
     * 节点ID
     * 唯一标识符
     */
    private Long id;

    /**
     * 节点名称
     * 显示用的文本标识
     */
    private String name;

    /**
     * 父节点
     * 指向当前节点的上级节点，形成树形结构
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