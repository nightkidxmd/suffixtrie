package com.dreamland.suffixtrie
import java.util.*


/**
 * Created by XMD on 2017/9/26.
 */
object Test {

    fun makeData(size:Int = Int.MAX_VALUE,dataMaxLength:Int=3): List<Array<String>> {
        val seeds = arrayOf("张","三","李","四","王","老","五")
        val ret = LinkedList<Array<String>>()
        val random = Random()
        for(i in 1..size){
            val nameLength = random.nextInt(dataMaxLength)+1
            val name = Array(nameLength,init = {""})
            for(j in 0..nameLength-1){
                name[j] = seeds[random.nextInt(seeds.size)]
            }
            ret.add(name)
        }

        return ret
    }


    @JvmStatic
    fun main(args: Array<String>) {
        val raw = makeData(1000000,4)
        var start = System.currentTimeMillis()
        val tree = TrieTree<String, StringData>()
        raw.forEachIndexed { i, indexedValue ->
            tree.insert(StringData(i,indexedValue))
        }
        System.out.println("build tree ${System.currentTimeMillis()-start} ms")
        var sum = 0L
        for(i in 1..100){
            start = System.currentTimeMillis()
            val data = tree.find(StringData(keys = arrayOf("三","四")))
            val cost = System.currentTimeMillis()-start
            System.out.println("search $i: $cost ms --- ${data.size}")
            sum+=cost
        }
        System.out.println("avg: ${sum/100}  ms")
    }

    class StringData(val data: Int =0,keys:Array<String>?=null) : NodeData<String>(keys) {
        override fun toString(): String {
            return "StringData(data=$data) ${super.toString()}\n"
        }
    }

    class CharData(val data: Int=0,keys:Array<Char>?=null) : NodeData<Char>(keys) {
        override fun toString(): String {
            return "StringData(data=$data) ${super.toString()}\n"
        }
    }
}