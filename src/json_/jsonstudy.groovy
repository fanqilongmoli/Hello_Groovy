package json_

import groovy.json.JsonOutput
import groovy.json.JsonSlurper
import object.Person

def list = [new Person(name: "tom", age: 25), new Person(name: "jack", age: 26)]

def json = JsonOutput.toJson(list)
println json
println JsonOutput.prettyPrint(json)// 输出带格式json字符串

def jsonSlurper = new JsonSlurper()
println jsonSlurper.parseText(json);

//======================//
def response = getNetWorkData("https://jsonplaceholder.typicode.com/posts")
println response

static def getNetWorkData(String url){
    def connection = new URL(url).openConnection()
    connection.setRequestMethod('GET')
    connection.connect()
    def response = connection.content.text
    println JsonOutput.prettyPrint(response)
    // 将json转换成实体对象
    def jsonSlurper = new JsonSlurper()
    return jsonSlurper.parseText(response)
}