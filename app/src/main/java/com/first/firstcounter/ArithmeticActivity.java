package com.first.firstcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import data.GameArithmetic;
import data.GameSetting;

public class ArithmeticActivity extends AppCompatActivity {

    GameSetting gameSetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arithmetic);
         gameSetting = (GameSetting)getIntent().getSerializableExtra("gameSetting");
    }

    public void btnBackButton_onClick(View view) {
        finish();
    }

    public void btnPlusButton_onClick(View view) {
        Intent i = new Intent(this, DifficultySelectActivity.class);
        gameSetting.setGameArithmetic(GameArithmetic.OnlyPlus);
        i.putExtra("gameSetting", gameSetting);
        startActivity(i);
    }

    public void btnMinusButton_onClick(View view) {
        Intent i = new Intent(this, DifficultySelectActivity.class);
        gameSetting.setGameArithmetic(GameArithmetic.OnlyMinus);
        i.putExtra("gameSetting", gameSetting);
        startActivity(i);
    }

    public void btnPlusMinusButton_onClick(View view) {
        Intent i = new Intent(this, DifficultySelectActivity.class);
        gameSetting.setGameArithmetic(GameArithmetic.PlusMinus);
        i.putExtra("gameSetting", gameSetting);
        startActivity(i);
    }

    public void btnDivisionButton_onClick(View view) {
        Intent i = new Intent(this, DifficultySelectActivity.class);
        gameSetting.setGameArithmetic(GameArithmetic.OnlyDiv);
        i.putExtra("gameSetting", gameSetting);
        startActivity(i);
    }

    public void btnPMDButton_onClick(View view) {
        Intent i = new Intent(this, DifficultySelectActivity.class);
        gameSetting.setGameArithmetic(GameArithmetic.PlusMinusDiv);
        i.putExtra("gameSetting", gameSetting);
        startActivity(i);
    }
}
