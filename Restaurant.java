package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.kitchen.Waitor;

import java.io.IOException;

public class Restaurant {

    public static void main(String[] args) throws IOException {
        Waitor waitor = new Waitor();
        Cook cook = new Cook("Jonny");
        cook.addObserver(waitor);
        Tablet tablet = new Tablet(5);
        tablet.addObserver(cook);
        tablet.createOrder();
        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();
    }
}


