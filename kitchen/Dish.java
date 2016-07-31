package com.javarush.test.level27.lesson15.big01.kitchen;

public enum  Dish {

    Fish(25), Steak(30), Soup(15), Juice(5), Water(3);

    private int duration;

    Dish(int duration) {
        this.duration = duration;
    }

    public static String allDishesToString(){
        Dish [] dishes = Dish.values();
        String result = "";
        for (Dish dish : dishes){
            result += dish.toString() + ", ";
        }
        return result.substring(0, result.length() - 2);
    }

    public int getDuration() {
        return duration;
    }
}
