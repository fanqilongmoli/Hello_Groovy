package file_

def file = new File('../../Hello_Groovy.iml')
//file.eachLine { line ->
//    println line
//}

def text = file.getText()
println text

def readLines = file.readLines()
println readLines

// 读取部分文件  前一百个字符
def reader = file.withReader { reader ->
    char[] buffer = new char[100]
    reader.read(buffer)
    return buffer
}
println reader

def copy(String sourcePath, String destPath) {
    try {
        // 创建目标文件
        def destFile = new File(destPath)
        if (!destFile.exists()) {
            destFile.createNewFile()
        }
        // 开始copy
        new File(sourcePath).withReader { reader ->
            def lines = reader.readLines()
            destFile.withWriter { writer ->
                lines.each { line ->
                    writer.append(line + "\r\n")
                }
            }
        }
    } catch (Exception e) {
        e.printStackTrace()
    }
}

def result = copy('../../Hello_Groovy.iml', '../../Hello_Groovy2.iml')
println result