package designPatterns.structural.abstractFactory.factorys.impl;

import designPatterns.structural.abstractFactory.factorys.Factory;
import designPatterns.structural.abstractFactory.weapon.Weapon;
import designPatterns.structural.abstractFactory.weapon.WeaponEnum;
import designPatterns.structural.abstractFactory.weapon.standard.impl.Pistol;
import designPatterns.structural.abstractFactory.weapon.standard.impl.Shotgun;

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
