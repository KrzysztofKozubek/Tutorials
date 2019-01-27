package designPatterns.structural.abstractFactory.factorys.impl;

import designPatterns.structural.abstractFactory.factorys.Factory;
import designPatterns.structural.abstractFactory.weapon.Weapon;
import designPatterns.structural.abstractFactory.weapon.WeaponEnum;
import designPatterns.structural.abstractFactory.weapon.magic.impl.MagicPistol;
import designPatterns.structural.abstractFactory.weapon.magic.impl.MagicShotgun;

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
