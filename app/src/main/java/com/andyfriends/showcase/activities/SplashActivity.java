package com.andyfriends.showcase.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * First screen the user will always see, but
 *  it needs to appear just enough time to open the MainActivity
 *
 *  You don`t wanna do anything time consuming here
 */
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /** START - this is the purpose of this Activity */
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
        /** END - everything more than this is time consuming */
    }
}
