package SuperTest;

public class Person {
    String name;
    int age;
    int id = 1001;// 身份证号

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
        System.out.println("我无处不在...");
        this.name = "xiaoyao";
        this.age = 25;
    }

    public Person(String name) {
        this.name = name;
        this.age = 25;
    }

    public Person(int age) {
        this.name = "xiaoyao";
        this.age = age;
    }

    public void eat() {
        System.out.println("Eating...");
    }

    public void walk() {
        System.out.println("Walking...");
    }
}
