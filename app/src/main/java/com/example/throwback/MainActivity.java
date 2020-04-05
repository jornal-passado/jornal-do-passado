package com.example.throwback;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static final int TOTAL_NUMBER_QUESTIONS_PER_GAME = 4;
    public static final int TIME_SHOW_CORRECT_ANSWER = 4000;
    public static final int TIME_SHOW_FINAL_STATISTICS = 4000;
    public static final int NUMBER_MAXIMUM_HELP = 2;

    public static int NUMBER_CORRECT_ANSWERS;
    public static int TOTAL_ANSWERS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NUMBER_CORRECT_ANSWERS = 0;
        TOTAL_ANSWERS = 0;
    }

    /** Called when the user taps the Start Game button */
    public void startGame(View view) {
        Intent intent = new Intent(this, QuestionActivity.class);
        startActivity(intent);
    }
}
