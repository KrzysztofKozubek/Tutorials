package designPatterns.creational.abstractFactory;

import designPatterns.creational.abstractFactory.factorys.Factory;
import designPatterns.creational.abstractFactory.factorys.impl.FactoryMagicWeapon;
import designPatterns.creational.abstractFactory.factorys.impl.FactoryWeapon;
import designPatterns.creational.abstractFactory.weapon.WeaponEnum;

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
