package com.itangcent.common.dto

/**
 * 树节点数据传输对象
 * 用于表示具有层级结构的数据
 */
data class Node(
    /**
     * 节点ID
     * 唯一标识符
     */
    var id: Long? = null,

    /**
     * 节点名称
     * 用于显示的文本标识
     */
    var name: String? = null,

    /**
     * 父节点
     * 指向当前节点的父节点，形成树形结构
     */
    var parent: Node? = null
) 