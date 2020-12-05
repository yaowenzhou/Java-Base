package AnimalTest;

public class AnimalTest {
    public static void main(String[] args) {
        AnimalTest test = new AnimalTest();
        test.test(new Dog());
        test.test(new Cat());
    }

    public void test(Animal animal) {
        animal.eat();
        animal.shout();
        System.out.println("weight: " + animal.weight);
    }
}

class Animal {
    public double weight = 2;

    public void eat() {
        System.out.println("eating...");
    }

    public void shout() {
        System.out.println("shouting...");
    }
}

class Dog extends Animal {
    public double weight = 10;

    @Override
    public void eat() {
        System.out.println("Eating bone...");
    }

    @Override
    public void shout() {
        System.out.println("Shouting: wang!wang!wang!");
    }
}

class Cat extends Animal {
    public double weight = 5;

    @Override
    public void eat() {
        System.out.println("Eating fish...");
    }

    @Override
    public void shout() {
        System.out.println("Shouting: miao!miao!miao!");
    }

}