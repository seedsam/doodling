package pattern.strategy;

public abstract class Duck {

    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public void swim() {
        System.out.println("All ducks float,even decoys!");
    }

    abstract void display();

    public void performQuack() {
        quackBehavior.quack();
    }

    void performFly() {
        flyBehavior.fly();
    }

    abstract void setFlyBehavior();

    abstract void setQuackBeahvior();
    // 鸭子的其他行为 ......
}
