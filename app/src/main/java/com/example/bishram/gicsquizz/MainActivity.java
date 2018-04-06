package com.example.bishram.gicsquizz;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Handler;
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

    private CheckBox checkBoxOptionJan1, checkBoxOptionJan21, checkBoxOptionFeb7, checkBoxOptionFeb14;
    private CheckBox checkBoxOption500, checkBoxOption1000, checkBoxOption350, checkBoxOption750;
    private CheckBox checkBoxOption1M, checkBoxOption2M, checkBoxOption3M, checkBoxOption4M;
    private CheckBox checkBoxOption5M, checkBoxOption6M, checkBoxOption7M, checkBoxOption8M;
    private CheckBox checkBoxOptionKuKa, checkBoxOptionKuLy, checkBoxOptionKaLy, checkBoxOptionKuKaLy;
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
            checkBoxOptionKuKa.setSelected(true);
            checkBoxOptionKaLy.setSelected(true);
            checkBoxOptionKuLy.setSelected(true);
            checkBoxOptionKuKaLy.setSelected(true);
        }
    }

    public void findViewResources() {
        btnQuizResult = findViewById(R.id.id_btn_show_score);

        checkBoxOptionJan1 = findViewById(R.id.option_1_a);
        checkBoxOptionJan21 = findViewById(R.id.option_1_b);
        checkBoxOptionFeb7 = findViewById(R.id.option_1_c);
        checkBoxOptionFeb14 = findViewById(R.id.option_1_d);
        checkBoxOption500 = findViewById(R.id.option_2_a);
        checkBoxOption1000 = findViewById(R.id.option_2_b);
        checkBoxOption350 = findViewById(R.id.option_2_c);
        checkBoxOption750 = findViewById(R.id.option_2_d);
        checkBoxOption1M = findViewById(R.id.option_3_a);
        checkBoxOption2M = findViewById(R.id.option_3_b);
        checkBoxOption3M = findViewById(R.id.option_3_c);
        checkBoxOption4M = findViewById(R.id.option_3_d);
        checkBoxOption5M = findViewById(R.id.option_4_a);
        checkBoxOption6M = findViewById(R.id.option_4_b);
        checkBoxOption7M = findViewById(R.id.option_4_c);
        checkBoxOption8M = findViewById(R.id.option_4_d);
        checkBoxOptionKuKa = findViewById(R.id.option_5_a);
        checkBoxOptionKuLy = findViewById(R.id.option_5_b);
        checkBoxOptionKaLy = findViewById(R.id.option_5_c);
        checkBoxOptionKuKaLy = findViewById(R.id.option_5_d);
    }

    /**
     * This method will calculate Total Score of Quiz.
     */
    protected int calculateScore() {
        if (checkBoxOptionFeb14.isChecked())
            totalScore += 1;

        if (checkBoxOption500.isChecked())
            totalScore += 1;

        if (checkBoxOption3M.isChecked())
            totalScore += 1;

        if (checkBoxOption6M.isChecked())
            totalScore += 1;

        if (checkBoxOptionKuKaLy.isChecked())
            totalScore += 1;

        return totalScore;
    }
    /**
     * This method called when SHOW SCORE button is clicked
     */
    public void showScore(View view) {
        totalScore = calculateScore();
        String scoreText = "";
        if (totalScore == 5)
            scoreText = resources.getString(R.string.text_total_score, getString(R.string.extraordinary), totalScore);
        else if (totalScore == 4)
            scoreText = resources.getString(R.string.text_total_score, getString(R.string.excellent), totalScore);
        else if (totalScore == 3)
            scoreText = resources.getString(R.string.text_total_score, getString(R.string.very_good), totalScore);
        else if (totalScore == 2)
            scoreText = resources.getString(R.string.text_total_score, getString(R.string.good), totalScore);
        else if (totalScore == 1)
            scoreText = resources.getString(R.string.text_total_score, getString(R.string.hmm), totalScore);
        else if (totalScore == 0)
            scoreText = resources.getString(R.string.text_total_score, getString(R.string.ops), totalScore);

        myToastLong(scoreText);
        myToastLong(getString(R.string.thanks_4_participate));
        myToastShort(getString(R.string.visit_again));
        btnQuizResult.setVisibility(View.GONE);

        sleep(10000);
        }

    /**
     * This method is called when CHECKBOX click event happens.
     */
    public void optionsEvent(View view) {
        switch (view.getId()) {
            case R.id.option_1_a:
                quesOneEnableCheck(false, true, true, true, true, false, false, false);
                break;

            case R.id.option_1_b:
                quesOneEnableCheck(true, false, true, true, false, true, false, false);
                break;

            case R.id.option_1_c:
                quesOneEnableCheck(true, true, false, true, false, false, true, false);
                break;

            case R.id.option_1_d:
                quesOneEnableCheck(true, true, true, false, false, false, false, true);
                break;

            case R.id.option_2_a:
                quesTwoEnableCheck(false, true, true, true, true, false, false, false);
                break;

            case R.id.option_2_b:
                quesTwoEnableCheck(true, false, true, true, false, true, false, false);
                break;

            case R.id.option_2_c:
                quesTwoEnableCheck(true, true, false, true, false, false, true, false);
                break;

            case R.id.option_2_d:
                quesTwoEnableCheck(true, true, true, false, false, false, false, true);
                break;

            case R.id.option_3_a:
                quesThreeEnableCheck(false, true, true, true, true, false, false, false);
                break;

            case R.id.option_3_b:
                quesThreeEnableCheck(true, false, true, true, false, true, false, false);
                break;

            case R.id.option_3_c:
                quesThreeEnableCheck(true, true, false, true, false, false, true, false);
                break;

            case R.id.option_3_d:
                quesThreeEnableCheck(true, true, true, false, false, false, false, true);
                break;

            case R.id.option_4_a:
                quesFourEnableCheck(false, true, true, true, true, false, false, false);
                break;

            case R.id.option_4_b:
                quesFourEnableCheck(true, false, true, true, false, true, false, false);
                break;

            case R.id.option_4_c:
                quesFourEnableCheck(true, true, false, true, false, false, true, false);
                break;

            case R.id.option_4_d:
                quesFourEnableCheck(true, true, true, false, false, false, false, true);
                break;

            case R.id.option_5_a:
                quesFiveEnableCheck(false, true, true, true, true, false, false, false);
                break;

            case R.id.option_5_b:
                quesFiveEnableCheck(true, false, true, true, false, true, false, false);
                break;

            case R.id.option_5_c:
                quesFiveEnableCheck(true, true, false, true, false, false, true, false);
                break;

            case R.id.option_5_d:
                quesFiveEnableCheck(true, true, true, false, false, false, false, true);
                break;
        }
    }

    public void quesOneEnableCheck(boolean mEnable1, boolean mEnable2, boolean mEnable3, boolean mEnable4, boolean mCheck1, boolean mCheck2, boolean mCheck3, boolean mCheck4) {
        checkBoxOptionJan1.setEnabled(mEnable1);
        checkBoxOptionJan21.setEnabled(mEnable2);
        checkBoxOptionFeb7.setEnabled(mEnable3);
        checkBoxOptionFeb14.setEnabled(mEnable4);
        checkBoxOptionJan1.setChecked(mCheck1);
        checkBoxOptionJan21.setChecked(mCheck2);
        checkBoxOptionFeb7.setChecked(mCheck3);
        checkBoxOptionFeb14.setChecked(mCheck4);
    }

    public void quesTwoEnableCheck(boolean mEnable1, boolean mEnable2, boolean mEnable3, boolean mEnable4, boolean mCheck1, boolean mCheck2, boolean mCheck3, boolean mCheck4) {
        checkBoxOption500.setEnabled(mEnable1);
        checkBoxOption1000.setEnabled(mEnable2);
        checkBoxOption350.setEnabled(mEnable3);
        checkBoxOption750.setEnabled(mEnable4);
        checkBoxOption500.setChecked(mCheck1);
        checkBoxOption1000.setChecked(mCheck2);
        checkBoxOption350.setChecked(mCheck3);
        checkBoxOption750.setChecked(mCheck4);
    }

    public void quesThreeEnableCheck(boolean mEnable1, boolean mEnable2, boolean mEnable3, boolean mEnable4, boolean mCheck1, boolean mCheck2, boolean mCheck3, boolean mCheck4) {
        checkBoxOption1M.setEnabled(mEnable1);
        checkBoxOption2M.setEnabled(mEnable2);
        checkBoxOption3M.setEnabled(mEnable3);
        checkBoxOption4M.setEnabled(mEnable4);
        checkBoxOption1M.setChecked(mCheck1);
        checkBoxOption2M.setChecked(mCheck2);
        checkBoxOption3M.setChecked(mCheck3);
        checkBoxOption4M.setChecked(mCheck4);
    }

    public void quesFourEnableCheck(boolean mEnable1, boolean mEnable2, boolean mEnable3, boolean mEnable4, boolean mCheck1, boolean mCheck2, boolean mCheck3, boolean mCheck4) {
        checkBoxOption5M.setEnabled(mEnable1);
        checkBoxOption6M.setEnabled(mEnable2);
        checkBoxOption7M.setEnabled(mEnable3);
        checkBoxOption8M.setEnabled(mEnable4);
        checkBoxOption5M.setChecked(mCheck1);
        checkBoxOption6M.setChecked(mCheck2);
        checkBoxOption7M.setChecked(mCheck3);
        checkBoxOption8M.setChecked(mCheck4);
    }

    public void quesFiveEnableCheck(boolean mEnable1, boolean mEnable2, boolean mEnable3, boolean mEnable4, boolean mCheck1, boolean mCheck2, boolean mCheck3, boolean mCheck4) {
        checkBoxOptionKuKa.setEnabled(mEnable1);
        checkBoxOptionKuLy.setEnabled(mEnable2);
        checkBoxOptionKaLy.setEnabled(mEnable3);
        checkBoxOptionKuKaLy.setEnabled(mEnable4);
        checkBoxOptionKuKa.setChecked(mCheck1);
        checkBoxOptionKuLy.setChecked(mCheck2);
        checkBoxOptionKaLy.setChecked(mCheck3);
        checkBoxOptionKuKaLy.setChecked(mCheck4);
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
