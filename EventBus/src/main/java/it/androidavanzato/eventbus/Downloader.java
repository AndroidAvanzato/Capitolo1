package it.androidavanzato.eventbus;

import com.squareup.otto.Produce;

public class Downloader {

    private static Downloader instance = new Downloader();

    private int progress;

    private Downloader() {
        MainThreadBus.bus.register(this);
    }

    public static Downloader getInstance() {
        return instance;
    }

    public void download() {
        for (int i = 0; i < 10; i++) {
            progress = i;
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            MainThreadBus.bus.post(i + 1);
        }
    }

    @Produce public Integer getProgress() {
        return progress + 1;
    }
}
