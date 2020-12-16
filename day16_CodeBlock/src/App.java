public class App {
    public static void main(String[] args) throws Exception {
        Person p1 = new Person();
        System.out.println(Person.desc);
        System.out.println(p1.age);
    }
}

// 由父及子，静态先行
class Person {
    String name;
    int age;
    static String desc = "I'm a person";

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Code blocks can only be decorated with static
    // static code block
    static {
        System.out.println("static code block is executed");
        desc = "This is a new description which is reassignment in static code block...";
    }
    // non-static code block
    // it will be executed before constructor
    {
        System.out.println("non-static code block is executed");
        age = 10;
    }

}