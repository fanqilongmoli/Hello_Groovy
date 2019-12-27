package metatest

class Entry {

    static void main(def args) {
        println "应用程序正在启动..."
        // 初始化
        AppManager.init()
        println "应用程序初始化完成"

        def person = PersonManager.createPerson("hahah", 111)
        println "name: ${person.name};age: ${person.age}"
    }

}
