package KI305RomaniukLab6;

import java.util.ArrayList;
import java.util.List;

/**
 * Клас, що представляє валізу.
 */
public class Valise<T extends Item> {
    private List<T> items;
    List<String> names;

    public Valise() {
        items = new ArrayList<>();
        names = new ArrayList<>();
    }

    public List<String> getListOfNames() {
        return names;
    }

    public void addItem(T item) {
        items.add(item);
        names.add(item.getName());
    }

    public void removeItem(int index) {
        if (index >= 0 && index < items.size()) {
            names.remove(items.get(index).getName());
            items.remove(index);
        }
    }

    /**
     * Пошук мінімального предмета в валізі.
     *
     *
     * @return Мінімальний предмет в валізі.
     */
    public T findMinItem(boolean b) {
        if (!items.isEmpty()) {
            T minItem = items.get(0);
            for (T item : items) {
                if (item.compareTo(minItem) < 0) {
                    minItem = item;
                }
            }
            return minItem;
        }
        return null;

    }
}
