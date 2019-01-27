package designPatterns.creational.abstractFactory.factorys;

import designPatterns.creational.abstractFactory.weapon.Weapon;
import designPatterns.creational.abstractFactory.weapon.WeaponEnum;

public interface Factory {
    Weapon createWeapon(WeaponEnum weapon);
}
