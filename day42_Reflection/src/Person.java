public class Person {
    private String name;
    public int age;

    /**
     * 
     */
    public Person() {
    }

    /**
     * @param name
     */
    private Person(String name) {
        this.name = name;
    }

    /**
     * @param name
     * @param age
     */
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */

    @Override
    public String toString() {
        return "Person [age=" + age + ", name=" + name + "]";
    }

    public void show() {
        System.out.println("Hello, I'm a Person.");
    }
    
    private String showNation(String nation) {
        System.out.println("I'm nation is: " + nation);
        return nation;
    }
}
