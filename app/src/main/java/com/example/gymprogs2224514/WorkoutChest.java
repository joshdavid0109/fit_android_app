package com.example.gymprogs2224514;

import androidx.appcompat.app.AppCompatActivity;
import static com.example.gymprogs2224514.WorkoutAbs.launchState;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class WorkoutChest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_chest);

        ImageButton backBack = findViewById(R.id.backFromChest);
        Button chestStartButt = findViewById(R.id.chestStartButt);

        backBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backToMainActivity();
            }
        });

        chestStartButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GoToWorkoutChestTimer();
            }
        });
    }

    public void backToMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void GoToWorkoutChestTimer() {
        Intent intent = new Intent(this, WorkoutAbsTimer.class);
        launchState = 4;
        startActivity(intent);
    }
}