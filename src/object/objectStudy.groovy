package object

def person = new Person(name: "hahha", age: 26)
person.increaseAge(10)
println "name = ${person.name};age = ${person.age}" // name = hahha;age = 26

// 使用metaClass 为类动态添加一个属性
Person.metaClass.sex = "男"
def person2 = new Person(name: "hahha", age: 26)
println person2.sex // 男
person2.sex = "女"
println person2.sex // 女

// 使用metaClass 为类动态添加方法
Person.metaClass.sexUpperCase = { -> sex + ":动态添加的方法" }
def person3 = new Person(name: "hahha", age: 26)
println person3.sexUpperCase() // 男:动态添加的方法

// 使用metaClass 为类动态添加静态方法
Person.metaClass.static.createPerson = {
    String name, Integer age -> new Person(name: name, age: age)
}
def person4 = Person.createPerson("静态创建name",122)
println person4.name // 静态创建name