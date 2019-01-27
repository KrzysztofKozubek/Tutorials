package designPatterns.structural.abstractFactory;

import designPatterns.structural.abstractFactory.factorys.Factory;
import designPatterns.structural.abstractFactory.factorys.impl.FactoryMagicWeapon;
import designPatterns.structural.abstractFactory.factorys.impl.FactoryWeapon;
import designPatterns.structural.abstractFactory.weapon.WeaponEnum;

/*
* Abstract factory is used when
* wanna create objects with few version
* */

public class App {
    public static void main(String[] args) {
        Factory factory = new FactoryWeapon();
        System.out.println(factory.createWeapon(WeaponEnum.PISTOL));
        System.out.println(factory.createWeapon(WeaponEnum.SHOTGUN));
        factory = new FactoryMagicWeapon();
        System.out.println(factory.createWeapon(WeaponEnum.PISTOL));
        System.out.println(factory.createWeapon(WeaponEnum.SHOTGUN));
    }
}
