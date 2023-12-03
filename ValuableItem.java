package KI305RomaniukLab6;

/**
 * Підклас для цінного предмета.
 */
public class ValuableItem extends Item {
    private double value;

    public ValuableItem(String name, double weight, double value) {
        super(name, weight);
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    @Override
    public String getDescription() {
        return "Предмет: " + getName() + " (вага: " + getWeight() + " кг, вартість: " + value + " грн)";
    }
}
