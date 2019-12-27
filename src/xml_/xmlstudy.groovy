package xml_

final String xml = '''
    <response version-api="2.0">
        <value>
            <books id="1" classification="android"> 
                <book available="20" id="1">
                    <title>疯狂Android讲义</title>
                    <author id="1">李刚</author>
                </book>
                <book available="14" id="2">
                    <title>第一行代码</title>
                    <author id="2">郭林</author>
                </book>
                <book available="13" id="3">  
                    <title>Android开发艺术探索</title>
                    <author id="3">任玉刚</author>
                </book>
            </books>
            <books id="1" classification="android"> 
                <book available="20" id="1">
                    <title>Vue讲义</title>
                    <author id="1">李刚</author>
                </book>
                <book available="14">
                    <title>第一行代码</title>
                    <author id="2">郭林</author>
                </book>
                <book available="13" id="3">  
                    <title>Android开发艺术探索</title>
                    <author id="3">任玉刚</author>
                </book>
            </books>
        </value>
    </response>
    '''

// 开始解析xml数据
def xmlSlurper = new XmlSlurper()
def response = xmlSlurper.parseText(xml)
// 获取文本
println response.value.books[0].book[0].title.text() // 疯狂Android讲义
println response.value.books[0].book[0].author.text() // 李刚
// 获取标签对应的属性
println response.value.books[1].book[1].@available //14

//===xml查询==//
def list = []
response.value.books.each { books ->
    // 对书进行遍历
    books.book.each { book ->
        def author = book.author.text()
        if (author == "李刚") {
            list.add(book.title.text())
        }
    }
}
println list.toListString() // [疯狂Android讲义, Vue讲义]

// groovy 深度遍历
def titles = response.depthFirst().findAll { book ->
    (book.author.text() == "李刚")
}.collect { it.title }
println titles // [疯狂Android讲义, Vue讲义]

// groovy 广度遍历
def name = response.value.books.children().findAll {
    node -> node.name() == "book" && node.@id == "2"
}.collect { node -> return node.title.text() }
println name
