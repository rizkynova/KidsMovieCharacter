package com.rizkynova.kidsmoviecharacter.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.database.FirebaseDatabase;
import com.rizkynova.kidsmoviecharacter.R;

public class Splashscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        Thread thread = new Thread(){
            public void run(){
                try {
                    sleep(4000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    startActivity(new Intent(Splashscreen.this, MainActivity.class));
                    finish();
                }
            }
        };
        thread.start();
    }
}