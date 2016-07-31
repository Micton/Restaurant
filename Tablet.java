package com.javarush.test.level27.lesson15.big01;


import com.javarush.test.level27.lesson15.big01.ad.AdvertisementManager;
import com.javarush.test.level27.lesson15.big01.ad.NoVideoAvailableException;
import com.javarush.test.level27.lesson15.big01.kitchen.Dish;
import com.javarush.test.level27.lesson15.big01.kitchen.Order;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tablet extends Observable {

    private List<Dish> allDishes = new ArrayList<>();
    private Logger logger = Logger.getLogger(Tablet.class.getName());
    private final int number;

    public Tablet(int number) {
        this.number = number;
    }

    public void createOrder() {
        Order order = null;
        try {
            order = new Order(this);
            if (!order.isEmpty()) {
                ConsoleHelper.writeMessage(order.toString());
                AdvertisementManager advertisementManager = new AdvertisementManager(order.getTotalCookingTime() * 60);
                setChanged();
                notifyObservers(order);
                advertisementManager.processVideos();
            }
        } catch (NoVideoAvailableException e) {
            logger.log(Level.INFO, "No video is available for the order " + order);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
        }
    }

    public List<Dish> getAllDishes() {
        return allDishes;
    }

    public void setAllDishes(List<Dish> allDishes) {
        this.allDishes = allDishes;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Tablet{number=" + number + "}";
    }
}
