package SuperTest;

public class Student extends Person {
    String major;
    int id = 1002;// 学号

    public Student() {
    }

    public Student(String major) {
        this.major = major;
    }

    public Student(String name, int age, String major) {
        super(name, age);
        this.major = major;
    }

    @Override
    public void eat() {
        // TODO Auto-generated method stub
        // super.eat();
        System.out.println("学生: 多吃有营养的食物!");
    }

    @Override
    public void walk() {
        // TODO Auto-generated method stub
        super.walk();
    }

    public void study() {
        System.out.println("学生: 学习知识!");
        this.eat();
        super.eat();
        super.walk();
    }

    public void show() {
        System.out.println("name = " + name + ", age = " + age);
        System.out.println("id = " + super.id);
    }

}
