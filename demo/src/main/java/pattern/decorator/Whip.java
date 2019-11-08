package pattern.decorator;

public class Whip extends CondimentDecorator {

    public Whip(Beverage beverage) {
        super.beverage = beverage;
    }

    public String getDescription() {
        return beverage.getDescription() + ", Whip";
    }

    @Override
    public double cost() {
        return 0.58 + beverage.cost();
    }
}
