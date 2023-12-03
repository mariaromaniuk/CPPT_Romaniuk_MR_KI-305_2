# Модуль AssaultRifle.py - похідний клас "Штурмова гвинтівка"

from Weapon import Weapon  # Імпорт базового класу "Автомат"

class AssaultRifle(Weapon):
    def __init__(self, name, caliber, fire_rate, magazine_capacity=30):
        """
        Конструктор похідного класу "Штурмова гвинтівка"

        :param name: Назва автомата
        :param caliber: Калібр автомата
        :param fire_rate: Швидкість стрільби (кількість пострілів за секунду)
        :param magazine_capacity: Ємність магазину (за замовчуванням 30 набоїв)
        """
        super().__init__(name, caliber, fire_rate, magazine_capacity)
        self.grenade_launcher = False  # Наявність гранатомета

    def launch_grenade(self):
        """
        Метод виконує постріл гранатометом, якщо гранатомет є відомої гвинтівці.
        """
        if self.grenade_launcher:
            print(f"{self.name} вистрелив гранатометом!")
        else:
            print(f"{self.name} не має гранатомета!")

    def attach_grenade_launcher(self):
        """
        Метод додає гранатомет до гвинтівки.
        """
        if not self.grenade_launcher:
            self.grenade_launcher = True
            print(f"До {self.name} додано гранатомет!")
        else:
            print(f"{self.name} вже має гранатомет!")
