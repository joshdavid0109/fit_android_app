package com.example.gymprogs2224514;

import androidx.appcompat.app.AppCompatActivity;
import static com.example.gymprogs2224514.WorkoutAbs.launchState;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class WorkoutArms extends AppCompatActivity {

    ImageButton backBack;
    Button startArmButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_arms);

        backBack = findViewById(R.id.backFromArms);
        startArmButton = findViewById(R.id.armsStartButt);

        backBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backToMainActivity();
            }
        });

        startArmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GoToWorkoutArmTimer();
            }
        });
    }

    public void backToMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void GoToWorkoutArmTimer() {
        Intent intent = new Intent(this, WorkoutTimer.class);
        launchState = 2;
        startActivity(intent);
    }


}