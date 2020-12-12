/**
 * @Author       : yaowenzhou
 * @Date         : 2020-12-06 20:14:52
 * @LastEditors  : yaowenzhou
 * @LastEditTime : 2020-12-12 23:10:06
 * @version      : 
 * @Description  : Person 类，用于测试finalize方法
 */
class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // 子类重写此方法，可以在释放对象前进行某些操作，是由其所在的类调用
    @Override
    protected void finalize() throws Throwable {
        System.out.println("对象被释放---->" + this);
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }
}
