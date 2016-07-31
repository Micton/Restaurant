package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.Tablet;

import java.io.IOException;
import java.util.List;

public class Order {

    private List<Dish> dishes;
    private Tablet tablet;

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        this.dishes = ConsoleHelper.getAllDishesForOrder();
    }

    public List<Dish> getSelectedDishes() {
        return dishes;
    }

    public void setSelectedDishes(List<Dish> selectedDishes) {
        this.dishes = selectedDishes;
    }

    public Tablet getTablet() {
        return tablet;
    }

    public void setTablet(Tablet tablet) {
        this.tablet = tablet;
    }

    @Override
    public String toString() {
        if (dishes == null || dishes.isEmpty()) {
            return "";
        } else {
            return "Your order: " + dishes.toString() + " of " + tablet;
        }
    }

    public int getTotalCookingTime() {
        int result = 0;
        List<Dish> dishes = getSelectedDishes();
        for (Dish dish : dishes) {
            result += dish.getDuration();
        }
        return result;
    }

    public boolean isEmpty() {
        return dishes.isEmpty();
    }
}
