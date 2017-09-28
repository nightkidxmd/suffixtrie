package com.dreamland.suffixtrie

import java.util.*

/**
 * Created by XMD on 2017/9/26.
 */
abstract class NodeData<T>(var nodekeys:Array<T>?=null) {

    override fun toString(): String{
        return "NodeData(nodekey=${Arrays.toString(nodekeys)})"
    }
}