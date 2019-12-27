/**
 * groovy 数据结构 map
 */

// def map = new HashMap() //java中map定义

def g_map = [aa: 1, bb: 2, cc: 3]

// groovy 索引方式
println g_map.get("aa") // 1
println g_map["aa"] // 1
println g_map.aa // 1

// 添加元素
g_map.dd = 4 //存在就会更新值
// 添加多个元素
g_map.complex = ["vvv": 213, "bbb": 456]
println g_map.toMapString() // [aa:1, bb:2, cc:3, dd:4, complex:[vvv:213, bbb:456]]
println g_map.getClass() // class java.util.LinkedHashMap

// 遍历
g_map.each {
    println "key: ${it.key}"
    println "value: ${it.value}"
}
// 遍历 key value
g_map.each { key, value ->
    println "key: ${key}"
    println "value: ${value}"
}
// 带索引遍历
g_map.eachWithIndex { def entry, int index ->
    println "index: ${index}"
    println "key: ${entry.key}"
    println "value: ${entry.value}"
}
// 带索引遍历  key value
g_map.eachWithIndex { key, value, int index ->
    println "index_: ${index}"
    println "key_: ${key}"
    println "value_: ${value}"
}

// map 查到
g_map.find {}
g_map.findAll {}
g_map.count {}

// 分组
g_map.groupBy {}

//排序
g_map.sort {}
