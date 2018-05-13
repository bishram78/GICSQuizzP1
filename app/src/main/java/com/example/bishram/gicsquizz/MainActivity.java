package com.example.bishram.gicsquizz;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Field;

public class MainActivity extends AppCompatActivity {

    private int totalScore = 0;
    Resources resources;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    /**
     * This method will calculate Total Score of Quiz.
     */
    protected int calculateScore() {
        return 0;
    }
    /**
     * This method called when SHOW SCORE button is clicked
     */
    public void quizResultButton(View view) {
        totalScore = calculateScore();

        Button btnQuizResult = findViewById(R.id.id_btn_quiz_result);
        btnQuizResult.setText("Press back to exit");
        btnQuizResult.setTextSize(18);
        btnQuizResult.setBackgroundColor(Color.RED);
        btnQuizResult.setEnabled(false);
        }

    /**
     * These are toast methods
     */
    public void myToastShort(String toastMsg) {
        Toast.makeText(getApplicationContext(), toastMsg, Toast.LENGTH_SHORT).show();
    }
    public void myToastLong(String toastMsg) {
        Toast.makeText(getApplicationContext(), toastMsg, Toast.LENGTH_LONG).show();
    }

    public void sleep(int duration) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
            }
        }, duration);
    }

    public void optionsEvent(View view) {
        switch (view.getId()) {/**
            case R.id.option_1_a:
                myToastShort("Click event carried forward.");
                break;

            case R.id.option_1_b:
                myToastShort("Click event carried forward.");
                break;

            case R.id.option_1_c:
                myToastShort("Click event carried forward.");
                break;

            case R.id.option_1_d:
                myToastShort("Click event carried forward.");
                break;*/
        }
    }
}
