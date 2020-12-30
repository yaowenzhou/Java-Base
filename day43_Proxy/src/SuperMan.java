public class SuperMan implements Human {

    @Override
    public String getBeief() {
        return "I believe I can fly!";
    }

    @Override
    public void eat(String food) {
        System.out.println("I like " + food + "!");
    }
}
