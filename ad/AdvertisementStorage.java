package com.javarush.test.level27.lesson15.big01.ad;

import java.util.ArrayList;
import java.util.List;

class AdvertisementStorage {

    private static AdvertisementStorage instance;
    private final List<Advertisement> videos = new ArrayList<>();

    private AdvertisementStorage() {
        Object someContent = new Object();
        add(new Advertisement(someContent, "First Video 3 min", 5000, 100, 3 * 60));
        add(new Advertisement(someContent, "Second Video 15 min", 100, 10, 15 * 60));
        add(new Advertisement(someContent, "Third Video 10 min", 400, 2, 10 * 60));
        add(new Advertisement(someContent, "Fifth Video 10 min", 402, 2, 10 * 60));
        add(new Advertisement(someContent, "Fourth Video 7 min", 800, 4, 7 * 60));
        add(new Advertisement(someContent, "First Video 3 min", 5100, 100, 3 * 60));
        add(new Advertisement(someContent, "First Video 2 min", 3000, 100, 2 * 60));
        add(new Advertisement(someContent, "First Video 2 min", 3000, 100, 2 * 60));
        add(new Advertisement(someContent, "First Video 4 min", 5100, 100, 4 * 60));
    }

    public static AdvertisementStorage getInstance() {
        if (instance == null) {
            instance = new AdvertisementStorage();
        }
        return instance;
    }

    public List<Advertisement> list() {
        return videos;
    }

    public void add(Advertisement advertisement) {
        videos.add(advertisement);
    }
}
