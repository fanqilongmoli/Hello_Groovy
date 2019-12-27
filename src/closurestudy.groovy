// 闭包就是一段代码块
def closure1 = { println "hello groovy" } // 无参数闭包
//def closure1 = { -> println "hello groovy"} // 无参数闭包
closure1.call()
closure1()

def closure2 = { String name -> println "hello ${name}" } // 有参数闭包
// 闭包的执行 下面两种方法
closure2.call("haha")
closure2("haha")

// 所有的闭包都存在一个隐式参数it；无需定义 直接传值就可以
def closure3 = { println "hello ${it}" }
closure3.call("你好")
closure3("你好")

// 闭包一定是有返回值的 没有return 返回的是一个null
def closureResult = {println "hello result"}
def result = closureResult.call();
println result // null

