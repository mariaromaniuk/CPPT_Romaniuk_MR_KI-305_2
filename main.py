# Модуль Main.py - точка входу в програму

from Weapon import Weapon
from AssaultRifle import AssaultRifle

if __name__ == "__main__":
    ak47 = AssaultRifle("AK-47", "7.62x39mm", 600)
    ak47.toggle_fire_mode()
    ak47.fire()
    ak47.fire()
    ak47.reload()
    ak47.launch_grenade()
    ak47.attach_grenade_launcher()
    ak47.launch_grenade()

    print(ak47.get_info())

    m16 = AssaultRifle("M16", "5.56x45mm", 700)
    m16.toggle_fire_mode()
    m16.fire()
    m16.reload()

    print(m16.get_info())