package pattern.decorator;

public abstract class Condiment extends Beverage {

	public abstract String getDescrption();

	public double cost() {
		return 1.99;
	}

}
