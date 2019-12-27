def name = 'a single \'a\' string'
println name.class // println  class java.lang.String  定义的是一个java中的String

def thName = '''
three single string
第二行
第三行
'''
println thName.class
println thName
// println =>three single string
//           第二行
//           第三行
// println =>class java.lang.String

// 单引号 定义的字符串无法定义格式 需要拼接转义

def doubleName = "this a comm string"
println doubleName // this a comm string
println doubleName.class // class java.lang.String

// 双引号可以进行变量拼接  变量的类型是GString
// 如果没有进行变量的拼接  变量的类型是String
def threeName = "hello ${name}"
println threeName // hello a single 'a' string
println threeName.class // class org.codehaus.groovy.runtime.GStringImpl

def sum = "3+2=${3 + 2}" //可以扩展任意的表达式
println sum // 3+2=5

/*==============字符串的操作方法==================*/

println "/*==============字符串的操作方法==================*/"

def str = "groovy"
println str.center(8,"a") // agroovya
println str.padLeft(8,"a") // aagroovy
println str.padRight(8,"a") // groovyaa

def str2 = "hello"
println str > str2 // false

println str[0] // g
println str[0..1] // gr













