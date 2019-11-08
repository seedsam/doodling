package pattern.decorator;

public class Soy extends CondimentDecorator {

    public Soy(Beverage beverage) {
        super.beverage = beverage;
    }

    public String getDescription() {
        return beverage.getDescription() + ", Soy";
    }

    @Override
    public double cost() {
        return 0.68 + beverage.cost();
    }
}
