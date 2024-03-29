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
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Field;

public class MainActivity extends AppCompatActivity {

    private Button btn_quiz_result;
    private CheckBox option_4_a, option_4_b, option_4_c, option_4_d;
    private CheckBox option_5_a, option_5_b, option_5_c, option_5_d;
    private EditText editText_sixth_ans;
    private EditText editText_seventh_ans;
    private EditText editText_eighth_ans;
    private RadioButton option_1_c;
    private RadioButton option_2_a;
    private RadioButton option_3_c;
    private ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        findAllViews();

        checkFifthOption();
    }

    private void findAllViews() {
        btn_quiz_result = findViewById(R.id.id_btn_quiz_result);
        editText_sixth_ans = findViewById(R.id.id_et_ans_sixth);
        editText_seventh_ans = findViewById(R.id.id_et_ans_seventh);
        editText_eighth_ans = findViewById(R.id.id_et_ans_eighth);
        option_1_c = findViewById(R.id.id_rb_opt_1_c);
        option_2_a = findViewById(R.id.id_rb_opt_2_a);
        option_3_c = findViewById(R.id.id_rb_opt_3_c);
        option_4_a = findViewById(R.id.id_cb_opt_4_a);
        option_4_b = findViewById(R.id.id_cb_opt_4_b);
        option_4_c = findViewById(R.id.id_cb_opt_4_c);
        option_4_d = findViewById(R.id.id_cb_opt_4_d);
        option_5_a = findViewById(R.id.id_cb_opt_5_a);
        option_5_b = findViewById(R.id.id_cb_opt_5_b);
        option_5_c = findViewById(R.id.id_cb_opt_5_c);
        option_5_d = findViewById(R.id.id_cb_opt_5_d);
        scrollView = findViewById(R.id.scroll_view);
    }

    /**
     *  This is button click method to show quiz result.
     */
    public void quizResultButton(View view) {
        int quizScore = calcQuizScore();
        String customMsg = "Your score is " + quizScore + "/40";
        String thankYou = "Thanks for participation.";
        cToastShort(customMsg);
        cToastShort(thankYou);

        btn_quiz_result.setText(R.string.txt_press_back_exit);
        btn_quiz_result.setEnabled(false);
        scrollView.setVisibility(View.GONE);
    }

    private int calcQuizScore() {
        int totalScored = 0;
        String ansSixth = "Imageview, Textview And Button";
        String ansSeventh = "Integrated Development Environment";
        String ansEighth = "Kotlin";
        String getAnsSixth = editText_sixth_ans.getText().toString();
        String getAnsSeventh = editText_seventh_ans.getText().toString();
        String getAnsEighth = editText_eighth_ans.getText().toString();

        if (option_1_c.isChecked()) {
            totalScored += 5;
        }

        if (option_2_a.isChecked()) {
            totalScored += 5;
        }

        if (option_3_c.isChecked()) {
            totalScored += 5;
        }

        if (option_4_a.isChecked()&&option_4_c.isChecked()&&option_4_d.isChecked()) {
            totalScored += 5;
        }

        if (option_5_a.isChecked()&&option_5_b.isChecked()&&option_5_c.isChecked()) {
            totalScored += 5;
        }

        if (getAnsSixth.equals(ansSixth)) {
            totalScored += 5;
        }

        if (getAnsSeventh.equals(ansSeventh)) {
            totalScored += 5;
        }

        if (getAnsEighth.equals(ansEighth)) {
            totalScored += 5;
        }
        return totalScored;
    }

    private void checkFifthOption() {
        option_5_a.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (option_5_a.isChecked()) {
                    option_5_d.setChecked(false);
                }
            }
        });
        option_5_b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (option_5_b.isChecked()) {
                    option_5_d.setChecked(false);
                }
            }
        });
        option_5_c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (option_5_c.isChecked()) {
                    option_5_d.setChecked(false);
                }
            }
        });
        option_5_d.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (option_5_d.isChecked()) {
                    option_5_a.setChecked(false);
                    option_5_b.setChecked(false);
                    option_5_c.setChecked(false);
                }
            }
        });
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
