package com.dreamland.suffixtrie

import java.util.*

/**
 * Created by XMD on 2017/9/26.
 */
class TreeNode<K,T:NodeData<K>> {
    private var parent:TreeNode<K,T>? = null
    private var children:HashMap<K,TreeNode<K,T>>? = null
    private var data:LinkedHashSet<T>? = null
    private var key:K?=null

    constructor(key: K?,parent: TreeNode<K,T>?=null) {
        this.parent = parent
        this.key = key
    }

    fun addData(data:T){
        if(this.data == null){
            this.data = LinkedHashSet<T>()
        }
        this.data?.add(data)
    }

    fun getDataSet() = data

    fun getDataList() = ArrayList<T>(data)

    fun hasData() = data?.isNotEmpty() == true

    fun getChild(key:K) = children?.get(key)?:null

    fun getKey() = key

    fun addChild(key: K,child:TreeNode<K,T>){
        if(children == null){
            children = HashMap<K,TreeNode<K,T>>()
        }
        children?.put(key,child)
    }

    fun hasChildren() = children?.isNotEmpty() == true

    fun getChildren() = children
 }