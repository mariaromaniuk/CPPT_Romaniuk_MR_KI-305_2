package KI305RomaniukLab2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Клас, що представляє гвинтівку в предметній області.
 */
public class Gun {
    private Long id;
    private String model;
    private double caliber;
    private boolean safetyOn;
    private int ammunitionCount;
    private FileWriter logFile;

    private static List<Long> listOfEvenMagGuns = new ArrayList<>();
    private static long idCounter = 0;

    private static double maxCaliber = 0;

    /**
     * Конструктор класу Gun.
     *
     * @param model     Модель гвинтівки.
     * @param caliber   Калібр гвинтівки.
     */
    public Gun(String model, double caliber) {
        this.id = idCounter++;
        this.model = model;
        this.caliber = caliber;
        this.safetyOn = true;
        this.ammunitionCount = 0;

        if(maxCaliber < caliber) {
            maxCaliber = caliber;
        }

        listOfEvenMagGuns.add(this.id);

        try {
            this.logFile = new FileWriter("gun_log.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Конструктор класу Gun з вказаною кількістю набоїв.
     *
     * @param model             Модель гвинтівки.
     * @param caliber           Калібр гвинтівки.
     * @param ammunitionCount   Початкова кількість набоїв.
     */
    public Gun(String model, double caliber, int ammunitionCount) {
        this.id = idCounter++;
        this.model = model;
        this.caliber = caliber;
        this.safetyOn = true;
        this.ammunitionCount = ammunitionCount;

        if(maxCaliber < caliber) {
            maxCaliber = caliber;
        }

        if (ammunitionCount % 2 == 0) listOfEvenMagGuns.add(this.id);

        try {
            this.logFile = new FileWriter("gun_log.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static double getMaxCaliber() {
        return maxCaliber;
    }

    /**
     * Завантажує набої в гвинтівку.
     *
     * @param bullets Кількість набоїв для завантаження.
     */
    public void loadAmmunition(int bullets) {
        if (!safetyOn) {
            ammunitionCount += bullets;
            log("Loaded " + bullets + " bullets. Total ammunition: " + ammunitionCount);
        } else {
            log("Cannot load ammunition with safety on.");
        }
    }

    /**
     * Виконує вистріл з гвинтівки.
     */
    public void fire() {
        if (!safetyOn && ammunitionCount > 0) {
            log("Fired one round. Ammunition left: " + --ammunitionCount);
        } else if (safetyOn) {
            log("Cannot fire with safety on.");
        } else {
            log("Out of ammunition.");
        }
    }

    /**
     * Увімкнути або вимкнути безпеку на гвинтівці.
     */
    public void toggleSafety() {
        safetyOn = !safetyOn;
        if (safetyOn) {
            log("Safety is on.");
        } else {
            log("Safety is off.");
        }
    }

    // Приватний метод для ведення журналу подій.
    private void log(String message) {
        try {
            logFile.write(message + "\n");
            logFile.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Закрити файл журналу.
     */
    public void closeLogFile() {
        try {
            logFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Отримати кількість набоїв.
     *
     * @return Кількість набоїв.
     */
    public int getAmmunitionCount() {
        return ammunitionCount;
    }

    public String getModel() {
        return model;
    }

    public static List<Long> getListOfEvenMagGuns() {
        return new ArrayList<>(listOfEvenMagGuns);
    }
}