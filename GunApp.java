package KI305RomaniukLab3;

/**
 * Клас-драйвер для демонстрації роботи класу Gun.
 */

public class GunApp {
    public static void main(String[] args) {
        AssaultRifle ak47 = new AssaultRifle("AK-47", 7.62, 30);


        System.out.println("Safety is ON");
        ak47.toggleSafety();
        System.out.println("Safety is OFF");
        ak47.toggleSafety();

        System.out.println("Loading ammunition...");
        ak47.loadAmmunition(10);

        System.out.println("Firing...");
        ak47.fire();
        ak47.fire();
        ak47.fire();

        System.out.println("Loading more ammunition...");
        ak47.loadAmmunition(20);

        System.out.println("Firing...");
        ak47.fire();

        ak47.closeLogFile();
    }
}


