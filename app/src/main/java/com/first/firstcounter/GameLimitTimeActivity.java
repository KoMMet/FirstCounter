package com.first.firstcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.TextView;

import java.util.ArrayList;

import data.GameSetting;
import data.PlaySetting;
import data.Problem;
import data.ProblemCreator;

public class GameLimitTimeActivity extends AppCompatActivity {

    GameSetting gameSetting;
    PlaySetting playSetting = new PlaySetting();
    double initcount=1.0;
    TextView initialCounter;
    Handler initialHandler = new Handler();
    Handler gameHandler = new Handler();
    //initTime
    Runnable initRunnable = new Runnable() {
        @Override
        public void run() {
            initcount -= 0.1;
            initialCounter.setText(String.valueOf(initcount).concat("0").substring(0,3));
            initialHandler.postDelayed(this,100);
            if(initcount <= 0)
            {
                initialHandler.removeCallbacks(initRunnable);
                initialCounter.setText(String.valueOf(initcount));
                initLayout.setVisibility(View.GONE);
                gameLayout.setVisibility(View.VISIBLE);
                gameHandler.post(gamerun);
                problem.setText(list.get(currentProblemIndex).getProblemString());

            }
        }
    };

    //GameTime
    Runnable gamerun = new Runnable() {
        @Override
        public void run() {
            limitTime -= 0.1;
            StringBuilder sb = new StringBuilder();
            sb.append(limitTime);
            sb.append("00");
            limitTimerTextView.setText(sb.toString().substring(0,4));
            gameHandler.postDelayed(this, 100);
            if(limitTime <= 0)
            {
                gameHandler.removeCallbacks(gamerun);
                gameLayout.setVisibility(View.GONE);
                resultLayout.setVisibility(View.VISIBLE);
            }
        }
    };

    double limitTime;
    TextView limitTimerTextView;
    View initLayout;
    View gameLayout;
    TextView problem;
    TextView calcResult;
    TextView correctAnswerNumTextView;
    View resultLayout;
    ArrayList<Problem> list;
    int currentProblemIndex;
    int correctAnswerNum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_limittime);
        gameSetting = (GameSetting)getIntent().getSerializableExtra("gameSetting");
        initialCounter = findViewById(R.id.initialCounter);
        initialCounter.setText(String.valueOf(initcount));
        initLayout = findViewById(R.id.initLayout);
        gameLayout = findViewById(R.id.gameLayout);
        limitTimerTextView = findViewById(R.id.limitTimerTextView);
        problem = findViewById(R.id.problem);
        limitTime = playSetting.getLimitTIme();
        limitTimerTextView.setText(String.valueOf(limitTime));
        calcResult = findViewById(R.id.calcResult);
        initialHandler.post(initRunnable);
        ProblemCreator problemCreator = new ProblemCreator(gameSetting, playSetting);
        list = problemCreator.getProblemlist();

        resultLayout = findViewById(R.id.resultLayout);
        correctAnswerNumTextView = findViewById(R.id.correctAnswerNumTextView);

        resultLayout.setTag(resultLayout.getVisibility());
        resultLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                int newVis = resultLayout.getVisibility();
                if((int)resultLayout.getTag() != newVis){
                    resultLayout.setTag(resultLayout.getVisibility());
                    correctAnswerNumTextView.setText(String.valueOf(correctAnswerNum));
                }
            }
        });
    }

    public void btn_7_onClick(View view) {
        boolean correct = ansCheck(7, list.get(currentProblemIndex).getAnswer());
        calcResultView(correct);
        currentProblemIndex++;
        nextProblem();
    }

    public void btn_8_onClick(View view) {
        boolean correct = ansCheck(8, list.get(currentProblemIndex).getAnswer());
        calcResultView(correct);
        currentProblemIndex++;
        nextProblem();

    }

    public void btn_9_onClick(View view) {
        boolean correct = ansCheck(9, list.get(currentProblemIndex).getAnswer());
        calcResultView(correct);
        currentProblemIndex++;
        nextProblem();

    }

    public void btn_4_onClick(View view) {
        boolean correct = ansCheck(4, list.get(currentProblemIndex).getAnswer());
        calcResultView(correct);
        currentProblemIndex++;
        nextProblem();

    }

    public void btn_5_onClick(View view) {
        boolean correct = ansCheck(5, list.get(currentProblemIndex).getAnswer());
        calcResultView(correct);
        currentProblemIndex++;
        nextProblem();

    }

    public void btn_6_onClick(View view) {
        boolean correct = ansCheck(6, list.get(currentProblemIndex).getAnswer());
        calcResultView(correct);
        currentProblemIndex++;
        nextProblem();

    }

    public void btn_1_onClick(View view) {
        boolean correct = ansCheck(1, list.get(currentProblemIndex).getAnswer());
        calcResultView(correct);
        currentProblemIndex++;
        nextProblem();

    }

    public void btn_2_onClick(View view) {
        boolean correct = ansCheck(2, list.get(currentProblemIndex).getAnswer());
        calcResultView(correct);
        currentProblemIndex++;
        nextProblem();

    }

    public void btn_3_onClick(View view) {
        boolean correct = ansCheck(3, list.get(currentProblemIndex).getAnswer());
        calcResultView(correct);
        currentProblemIndex++;
        nextProblem();

    }

    public void btn_0_onClick(View view) {
        boolean correct = ansCheck(0, list.get(currentProblemIndex).getAnswer());
        calcResultView(correct);
        currentProblemIndex++;
        nextProblem();
    }
    private void calcResultView(boolean correct) {
        if(correct)
        {
            calcResult.setTextColor(Color.GREEN);
            calcResult.setText("nice!");
            correctAnswerNum++;
        }
        else
        {
            calcResult.setTextColor(Color.RED);
            calcResult.setText("bad...");
        }
    }

    private void nextProblem() {
        problem.setText(list.get(currentProblemIndex).getProblemString());
    }

    private boolean ansCheck(int i, int answer) {
        return i == answer;
    }

    public void btnBackButton_onClick(View view) {
        finish();
    }
}