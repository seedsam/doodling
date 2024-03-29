package pattern.strategy;

public class MallardDuck extends Duck {

    public MallardDuck() {
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }

    @Override
    void display() {
        System.out.println("I'm a real Mallard duck");
    }

    @Override
    void setFlyBehavior() {

    }

    @Override
    void setQuackBeahvior() {

    }
}
