package metatest

class AppManager {
    static void init() {
        // 设置metaClass扩展方法可以全局使用
        ExpandoMetaClass.enableGlobally()
        //为第三方类添加方法
        Person.metaClass.static.createPerson = {
            String name, Integer age -> new Person(name: name, age: age)
        }
    }
}
