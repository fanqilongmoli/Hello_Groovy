/**
 * 闭包的三个重要变量 ： this,owner,delegate
 */

def scriptClosure = {
    println "scriptClosure${this}" // scriptClosureclosurestudy4@1af2d44a
    // this 代表闭包定义处的类
    println "scriptClosure${owner}" // scriptClosureclosurestudy4@1af2d44a
    // owner 代表闭包定义处的类或者对象
    println "scriptClosure${delegate}" // scriptClosureclosurestudy4@1af2d44a
    // delegate 代表任意对象，默认和owner一致
}
scriptClosure.call()

// Person 定义了一个内部类
class Person {
    def classClosure = {
        println "scriptClosure${this}" //
        // this 代表闭包定义处的类
        println "scriptClosure${owner}" //
        // owner 代表闭包定义处的类或者对象
        println "scriptClosure${delegate}" //
        // delegate 代表任意对象，默认和owner一致
    }

    def say() {
        def classClosure = {
            println "scriptClosure${this}" //
            // this 代表闭包定义处的类
            println "scriptClosure${owner}" //
            // owner 代表闭包定义处的类或者对象
            println "scriptClosure${delegate}" //
            // delegate 代表任意对象，默认和owner一致
        }
        classClosure.call()
    }
}

Person p = new Person();
p.classClosure.call();
p.say();

// 闭包中定义一个闭包
def nestClosure = {
    def innerClosure = {
        println "innerClosure" + this
        // this 代表闭包定义处的类
        println "innerClosure" + owner
        // owner 指向最近的闭包对象
        println "innerClosure" + delegate
        // delegate 代表任意对象，默认和owner一致   如果修改delegate对象 指向的是修改的对象
    }
    // 修改默认的 delegate对象
    innerClosure.delegate = p
    innerClosure.call()
}
nestClosure.call()

/**
 * 闭包的委托策略
 */

class Student {
    String name
    def pretty = { "my name is ${name}" }

    String toString() {
        pretty.call()
    }
}

class Teacher {
    String name;
}

def stu = new Student(name: "tom")
def tea = new Teacher(name: "sun")
println stu.toString()
stu.pretty.delegate = tea // my name is tom
stu.pretty.resolveStrategy = Closure.DELEGATE_FIRST // 修改delegate策略
println stu.toString() // my name is sun

