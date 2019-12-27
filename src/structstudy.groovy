def x = 1.23
def result
//switch (x.class){
switch (x) {
    case "foo":
        result = "foo"
        break
    case "bar":
        result = "bar"
        break
    case [1.23, 4, 5, 6, "list"]:
        result = "list" // 列表
        break
    case 12..30:
        result = "range" //范围
        break
    case Integer:
        result = "Integer"
        break
    case BigDecimal:
        result = "BigDecimal"
        break
    default:
        result = "default";
}
println result

/**
 * 对范围进行for循环
 */
def sum = 0
for (i in 0..9) {
    sum += i;
}
println sum

/**
 * 对list循环
 */
for (i in [1, 2, 3, 4, 5, 6, 7, 8, 9]) {
    sum += i
}
println sum

/**
 * 对map进行for循环
 */
for (i in ["LL": 1, "AA": 2, "DD": 3]) {
    sum += i.value
}
println sum;












