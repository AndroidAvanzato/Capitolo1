package it.androidavanzato.intentservice;

import android.app.IntentService;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;

public class DownloaderService extends IntentService {

    public static final String EVENT_NAME = "download";
    public static final String PROGRESS = "progress";

    public DownloaderService() {
        super("DownloaderService");
    }

    @Override protected void onHandleIntent(Intent intent) {
        for (int i = 0; i < 10; i++) {
            System.out.println("Step " + i);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Intent resIntent = new Intent(EVENT_NAME);
            resIntent.putExtra(PROGRESS, i + 1);
            LocalBroadcastManager.getInstance(this).sendBroadcast(resIntent);
        }
    }
}
