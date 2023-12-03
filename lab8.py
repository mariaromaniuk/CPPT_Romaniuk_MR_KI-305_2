import os
import struct
import sys
import math


# Функція для запису результату у текстовий файл
def write_result_txt(filename, result):
    # Відкриваємо файл для запису
    with open(filename, 'w') as file:
        # Записуємо результат як текстовий рядок
        file.write(str(result))


# Функція для читання результату з текстового файлу
def read_result_txt(filename):
    result = 0.0
    try:
        if os.path.exists(filename):
            # Відкриваємо файл для читання
            with open(filename, 'r') as file:
                # Зчитуємо текстовий рядок та перетворюємо його в число з плаваючою точкою
                result = float(file.read())
        else:
            raise FileNotFoundError(f"Файл {filename} не знайдено.")
    except FileNotFoundError as e:
        print(e)
    return result


# Функція для запису результату у двійковий файл
def write_result_bin(filename, result):
    # Відкриваємо файл для запису в бінарному режимі
    with open(filename, 'wb') as file:
        # Записуємо результат у форматі двійкового числа з подвійною точністю (double)
        file.write(struct.pack('d', result))


# Функція для читання результату з двійкового файлу
def read_result_bin(filename):
    result = 0.0
    try:
        if os.path.exists(filename):
            # Відкриваємо файл для читання в бінарному режимі
            with open(filename, 'rb') as file:
                # Зчитуємо дані і розпаковуємо їх як double
                result = struct.unpack('d', file.read())[0]
        else:
            raise FileNotFoundError(f"Файл {filename} не знайдено.")
    except FileNotFoundError as e:
        print(e)
    return result


# Функція для обчислення значення y = tg(4x) / x
def calculate_y(x):
    try:
        # Обчислюємо y згідно варіанту
        y = math.tan(4 * x) / x
        return y
    except ZeroDivisionError:
        print("Помилка: Ділення на нуль. x не може дорівнювати 0.")


if __name__ == "__main__":
    data = float(input("Введіть значення x: "))

    # Обчислення результату за заданим варіантом
    result = calculate_y(data)

    print(f"Результат обчислення: {result}")

    try:
        # Запис результату у текстовий та двійковий файли
        write_result_txt("text_result.txt", result)
        write_result_bin("binary_result.dat", result)

        # Читання результату з файлів та виведення на екран
        print("Результат зчитано з бінарного файлу: {0}".format(read_result_bin("binary_result.dat")))
        print("Результат зчитано з текстового файлу: {0}".format(read_result_txt("text_result.txt")))
    except FileNotFoundError as e:
        print(e)
        sys.exit(1)
