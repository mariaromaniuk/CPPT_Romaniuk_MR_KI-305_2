package KI305RomaniukLab6;

public class ValiseDriver {
    public static void main(String[] args) {
        Valise<Item> valise = new Valise<>();

        valise.addItem(new ValuableItem("Дорогий смартфон", 0.2, 12000));
        valise.addItem(new ValuableItem("Планшет", 0.5, 8000));
        valise.addItem(new ValuableItem("Книга 'Java Programming'", 0.5, 500));
        valise.addItem(new ValuableItem("Ноутбук", 3.5, 20000));
        valise.addItem(new ValuableItem("Шампунь", 0.2, 100));
        valise.addItem(new ValuableItem("Щітка для волосся", 0.1, 90));
        valise.addItem(new ValuableItem("Фен", 1.5, 500));
        valise.addItem(new ValuableItem("Фен1", 1.5, 500));
        Item minItem = valise.findMinItem(true);

        if (minItem != null) {
            System.out.println("Мінімальний предмет в валізі: " + minItem.getDescription());
        } else {
            System.out.println("Валіза порожня. Мінімальний предмет не знайдено.");
        }
        System.out.println(valise.getListOfNames());
    }
}
