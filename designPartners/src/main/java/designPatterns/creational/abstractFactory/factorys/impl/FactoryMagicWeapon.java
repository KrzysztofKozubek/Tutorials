package designPatterns.creational.abstractFactory.factorys.impl;

import designPatterns.creational.abstractFactory.factorys.Factory;
import designPatterns.creational.abstractFactory.weapon.Weapon;
import designPatterns.creational.abstractFactory.weapon.WeaponEnum;
import designPatterns.creational.abstractFactory.weapon.magic.impl.MagicPistol;
import designPatterns.creational.abstractFactory.weapon.magic.impl.MagicShotgun;

public class FactoryMagicWeapon implements Factory {
    @Override
    public Weapon createWeapon(WeaponEnum drink) {
        switch (drink) {
            case PISTOL:
                return new MagicPistol();
            case SHOTGUN:
                return new MagicShotgun();
        }
        return null;
    }
}
