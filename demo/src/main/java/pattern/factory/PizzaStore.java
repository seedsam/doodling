package pattern.factory;

public abstract class PizzaStore {

    public Pizza orderPizza(String type) {

        Pizza pizza = new Pizza();

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }

}
