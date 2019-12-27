package file_

import object.Person

/**
 * 保存对象到文件
 * @param object
 * @param destPath
 * @return
 */
def saveObject(Object object, String destPath) {
    try {
        // 创建目标文件
        def destFile = new File(destPath)
        if (!destFile.exists()) {
            destFile.createNewFile()
        }
        destFile.withObjectOutputStream { out ->
            out.writeObject(object)
        }
        return true
    } catch (Exception e) {
        e.printStackTrace()
    }
    return false
}

/**
 * 读取文件中为对象
 * @param path
 * @return
 */
def readObject(String path) {
    def obj = null
    try {
        def file = new File(path)
        if (file == null || !file.exists()) return null
        // 从文件中读取对象
        file.withObjectInputStream { input ->
            obj = input.readObject()
        }
    } catch (Exception e) {
        e.printStackTrace()
    }
    return obj
}

def person = new Person(name: 'hahah', age: 26)
//saveObject(person,'../../person.bin')
def result = readObject('../../person.bin') as Person
println "name: ${result.name}; age: ${result.age}"