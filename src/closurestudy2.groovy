// 闭包和基本类型结合使用

// 用来求指定number的阶乘
int fab(int number) {
    int result = 1
    1.upto(number, { num -> result *= num })
    return result
}

int x = fab(5)
println x //120


int fab2(int number) {
    int result = 1
    number.downto(1) { num -> result *= num }
    return result;
}

int x2 = fab2(5)
println x2 //120

static int cal(int number) {
    int result = 0
    number.times {
        num -> result += num
    }
    return result
}

int x3 = cal(101)
println x3 // 5050


