package com.example.gymprogs2224514;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class WorkoutAbs extends AppCompatActivity {

    Button startAbsWorkoutButt1;
    public static int launchState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_abs);

        ImageButton backAbs = findViewById(R.id.backFromAbs);
        startAbsWorkoutButt1 = findViewById(R.id.absStartButt);

        backAbs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backToMainActivity();
            }
        });

        startAbsWorkoutButt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               GoToWorkoutAbsTimer1();
            }
        });
    }

    public void backToMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void GoToWorkoutAbsTimer1() {
        Intent intent = new Intent(this, WorkoutAbsTimer.class);
        launchState = 1;
        startActivity(intent);
    }
}
