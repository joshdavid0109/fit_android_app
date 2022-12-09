package com.example.gymprogs2224514;

import androidx.appcompat.app.AppCompatActivity;
import static com.example.gymprogs2224514.WorkoutAbs.launchState;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class WorkoutBack extends AppCompatActivity {

    Button startBackWorkoutButt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_back);

        ImageButton backBack = findViewById(R.id.backFromBack);
        startBackWorkoutButt = findViewById(R.id.startBackWorkout);

        backBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backToMainActivity();
            }
        });

        startBackWorkoutButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               GoToWorkoutTimer();
            }
        });

    }

    public void backToMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void GoToWorkoutTimer() {
        Intent intent = new Intent(this, WorkoutAbsTimer.class);
        launchState = 3;
        startActivity(intent);
    }
}
