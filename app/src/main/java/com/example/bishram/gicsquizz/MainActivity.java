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
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Field;

public class MainActivity extends AppCompatActivity {

    private RadioButton option_1_a, option_1_b, option_1_c, option_1_d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        findAllViews();
    }

    private void findAllViews() {
//        option_1_a = findViewById(R.id.id_rb_opt_1_a);
//        option_1_b = findViewById(R.id.id_rb_opt_1_b);
        option_1_c = findViewById(R.id.id_rb_opt_1_c);
//        option_1_d = findViewById(R.id.id_rb_opt_1_d);
    }

    /**
     *  This is button click method to show quiz result.
     */
    public void quizResultButton(View view) {
        int quizScore = calcQuizScore();
        String customMsg = "Your score is " + quizScore + "/5";
        String thankYou = "Thanks for participation.";
        cToastShort(customMsg);
        cToastShort(thankYou);
    }

    private int calcQuizScore() {
        int totalScored = 0;

        if (option_1_c.isChecked()) {
            totalScored = totalScored + 5;
        }
        return totalScored;
    }

    /**
     * These are toast methods
     */
    public void cToastShort(String toastMsg) {
        Toast.makeText(getApplicationContext(), toastMsg, Toast.LENGTH_SHORT).show();
    }
    public void cToastLong(String toastMsg) {
        Toast.makeText(getApplicationContext(), toastMsg, Toast.LENGTH_LONG).show();
    }

    public void sleepFor(int duration) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
            }
        }, duration);
    }
}
