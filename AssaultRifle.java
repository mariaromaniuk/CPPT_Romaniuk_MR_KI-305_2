package KI305RomaniukLab3;

// Імпортуємо інші необхідні пакети

public class AssaultRifle extends Gun implements ASSaultWeapon {

    // Конструктор для штурмової гвинтівки
    public AssaultRifle(String model, double caliber, int ammunitionCount) {
        super(model, caliber, ammunitionCount);
    }

    @Override
    public void shoot() {
        if (!isSafetyOn() && getAmmunitionCount() > 0) {
            log("Firing the assault rifle...");
            super.fire();
        } else if (isSafetyOn()) {
            log("Cannot fire the assault rifle with safety on.");
        } else {
            log("Out of ammunition for the assault rifle.");
        }
    }

    @Override
    public void throwFlashbang() {
        if (getAmmunitionCount() > 0) {
            log("Кидаю флешбенг!");
        } else {
            log("Немає флешбенгів у амуніції.");
        }
    }
    }

