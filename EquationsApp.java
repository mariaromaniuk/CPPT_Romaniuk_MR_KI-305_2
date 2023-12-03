package KI305RomaniukLab5;

import java.io.*;

/**
 * Клас EquationsApp є програмою-драйвером для обчислення виразу y = tg(4x) / x та запису результату в файл.
 * Користувач вводить ім'я файлу та значення X, програма обчислює результат та записує його в файл у текстовому і двійковому форматах.
 */
public class EquationsApp {

    /**
     * Головний метод програми, який виконує основну логіку.
     * @param args Аргументи командного рядка (не використовуються).
     */
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            // Запит ім'я файлу виводу
            System.out.print("Enter output file name: ");
            String fileName = reader.readLine();

            // Запит значення X
            System.out.print("Enter X: ");
            int x = Integer.parseInt(reader.readLine());

            Equations eq = new Equations();
            double result = eq.calculate(x);

            // Запис результату у текстовий файл
            ResultIO.writeTextResult(fileName + ".txt", result);

            // Запис результату у двійковий файл
            ResultIO.writeBinaryResult(fileName + ".dat", result);

            System.out.println("Results have been written to files.");
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        } catch (CalcException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

/**
 * Клас CalcException є підкласом ArithmeticException і використовується для обробки помилок обчислення виразу.
 */
class CalcException extends ArithmeticException {

    /**
     * Конструктор без параметрів.
     */
    public CalcException() {
    }

    /**
     * Конструктор з параметром, який приймає причину помилки.
     * @param cause Причина помилки.
     */
    public CalcException(String cause) {
        super(cause);
    }
}

/**
 * Клас Equations реалізує метод для обчислення виразу y = tg(4x) / x.
 */
class Equations {

    /**
     * Метод обчислює вираз y = tg(4x) / x.
     * @param x Кут в градусах.
     * @return Результат обчислення виразу.
     * @throws CalcException Виняток, який виникає при некоректних обчисленнях.
     */
    public double calculate(int x) throws CalcException {
        double y, rad;
        rad = 4 * x * Math.PI / 180.0; // Обчислення кута в радіанах
        try {
            y = Math.tan(rad) / x; // Обчислення tg(4x) / x
            if (Double.isNaN(y) || Double.isInfinite(y) || x == 0) {
                throw new ArithmeticException();
            }
        } catch (ArithmeticException ex) {
            if (rad == Math.PI / 2.0 || rad == -Math.PI / 2.0) {
                throw new CalcException("Exception reason: Illegal value of X for tangent calculation");
            } else if (x == 0) {
                throw new CalcException("Exception reason: X = 0");
            } else {
                throw new CalcException("Unknown reason of the exception during exception calculation");
            }
        }
        return y;
    }
}

/**
 * Клас ResultIO реалізує методи для читання/запису результатів роботи класу Equations у текстовому і двійковому форматах.
 */
class ResultIO {

    // Метод для запису результату у текстовий файл
    public static void writeTextResult(String fileName, double result) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            writer.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Метод для читання результату з текстового файлу
    public static double readTextResult(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = reader.readLine();
            if (line != null) {
                return Double.parseDouble(line);
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return 0.0; // За замовчуванням, якщо читання не вдалося
    }

    // Метод для запису результату у двійковий файл
    public static void writeBinaryResult(String fileName, double result) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
            dos.writeDouble(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Метод для читання результату з двійкового файлу
    public static double readBinaryResult(String fileName) {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
            return dis.readDouble();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0.0; // За замовчуванням, якщо читання не вдалося
    }
}
