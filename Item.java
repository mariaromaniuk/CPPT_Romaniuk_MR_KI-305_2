package KI305RomaniukLab6;

/**
 * Клас, що представляє предмет.
 */
public abstract class Item implements Comparable<Item> {
    private String name;
    private double weight;

    public Item(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public int compareTo(Item o) {
        return Double.compare(this.weight, o.weight);
    }

    /**
     * Абстрактний метод для отримання опису предмета.
     *
     * @return Опис предмета.
     */
    public abstract String getDescription();
}
