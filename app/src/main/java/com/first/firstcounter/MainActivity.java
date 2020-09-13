package com.first.firstcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnStart_onClick(View view) {
        Intent i = new Intent(this, com.first.firstcounter.ModeSelectActivity.class);
        startActivity(i);
    }
}
