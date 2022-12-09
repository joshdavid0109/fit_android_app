package com.example.gymprogs2224514;

import androidx.appcompat.app.AppCompatActivity;
import static com.example.gymprogs2224514.WorkoutAbs.launchState;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class WorkoutLegs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_legs);
        ImageButton backBack = findViewById(R.id.backFromLegs);
        Button legsStartButt = findViewById(R.id.legsStartButt);

        backBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backToMainActivity();
            }
        });

       legsStartButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GoToWorkoutLegsTimer();
            }
        });
    }

    public void backToMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void GoToWorkoutLegsTimer() {
        Intent intent = new Intent(this, WorkoutTimer.class);
        launchState = 5;
        startActivity(intent);
    }
}