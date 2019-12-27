/**
 * 闭包和字符串结合使用
 * 基本都是遍历操作 和接口回调比较类似
 */

String str = "the 2 and 3 is 5"
//each 遍历
str.each {
    String temp -> println temp
}
// find来查找符合条件的第一个
println str.find { String temp -> temp.isNumber() } // 2

// findAll
def list = str.findAll { String s -> s.isNumber() }
println list.toListString(); // [2, 3, 5]

// 查找字符串是否含有特定的类型
def result = str.any { String s -> s.isNumber() }
println result // true

// 查找字符串每项是特定的类型
println str.every { String s -> s.isNumber() } // false

// 遍历字符串进行操作
def list2 = str.collect {it-> it.toUpperCase()}
println list2 // [T, H, E,  , 2,  , A, N, D,  , 3,  , I, S,  , 5]

