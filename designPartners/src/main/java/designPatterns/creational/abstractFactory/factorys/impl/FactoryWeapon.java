package designPatterns.creational.abstractFactory.factorys.impl;

import designPatterns.creational.abstractFactory.weapon.standard.impl.Pistol;
import designPatterns.creational.abstractFactory.factorys.Factory;
import designPatterns.creational.abstractFactory.weapon.Weapon;
import designPatterns.creational.abstractFactory.weapon.WeaponEnum;
import designPatterns.creational.abstractFactory.weapon.standard.impl.Shotgun;

public class FactoryWeapon implements Factory {

    @Override
    public Weapon createWeapon(WeaponEnum drink) {
        switch (drink) {
            case PISTOL:
                return new Pistol();
            case SHOTGUN:
                return new Shotgun();
        }
        return null;
    }
}
