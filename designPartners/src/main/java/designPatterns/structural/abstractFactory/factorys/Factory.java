package designPatterns.structural.abstractFactory.factorys;

import designPatterns.structural.abstractFactory.weapon.Weapon;
import designPatterns.structural.abstractFactory.weapon.WeaponEnum;

public interface Factory {
    Weapon createWeapon(WeaponEnum weapon);
}
