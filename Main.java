import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * Головний клас програми для генерації та відображення матриці із заповненими символами.
 */
public class Main {

    // Мінімальний розмір матриці
    private static final int MIN_MATRIX_SIZE = 3;

    // Ім'я файлу для збереження результату
    private static final String OUTPUT_FILE = "Result.txt";

    /**
     * Головний метод програми.
     *
     * @param args Аргументи командного рядка (не використовуються).
     */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in);
             BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE))) {

            // Отримуємо розмір матриці від користувача
            int size = getInputSize(scanner);

            // Отримуємо символ для заповнення матриці від користувача
            String fillCharacter = getInputFillCharacter(scanner);


            // Генеруємо матрицю та виводимо її на екран
            char[][] matrix = generateMatrix(size, fillCharacter);

            for (int i_ = 0; i_ < matrix.length; i_++) {
                for (int j_ = 0; j_ < matrix[i_].length; j_++) {
                    if (j_ == 0 )  {
                        matrix[i_][j_] = 'g';
                    }
                    double border_of_upper_trianle = matrix.length % 2 == 0 ? Math.ceil(matrix.length / 2) -1: Math.ceil(matrix.length / 2);
                    if (j_ == matrix[i_].length - 1 && (i_ == matrix.length-1||i_ == border_of_upper_trianle)) {
                        matrix[i_][j_] = 'g';
                    }

                }
            }

            displayMatrix(matrix);

            writeMatrixToRandomAccessFile(matrix);
            readMatrixFromRandomAccessFile();

            // Зберігаємо матрицю в файл
            saveMatrixToFile(matrix, writer);

        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }

    /**
     * Отримує від користувача розмір матриці.
     *
     * @param scanner Об'єкт Scanner для введення користувача.
     * @return Розмір матриці.
     */
    private static int getInputSize(Scanner scanner) {
        // Отримуємо від користувача розмір матриці, перевіряючи введений тип даних та обмеження.
        int size = 0;
        while (true) {
            try {
                System.out.print("Enter size: ");
                size = scanner.nextInt();
                if (size <= MIN_MATRIX_SIZE) {
                    System.out.println("The size of the matrix must be greater than " + MIN_MATRIX_SIZE);
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.nextLine(); // Consume the invalid input
            }
        }
        return size;
    }

    /**
     * Отримує від користувача символ для заповнення матриці.
     *
     * @param scanner Об'єкт Scanner для введення користувача.
     * @return Символ для заповнення матриці.
     */
    private static String getInputFillCharacter(Scanner scanner) {
        // Отримуємо від користувача символ для заповнення матриці, перевіряючи його довжину.
        String fillCharacter;

        while (true) {
            System.out.print("Enter fill character: ");
            fillCharacter = scanner.next();
            if (fillCharacter.length() != 1) {
                System.out.println("Fill character must be a single character.");
            } else {
                break;
            }
        }
        return fillCharacter;
    }



    /**
     * Генерує матрицю із заповненими символами на основі введених даних.
     *
     * @param size             Розмір матриці.
     * @param fillCharacter    Символ для заповнення матриці.
     * @return Згенерована матриця.
     */
    private static char[][] generateMatrix(int size, String fillCharacter) {
        // Ініціалізуємо матрицю та заповнюємо її символами на основі введених даних.
        char[][] matrix = new char[size][];
        int ceil = (int) Math.ceil(size / 2.0);
        for (int i = 0; i < ceil; i++) {
            matrix[i] = new char[i + 1];
            Arrays.fill(matrix[i], fillCharacter.charAt(0));
            if (size % 2 != 0) {
                int floor = (int) Math.floor(size / 2.0);
                matrix[i + floor] = new char[i];
                Arrays.fill(matrix[i + floor], fillCharacter.charAt(0));
            } else {
                matrix[i + ceil] = new char[i + 1];
                Arrays.fill(matrix[i + ceil],  fillCharacter.charAt(0));
            }
        }
        return matrix;
    }

    /**
     * Відображає матрицю на екрані.
     *
     * @param matrix Матриця для відображення.
     */
    private static void displayMatrix(char[][] matrix) {
        // Відображаємо матрицю на екрані, додаючи відступи для коректного відображення.
        for (int i = 0; i < matrix.length; i++) {
            if (i >= (int) Math.ceil(matrix.length / 2.0)) {
                for (int k = (int) Math.ceil(matrix.length / 2.0); k != 0; k--) {
                    System.out.print("8\t");
                }
            }
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
                System.out.print("\t");
            }
            System.out.println("");
        }
    }

    /**
     * Зберігає матрицю у файл.
     *
     * @param matrix Матриця для збереження.
     * @param writer Об'єкт BufferedWriter для запису у файл.
     * @throws IOException Виникає, якщо сталася помилка при записі у файл.
     */
    private static void saveMatrixToFile(char[][] matrix, BufferedWriter writer) throws IOException {
        // Зберігаємо матрицю у файл, додаючи відступи для коректного відображення.
        for (int i = 0; i < matrix.length; i++) {
            if (i >= (int) Math.ceil(matrix.length / 2.0)) {
                for (int k = (int) Math.ceil(matrix.length / 2.0); k != 0; k--) {
                    writer.write("\t");
                }
            }
            for (int j = 0; j < matrix[i].length; j++) {
                writer.write(matrix[i][j]);
                writer.write("\t");
            }
            writer.newLine();
        }
        writer.flush();
        System.out.println("Matrix saved to " + OUTPUT_FILE);
    }

    private static void writeMatrixToRandomAccessFile(char[][] matrix) throws IOException {

        RandomAccessFile f = new RandomAccessFile("RandomAccessFile.txt", "rw");

        for (int i = matrix.length / 2; i <= matrix.length - 1; i++) {
            char[] chars = matrix[i];
            for (int j = 0; j < matrix.length / 2; j++) {
                f.write((byte) '8');
                f.write((byte) '\t');
            }
            for (char c : chars) {
                f.write((byte) c);
                f.write((byte) '\t');
            }

            if (i == matrix.length) f.write('g');
            f.write('\n');
        }
        f.close();
    }

    private static void readMatrixFromRandomAccessFile() throws IOException {
        RandomAccessFile f = new RandomAccessFile("RandomAccessFile.txt", "r");

        byte[] buffer = new byte[(int) f.length()];

        f.readFully(buffer);

        String fileContent = new String(buffer, StandardCharsets.UTF_8);
        System.out.println(fileContent);

        f.close();
    }

}
