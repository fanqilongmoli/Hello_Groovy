/**
 * groovy 数据结构 list
 */

// def list = new ArrayList() // java定义的方式
def list = [1, 2, 3, 4] // groovy 定义的方式
println list.class  // class java.util.ArrayList
println list.size() // 4

def array = [1, 2, 3, 4] as int[] // 定义数组
int[] array2 = [1, 2, 3, 4]

/**
 * 列表排序
 */
def sortList = [6, -3, 9, 2]
//Collections.sort(sortList, { a, b -> a == b ? 0 : Math.abs(a) < Math.abs(b) ? -1 : 1 }) // java方法
//println sortList //[2, -3, 6, 9]

sortList.sort { a, b -> a == b ? 0 : Math.abs(a) < Math.abs(b) ? -1 : 1 }
println sortList //[2, -3, 6, 9]

/**
 * list 添加元素
 */
def addList = []
addList.add(6)
println addList // [6]
//println addList.leftShift(7) //等价 <<
println addList << 7 // [6, 7]
println addList + 9 // [6, 7, 9] // 添加元素

/**
 * 列表查找
 */
def findList = [-3, 9, 6, 2, -7, 1, 5]
def result = findList.find { return it % 2 == 0 }
println result // 6  返回第一个
def result2 = findList.findAll { return it % 2 == 0 }
println result2 // [6, 2] 返回所有

def result3 = findList.any { return it % 2 != 0 }
println result3 // true  返回其中元素是否符号条件

def result4 = findList.every() { return it % 2 != 0 }
println result4 // false  返回所有元素是否符号条件

println findList.min() //-7 返回最小值

println findList.max() // 9 返回最大值

println findList.min { return Math.abs(it) } // 1  返回闭包条件的最小值

println findList.max { return Math.abs(it) } // 9 返回闭包条件的最大值

println findList.count { return it % 2 == 0 } // 2 返回闭包条件的数量