package com.example.gymprogs2224514;

import androidx.appcompat.app.AppCompatActivity;
import static com.example.gymprogs2224514.WorkoutAbs.launchState;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class WorkoutShoulder extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_shoulder);

        ImageButton backBack = findViewById(R.id.backFromShoulder);
        Button  shoulderStartButt = findViewById(R.id.shoulderStartButt);

        backBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backToMainActivity();
            }
        });

        shoulderStartButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               GoToWorkoutShoulderTimer();
            }
        });
    }

    public void backToMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void GoToWorkoutShoulderTimer() {
        Intent intent = new Intent(this,WorkoutAbsTimer.class);
        launchState = 6;
        startActivity(intent);
    }
}