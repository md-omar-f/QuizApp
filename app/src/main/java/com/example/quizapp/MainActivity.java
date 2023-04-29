package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView question;
    Button buttonYes, buttonNo, buttonRestart;

    private final String[] questions = {"Was Java invented in 1785?",
            "Is the father of Java Arif?",
            "Dhaka is the capital of Bangladesh.",
            "Argentina is the depending FIFA world cup champion.",
            "Rome was burning while Nero was playing on flute."};
    private final boolean[] answers = {false, false, true, true, true};
    private int scoreCount = 0;
    private int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        question = findViewById(R.id.question);
        buttonYes = findViewById(R.id.buttonYes);
        buttonNo = findViewById(R.id.buttonNo);
        buttonRestart = findViewById(R.id.buttonRestart);

        question.setText(questions[index]);

        buttonYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answers[index]) {
                    ++scoreCount;
                }
                ++index;
                if(index < questions.length) {
                    question.setText(questions[index]);
                } else {
                    onFinish();
                }
            }
        });

        buttonNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!answers[index]) {
                    ++scoreCount;
                }
                ++index;
                if(index < questions.length) {
                    question.setText(questions[index]);
                } else {
                    onFinish();
                }
            }
        });
        buttonRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                index = 0;
                buttonRestart.setVisibility(View.GONE);
                buttonYes.setVisibility(View.VISIBLE);
                buttonNo.setVisibility(View.VISIBLE);
                question.setText(questions[index]);
                scoreCount = 0;
            }
        });
    }
    public void onFinish() {
        buttonYes.setVisibility(View.GONE);
        buttonNo.setVisibility(View.GONE);
        String scoreMessage = "Your score: " + scoreCount;
        question.setText(scoreMessage);
        buttonRestart.setVisibility(View.VISIBLE);
    }
}