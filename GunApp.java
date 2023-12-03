package KI305RomaniukLab2;
import java.util.ArrayList;
import java.util.List;
/**
 * Клас-драйвер для демонстрації роботи класу Gun.
 */

public class GunApp {
    public static void main(String[] args) {
        Gun ak47 = new Gun("AK-47", 7.61, 30);
        Gun ak48 = new Gun("AK-48", 7.62, 31);
        main1();
        Gun ak50 = new Gun("AK-50", 7.63, 33);
        Gun ak49 = new Gun("AK-49", 7.64, 32);

        System.out.println(Gun.getListOfEvenMagGuns());

        System.out.println(Gun.getMaxCaliber());

        /*System.out.println("Safety is ON");
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

        ak47.closeLogFile();*/
    }
    public static void main1() {
        Gun ak47 = new Gun("AK-51", 7.65, 34);
        Gun ak48 = new Gun("AK-52", 7.66, 35);
    }
}


