package com.example.throwback;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class FinalGameStatistics extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_game_statistics);

        TextView viewTotalAnswers = findViewById(R.id.finalTotalAnswers);
        viewTotalAnswers.setText(Integer.toString(MainActivity.TOTAL_ANSWERS));

        TextView viewCorrectAnswers = findViewById(R.id.finalCrrectAnswers);
        viewCorrectAnswers.setText(Integer.toString(MainActivity.NUMBER_CORRECT_ANSWERS));

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(FinalGameStatistics.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        }, MainActivity.TIME_SHOW_FINAL_STATISTICS);
    }
}
