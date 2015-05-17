package it.androidavanzato.eventbus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.squareup.otto.Subscribe;

import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


public class MainActivity extends AppCompatActivity {

    private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
    private static final int CORE_POOL_SIZE = CPU_COUNT + 1;
    private static final int MAXIMUM_POOL_SIZE = CPU_COUNT * 2 + 1;

    private static Executor EXECUTOR = new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, 10,
            TimeUnit.SECONDS, new SynchronousQueue<Runnable>());

    private ProgressBar progress;

    private Button goButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progress = (ProgressBar) findViewById(R.id.progress);
        goButton = (Button) findViewById(R.id.go_button);
    }

    @Subscribe public void updateProgress(Integer progressStep) {
        if (progressStep == 10) {
            goButton.setEnabled(true);
            progress.setVisibility(View.GONE);
        } else {
            goButton.setEnabled(false);
            progress.setVisibility(View.VISIBLE);
            progress.setProgress(progressStep);
        }
    }

    @Override protected void onResume() {
        super.onResume();
        MainThreadBus.bus.register(this);
    }

    @Override protected void onPause() {
        super.onPause();
        MainThreadBus.bus.unregister(this);
    }

    public void start(View view) {
        updateProgress(0);
        EXECUTOR.execute(new Runnable() {
            @Override public void run() {
                Downloader.getInstance().download();
            }
        });
    }
}
