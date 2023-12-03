package KI305RomaniukLab3;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Абстрактний клас, що представляє гвинтівку в предметній області.
 */
public abstract class Gun {
    private String model;
    private double caliber;
    private boolean safetyOn;
    private int ammunitionCount;
    private FileWriter logFile;

    /**
     * Конструктор класу Gun.
     *
     * @param model     Модель гвинтівки.
     * @param caliber   Калібр гвинтівки.
     */
    public Gun(String model, double caliber) {
        this.model = model;
        this.caliber = caliber;
        this.safetyOn = true;
        this.ammunitionCount = 0;

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
        this(model, caliber);
        this.ammunitionCount = ammunitionCount;
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
    void log(String message) {
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
     * Перевіряє, чи включена безпека на гвинтівці.
     *
     * @return true, якщо безпека увімкнена; false, якщо безпека вимкнена.
     */
    public boolean isSafetyOn() {
        return safetyOn;
    }

    /**
     * Отримати кількість набоїв у гвинтівці.
     *
     * @return Кількість набоїв.
     */
    public int getAmmunitionCount() {
        return ammunitionCount;
    }

    public abstract void shoot();
}
