package pattern.decorator;

public abstract class CondimentDecorator extends Beverage {

    Beverage beverage;

    public abstract double cost();
}
