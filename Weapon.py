# Модуль Weapon.py - базовий клас "Автомат"

class Weapon:
    def __init__(self, name, caliber, fire_rate, magazine_capacity=30):
        """
        Конструктор базового класу "Автомат"

        :param name: Назва автомата
        :param caliber: Калібр автомата
        :param fire_rate: Швидкість стрільби (кількість пострілів за секунду)
        :param magazine_capacity: Ємність магазину (за замовчуванням 30 набоїв)
        """
        self.name = name
        self.caliber = caliber
        self.fire_rate = fire_rate
        self.magazine_capacity = magazine_capacity
        self.ammo_in_magazine = magazine_capacity
        self.full_auto = False  # Режим стрільби (автоматичний/одиночний)

    def fire(self):
        """
        Метод виконує постріл і виводить інформацію про нього.
        """
        if self.full_auto:
            print(f"{self.name} стріляє автоматично!")
        else:
            if self.ammo_in_magazine > 0:
                print(f"{self.name} пострілив калібром {self.caliber} зі швидкістю {self.fire_rate} пострілів за секунду.")
                self.ammo_in_magazine -= 1
            else:
                print(f"Магазин {self.name} порожній! Потрібна перезарядка.")

    def reload(self):
        """
        Метод виконує перезарядку автомата.
        """
        print(f"{self.name} перезаряджається...")
        self.ammo_in_magazine = self.magazine_capacity
        print(f"Магазин {self.name} повністю заряджений!")

    def toggle_fire_mode(self):
        """
        Метод змінює режим стрільби (автоматичний або одиночний).
        """
        self.full_auto = not self.full_auto
        mode = "автоматичний" if self.full_auto else "одиночний"
        print(f"{self.name} переключено в режим стрільби {mode}.")

    def get_ammo(self):
        """
        Метод повертає кількість набоїв у магазині.
        """
        return self.ammo_in_magazine

    def get_info(self):
        """
        Метод повертає інформацію про зброю.
        """
        return f"Зброя: {self.name}, Калібр: {self.caliber}, Швидкість стрільби: {self.fire_rate}, Кількість набоїв: {self.get_ammo()}"
