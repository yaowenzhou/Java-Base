public class PersonTest {
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.name = "xiaoyao";
        System.out.println(p1.name);
        p1.eat();
    }
}

class Person {
    // field
    String name;
    int age;
    boolean isMale;

    // method
    public void eat() {
        System.out.println("eating...");
    }

    public void sleep() {
        System.out.println("sleeping...");
    }

    public void talk() {
        System.out.println("talking...");
    }
}
