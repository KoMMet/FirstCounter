package com.first.firstcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import data.GameDifficulty;
import data.GameSetting;

public class DifficultySelectActivity extends AppCompatActivity {

    GameSetting gameSetting;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficulty_select);
        gameSetting = (GameSetting)getIntent().getSerializableExtra("gameSetting");
    }

    public void btnBackButton_onClick(View view) {
        finish();
    }

    public void btnEasyButton_onClick(View view) {
        Intent i = new Intent(this, GameLimitTimeActivity.class);
        gameSetting.setGameDifficulty(GameDifficulty.Easy);
        i.putExtra("gameSetting", gameSetting);
        startActivity(i);
    }

    public void btnNormalButton_onClick(View view) {
        Intent i = new Intent(this, GameLimitTimeActivity.class);
        gameSetting.setGameDifficulty(GameDifficulty.Normal);
        i.putExtra("gameSetting", gameSetting);
        startActivity(i);
    }

    public void btnDifficultyButton_onClick(View view) {
        Intent i = new Intent(this, GameLimitTimeActivity.class);
        gameSetting.setGameDifficulty(GameDifficulty.Difficult);
        i.putExtra("gameSetting", gameSetting);
        startActivity(i);
    }
}
