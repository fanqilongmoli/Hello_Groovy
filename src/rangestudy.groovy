/**
 * groovy 数据结构 范围 range
 */

def range = 1..10
// 获取下标对应的值
println range[0] // 1
// 检查range 是否包含
println range.contains(10) // true

println range.from // 1 起始值
println range.to // 10 结束值

// range 遍历
range.each { println it }
for(i in range) {
    println i
}
// range 在switch中的使用
def getGrade(Number number){
    def result
    switch (number){
        case 0..<60:
            result = "不及格"
            break
        case 60..<70:
            result = "及格"
            break
        case 70..<80:
            result = "良好"
            break
        case 80..100:
            result = "优秀"
            break
    }
    return result
}
println getGrade(10) // 不及格
println getGrade(88) // 优秀


