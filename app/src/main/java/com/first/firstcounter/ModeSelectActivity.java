package com.first.firstcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import data.GameArithmetic;
import data.GameMode;
import data.GameSetting;


public class ModeSelectActivity extends AppCompatActivity {

    GameSetting gameSetting;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode_select);

        gameSetting = new GameSetting();
    }

    public void btnBackButton_onClick(View view) {
        finish();
    }

    public void btn_timeLimitModeButton_onClick(View view) {
        Intent i = new Intent(this,com.first.firstcounter.ArithmeticActivity.class);
        gameSetting.setGameMode(GameMode.TimeLimit);
        i.putExtra("gameSetting",gameSetting);
        startActivity(i);
    }

    public void btn_quantityModeButton_onClick(View view) {
        Intent i = new Intent(this,com.first.firstcounter.ArithmeticActivity.class);
        gameSetting.setGameMode(GameMode.Quantity);
        i.putExtra("gameSetting", gameSetting);
        startActivity(i);
    }
}
