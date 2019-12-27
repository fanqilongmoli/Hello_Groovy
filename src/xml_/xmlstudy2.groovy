package xml_

import groovy.xml.MarkupBuilder

/**
 * 生成xml
 */

/**
 * <langs type='current' count='3' mainstream='true'>
 *   <language flavor='static' version='1.5'>Java</language>
 *   <language flavor='dynamic' version='1.6'>Groovy</language>
 *   <language flavor='dynamic' version='1.9'>JavaScript</language>
 * </langs>
 */

def sw = new StringWriter()
def xmlBuilder = new MarkupBuilder(sw) // 用来生成xml数据的核心类
// 根节点 langs创建成功
xmlBuilder.langs(type: 'current', count: '3', mainstream: 'true') {
    // 创建language子节点
    language(flavor: 'static', version: '1.5') {
        name('Java')
        age('16')
    }
    language(flavor: 'dynamic', version: '1.6', 'Groovy') {
        name('Groovy')
        age('10')
    }
    language(flavor: 'dynamic', version: '1.9', 'JavaScript')
}
println sw
// 打印
// <langs type='current' count='3' mainstream='true'>
//  <language flavor='static' version='1.5'>
//    <name>Java</name>
//    <age>16</age>
//  </language>
//  <language flavor='dynamic' version='1.6'>Groovy
//    <name>Groovy</name>
//    <age>10</age>
//  </language>
//  <language flavor='dynamic' version='1.9'>JavaScript</language>
//</langs>


//=============使用对象封装xml数据================//
class langs {
    String type = 'current'
    int count = 3
    boolean mainstream = true

    def languages = [new language(flavor: 'static', version: '1.5', value: 'Java'),
                     new language(flavor: 'dynamic', version: '1.6', value: 'Groovy'),
                     new language(flavor: 'dynamic', version: '1.9', value: 'JavaScript')]
}

class language {
    String flavor
    String version
    String value

}
// 根据对象动态生成xml
def sw2 = new StringWriter()
def langs = new langs();
def xmlBuilder2 = new MarkupBuilder(sw2);
xmlBuilder2.langs(type: langs.type, count: langs.count, mainstream: langs.mainstream) {
    langs.languages.each { lang ->
        language(flavor: lang.flavor, version: lang.version, lang.value)
    }
}
println sw2
// 打印
// <langs type='current' count='3' mainstream='true'>
//  <language flavor='static' version='1.5'>Java</language>
//  <language flavor='dynamic' version='1.6'>Groovy</language>
//  <language flavor='dynamic' version='1.9'>JavaScript</language>
//</langs>
