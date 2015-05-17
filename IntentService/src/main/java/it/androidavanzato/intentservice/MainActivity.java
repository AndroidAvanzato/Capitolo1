package it.androidavanzato.intentservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;


public class MainActivity extends ActionBarActivity {

    private final BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override public void onReceive(Context context, Intent intent) {
            updateProgress(intent.getExtras().getInt("progress"));
        }
    };

    private ProgressBar progress;

    private Button goButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progress = (ProgressBar) findViewById(R.id.progress);
        goButton = (Button) findViewById(R.id.go_button);
    }

    private void updateProgress(int progressStep) {
        if (progressStep == 10) {
            goButton.setEnabled(true);
            progress.setVisibility(View.GONE);
        } else {
            goButton.setEnabled(false);
            progress.setVisibility(View.VISIBLE);
            progress.setProgress(progressStep);
        }
    }

    @Override protected void onStart() {
        super.onStart();
        LocalBroadcastManager.getInstance(this).registerReceiver(receiver, new IntentFilter(DownloaderService.EVENT_NAME));
    }

    @Override protected void onStop() {
        super.onStop();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(receiver);
    }

    public void start(View view) {
        updateProgress(0);
        startService(new Intent(this, DownloaderService.class));
    }
}
