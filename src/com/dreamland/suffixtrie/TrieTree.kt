package com.dreamland.suffixtrie

import java.util.*

/**
 * Created by XMD on 2017/9/26.
 */
class TrieTree<K, T : NodeData<K>> {
    companion object {
        private val KEY_HEAD = null
    }
    private var head: TreeNode<K, T> = TreeNode(KEY_HEAD)

    fun insert(data: T, offset: Int = 0) {
        var i = offset
        while (i < data.nodekeys?.size ?: 0) {
            _insert(data, i)
            i++
        }
    }

    private fun _insert(data: T, offset: Int = 0) {
        var temp = head
        var i = offset
        while (i < data.nodekeys?.size ?: 0) {
            var node = temp.getChild(data.nodekeys!![i])
            if (node == null) {
                node = TreeNode(data.nodekeys!![i], temp)
                temp.addChild(node.getKey()!!, node)
            }
            temp = node
            i++
        }
        temp.addData(data)
    }

    fun reset() {
        head = TreeNode(KEY_HEAD)
    }

    fun find(data: T): HashSet<T> {
        var temp: TreeNode<K, T>? = head
        var i = 0
        while (i < data.nodekeys?.size ?: 0 && temp != null) {
            temp = temp.getChild(data.nodekeys!![i++])
        }
        val ret = LinkedHashSet<T>()
        if (temp != null) {
            getAllChildrenDataRecurrence(temp, ret)
        }
        return ret
    }

    private fun getAllChildrenDataRecurrence(node: TreeNode<K, T>, data: HashSet<T>) {
        if (node.hasChildren()) {
            node.getChildren()?.asIterable()?.forEach {
                getAllChildrenDataRecurrence(it.value, data)
            }
        }

        if (node.hasData()) {
            data.addAll(node.getDataSet()!!)
        }
    }
}