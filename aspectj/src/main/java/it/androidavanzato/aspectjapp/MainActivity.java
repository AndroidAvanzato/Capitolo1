package it.androidavanzato.aspectjapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    public String sayHello() {
        return "Hello, world.";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        System.out.println(sayHello());
    }

    @Override protected void onStart() {
        super.onStart();
    }
}
