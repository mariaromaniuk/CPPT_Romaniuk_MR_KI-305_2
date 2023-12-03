package Ki305.Romaniuk.Lab4;

import java.util.Scanner;
import java.io.*;
import static java.lang.System.out;

public class EquationsApp {

    public static void main(String[] args) {
        try {
            out.print("Enter file name: ");
            Scanner in = new Scanner(System.in);
            String fName = in.nextLine();
            PrintWriter fout = new PrintWriter(new File(fName));
            try {
                Equations eq = new Equations();
                out.print("Enter X: ");
                int x = in.nextInt();
                double result = eq.calculate(x);
                fout.print(result);
            } catch (Exception e) {
                out.println(e.getMessage());
            } finally {
                fout.flush();
                fout.close();
            }
        }
        catch (Exception ex) {
            out.print("Exception");
        }
    }
}

class CalcException extends ArithmeticException {

    public CalcException() {
    }

    public CalcException(String cause) {
        super(cause);
    }
}

class Equations {
    public double calculate(int x) {
        double y = 0, rad;
        rad = 4 * x * Math.PI / 180.0; // Обчислення кута в радіанах
        try {
            if (x > 120) throw new CustomException2();
            else if (x > 100) throw new CustomException1();
            else if (x > 80) throw new ArrayIndexOutOfBoundsException("ArrayIndexOutOfBoundsException was thrown");

        } catch (CustomException1 | CustomException2 | ArrayIndexOutOfBoundsException ex) {
            out.println("One of CustomException1 | CustomException2 | ArrayIndexOutOfBoundsException\n" + ex.getMessage());
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

class CustomException1 extends CalcException {
    public CustomException1() {
        super("Custom exception1: X має бути меншим за 100");
    }

    public CustomException1(String message) {
        super(message);
    }
}
/**
 * Другий власний виняток (Custom Exception 2).
 */
class CustomException2 extends CalcException {
    public CustomException2() {
        super("Custom exception2: X має бути меншим за 120");
    }

    public CustomException2(String message) {
        super(message);
    }
}