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

    private CheckBox checkBoxOption1a, checkBoxOption1b, checkBoxOption1c, checkBoxOption1d;
    private CheckBox checkBoxOption2a, checkBoxOption2b, checkBoxOption2c, checkBoxOption2d;
    private CheckBox checkBoxOption3a, checkBoxOption3b, checkBoxOption3c, checkBoxOption3d;
    private CheckBox checkBoxOption4a, checkBoxOption4b, checkBoxOption4c, checkBoxOption4d;
    private CheckBox checkBoxOption5a, checkBoxOption5b, checkBoxOption5c, checkBoxOption5d;
    private Button btnQuizResult;
    private int totalScore = 0;
    Resources resources;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        resources = getResources();
        int display_mode = resources.getConfiguration().orientation;
        if (display_mode == Configuration.ORIENTATION_LANDSCAPE) {
            if (getSupportActionBar() != null) {
                getSupportActionBar().hide();

                setContentView(R.layout.activity_home);

                findViewResources();
            }
        }
        else {
            setContentView(R.layout.activity_home);

            findViewResources();
            checkBoxOption5a.setSelected(true);
            checkBoxOption5b.setSelected(true);
            checkBoxOption5c.setSelected(true);
            checkBoxOption5d.setSelected(true);
        }
    }

    public void findViewResources() {
        btnQuizResult = findViewById(R.id.id_btn_show_score);

        checkBoxOption1a = findViewById(R.id.option_1_a);
        checkBoxOption1b = findViewById(R.id.option_1_b);
        checkBoxOption1c = findViewById(R.id.option_1_c);
        checkBoxOption1d = findViewById(R.id.option_1_d);
        checkBoxOption2a = findViewById(R.id.option_2_a);
        checkBoxOption2b = findViewById(R.id.option_2_b);
        checkBoxOption2c = findViewById(R.id.option_2_c);
        checkBoxOption2d = findViewById(R.id.option_2_d);
        checkBoxOption3a = findViewById(R.id.option_3_a);
        checkBoxOption3b = findViewById(R.id.option_3_b);
        checkBoxOption3c = findViewById(R.id.option_3_c);
        checkBoxOption3d = findViewById(R.id.option_3_d);
        checkBoxOption4a = findViewById(R.id.option_4_a);
        checkBoxOption4b = findViewById(R.id.option_4_b);
        checkBoxOption4c = findViewById(R.id.option_4_c);
        checkBoxOption4d = findViewById(R.id.option_4_d);
        checkBoxOption5a = findViewById(R.id.option_5_a);
        checkBoxOption5b = findViewById(R.id.option_5_b);
        checkBoxOption5c = findViewById(R.id.option_5_c);
        checkBoxOption5d = findViewById(R.id.option_5_d);
    }

    /**
     * This method will calculate Total Score of Quiz.
     */
    protected int calculateScore() {
        if (checkBoxOption1d.isChecked())
            totalScore += 2;

        if (checkBoxOption2a.isChecked())
            totalScore += 2;

        if (checkBoxOption3c.isChecked())
            totalScore += 2;

        if (checkBoxOption4b.isChecked())
            totalScore += 2;

        if (checkBoxOption5d.isChecked())
            totalScore += 2;

        return totalScore;
    }
    /**
     * This method called when SHOW SCORE button is clicked
     */
    public void showScore(View view) {
        totalScore = calculateScore();
        int MAXSCORE = 10;
        String scoreText = "";
        if (totalScore == 10)
            scoreText = resources.getString(R.string.text_total_score, getString(R.string.extraordinary), totalScore, MAXSCORE);
        else if (totalScore == 8)
            scoreText = resources.getString(R.string.text_total_score, getString(R.string.excellent), totalScore, MAXSCORE);
        else if (totalScore == 6)
            scoreText = resources.getString(R.string.text_total_score, getString(R.string.very_good), totalScore, MAXSCORE);
        else if (totalScore == 4)
            scoreText = resources.getString(R.string.text_total_score, getString(R.string.good), totalScore, MAXSCORE);
        else if (totalScore == 2)
            scoreText = resources.getString(R.string.text_total_score, getString(R.string.hmm), totalScore, MAXSCORE);
        else if (totalScore == 0)
            scoreText = resources.getString(R.string.text_total_score, getString(R.string.ops), totalScore, MAXSCORE);

        myToastLong(scoreText);
        myToastLong(getString(R.string.thanks_4_participate));
        myToastShort(getString(R.string.visit_again));
        btnQuizResult.setBackgroundResource(R.drawable.button_selector_disabled);
        btnQuizResult.setTextColor(resources.getColor(R.color.colorPrimary));
        btnQuizResult.setEnabled(false);

        sleep(10000);
        }

    /**
     * This method is called when CHECKBOX click event happens.
     */
    public void optionsEvent(View view) {
        switch (view.getId()) {
            case R.id.option_1_a:
                quesOneClickableCheck(false, true, true, true, true, false, false, false);
                break;

            case R.id.option_1_b:
                quesOneClickableCheck(true, false, true, true, false, true, false, false);
                break;

            case R.id.option_1_c:
                quesOneClickableCheck(true, true, false, true, false, false, true, false);
                break;

            case R.id.option_1_d:
                quesOneClickableCheck(true, true, true, false, false, false, false, true);
                break;

            case R.id.option_2_a:
                quesTwoClickableCheck(false, true, true, true, true, false, false, false);
                break;

            case R.id.option_2_b:
                quesTwoClickableCheck(true, false, true, true, false, true, false, false);
                break;

            case R.id.option_2_c:
                quesTwoClickableCheck(true, true, false, true, false, false, true, false);
                break;

            case R.id.option_2_d:
                quesTwoClickableCheck(true, true, true, false, false, false, false, true);
                break;

            case R.id.option_3_a:
                quesThreeClickableCheck(false, true, true, true, true, false, false, false);
                break;

            case R.id.option_3_b:
                quesThreeClickableCheck(true, false, true, true, false, true, false, false);
                break;

            case R.id.option_3_c:
                quesThreeClickableCheck(true, true, false, true, false, false, true, false);
                break;

            case R.id.option_3_d:
                quesThreeClickableCheck(true, true, true, false, false, false, false, true);
                break;

            case R.id.option_4_a:
                quesFourClickableCheck(false, true, true, true, true, false, false, false);
                break;

            case R.id.option_4_b:
                quesFourClickableCheck(true, false, true, true, false, true, false, false);
                break;

            case R.id.option_4_c:
                quesFourClickableCheck(true, true, false, true, false, false, true, false);
                break;

            case R.id.option_4_d:
                quesFourClickableCheck(true, true, true, false, false, false, false, true);
                break;

            case R.id.option_5_a:
                quesFiveClickableCheck(false, true, true, true, true, false, false, false);
                break;

            case R.id.option_5_b:
                quesFiveClickableCheck(true, false, true, true, false, true, false, false);
                break;

            case R.id.option_5_c:
                quesFiveClickableCheck(true, true, false, true, false, false, true, false);
                break;

            case R.id.option_5_d:
                quesFiveClickableCheck(true, true, true, false, false, false, false, true);
                break;
        }
    }

    public void quesOneClickableCheck(boolean mClickable1, boolean mClickable2, boolean mClickable3, boolean mClickable4, boolean mCheck1, boolean mCheck2, boolean mCheck3, boolean mCheck4) {
        checkBoxOption1a.setClickable(mClickable1);
        checkBoxOption1b.setClickable(mClickable2);
        checkBoxOption1c.setClickable(mClickable3);
        checkBoxOption1d.setClickable(mClickable4);
        checkBoxOption1a.setChecked(mCheck1);
        checkBoxOption1b.setChecked(mCheck2);
        checkBoxOption1c.setChecked(mCheck3);
        checkBoxOption1d.setChecked(mCheck4);
    }

    public void quesTwoClickableCheck(boolean mClickable1, boolean mClickable2, boolean mClickable3, boolean mClickable4, boolean mCheck1, boolean mCheck2, boolean mCheck3, boolean mCheck4) {
        checkBoxOption2a.setClickable(mClickable1);
        checkBoxOption2b.setClickable(mClickable2);
        checkBoxOption2c.setClickable(mClickable3);
        checkBoxOption2d.setClickable(mClickable4);
        checkBoxOption2a.setChecked(mCheck1);
        checkBoxOption2b.setChecked(mCheck2);
        checkBoxOption2c.setChecked(mCheck3);
        checkBoxOption2d.setChecked(mCheck4);
    }

    public void quesThreeClickableCheck(boolean mClickable1, boolean mClickable2, boolean mClickable3, boolean mClickable4, boolean mCheck1, boolean mCheck2, boolean mCheck3, boolean mCheck4) {
        checkBoxOption3a.setClickable(mClickable1);
        checkBoxOption3b.setClickable(mClickable2);
        checkBoxOption3c.setClickable(mClickable3);
        checkBoxOption3d.setClickable(mClickable4);
        checkBoxOption3a.setChecked(mCheck1);
        checkBoxOption3b.setChecked(mCheck2);
        checkBoxOption3c.setChecked(mCheck3);
        checkBoxOption3d.setChecked(mCheck4);
    }

    public void quesFourClickableCheck(boolean mClickable1, boolean mClickable2, boolean mClickable3, boolean mClickable4, boolean mCheck1, boolean mCheck2, boolean mCheck3, boolean mCheck4) {
        checkBoxOption4a.setClickable(mClickable1);
        checkBoxOption4b.setClickable(mClickable2);
        checkBoxOption4c.setClickable(mClickable3);
        checkBoxOption4d.setClickable(mClickable4);
        checkBoxOption4a.setChecked(mCheck1);
        checkBoxOption4b.setChecked(mCheck2);
        checkBoxOption4c.setChecked(mCheck3);
        checkBoxOption4d.setChecked(mCheck4);
    }

    public void quesFiveClickableCheck(boolean mClickable1, boolean mClickable2, boolean mClickable3, boolean mClickable4, boolean mCheck1, boolean mCheck2, boolean mCheck3, boolean mCheck4) {
        checkBoxOption5a.setClickable(mClickable1);
        checkBoxOption5b.setClickable(mClickable2);
        checkBoxOption5c.setClickable(mClickable3);
        checkBoxOption5d.setClickable(mClickable4);
        checkBoxOption5a.setChecked(mCheck1);
        checkBoxOption5b.setChecked(mCheck2);
        checkBoxOption5c.setChecked(mCheck3);
        checkBoxOption5d.setChecked(mCheck4);
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
}
