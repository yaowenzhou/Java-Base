/* JavaBean是一种Java语言写成的可重用组件
 * 所谓JavaBean是指符合如下标准的Java类：
 *  > 类是公共的
 *  > 有一个无参的公共构造器
 *  > 有属性，且有对应的get/set方法
 */

public class Person {
    private String name;
    private int id;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person() {
    }

    public Person(int id, int age) {
        this.id = id;
        this.age = age;
    }
}
