package object
/**
 * 1.groovy中默认都是public
 */
class Person implements Action, Serializable {
    String name
    Integer age

    def increaseAge(Integer years) {
        this.name += years
    }

    @Override
    void eat() {

    }

    @Override
    void drink() {

    }

    @Override
    void play() {

    }

    /**
     * 一个方法不存在 调用它作为原方法的代替
     * 不存在methodMissing 调用invokeMethod
     * @param name
     * @param args
     * @return
     */
    @Override
    Object invokeMethod(String name, Object args) {
        return "the method is ${name}, the params is ${args}"
    }

    /**
     * 一个方法不存在 调用它作为原方法的代替 优先调用methodMissing
     * @param name
     * @param args
     * @return
     */
    def methodMissing(String name, Object args) {
        return "the method is ${name} is missing"
    }

}
