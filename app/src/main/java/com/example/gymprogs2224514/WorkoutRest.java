package com.example.gymprogs2224514;

import static com.example.gymprogs2224514.WorkoutAbs.launchState;
import static com.example.gymprogs2224514.WorkoutTimer.currentAbExercise;
import static com.example.gymprogs2224514.WorkoutTimer.reportCodeAbs;
import static com.example.gymprogs2224514.WorkoutTimer.reportCodeChest;
import static com.example.gymprogs2224514.WorkoutTimer.reportCodeBack;
import static com.example.gymprogs2224514.WorkoutTimer.reportCodeArms;
import static com.example.gymprogs2224514.WorkoutTimer.reportCodeLegs;
import static com.example.gymprogs2224514.WorkoutTimer.reportCodeShoulder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class WorkoutRest extends AppCompatActivity {

    long restDuration = TimeUnit.MINUTES.toMillis(1);

    // Initialize next exercises
    String[] abExercises = {"RUSSIAN TWISTS",
            "MOUNTAIN CLIMBERS", "LEG RAISES", "PLANK"};

    String[] armExercises = {"SKULL CRUSHERS",
            "SEATED WRIST CURLS", "TATE PRESS", "TWISTING DUMBBELL CURL"};

    String[] backExercises = {"CHEST SUPPORTED DUMBBELL ROW",
            "DUMBBELL SINGLE ARM ROW", "SINGLE ARM T BAR ROWS", "LAT PULLDOWN"};

    String[] chestExercises = {"DUMBBELL BENCH PRESS",
            "DUMBBELL CLOSE GRIP PRESS", "INCLINE DUMBBELL PRESS", "SEATED CHEST FLY"};

    String[] legsExercises = {"BULGARIAN SPLIT SQUAT",
            "HAMSTRING CURLS", "LEG EXTENSION", "CALF RAISE"};

    String[] shoulderExercises = {"DUMBBELL FRONT RAISE",
            "LATERAL RAISE", "MILITARY PRESS", "SEATED SHOULDER PRESS"};

    TextView timer, nextAbsExercise;
    Button nextWorkout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_rest);

        timer = findViewById(R.id.timer30Second);
        nextWorkout = findViewById(R.id.nextWorkout);
        nextAbsExercise = findViewById(R.id.nextAbsExercise);

        switch (launchState) {
            case 1:
                nextAbsExercise.setText(abExercises[currentAbExercise]);
                break;

            case 2:
                nextAbsExercise.setText(armExercises[currentAbExercise]);
                break;

            case 3:
                nextAbsExercise.setText(backExercises[currentAbExercise]);
                break;

            case 4:
                nextAbsExercise.setText(chestExercises[currentAbExercise]);
                break;

            case 5:
                nextAbsExercise.setText(legsExercises[currentAbExercise]);
                break;

            case 6:
                nextAbsExercise.setText(shoulderExercises[currentAbExercise]);
                break;

        }


        new CountDownTimer(restDuration, 1000) {
            @Override
            public void onTick(long l) {

                // Convert Millisecond to minute and seconds
                String sDuration = String.format(Locale.ENGLISH, "%02d : %02d",
                        TimeUnit.MILLISECONDS.toMinutes(1),
                        TimeUnit.MILLISECONDS.toSeconds(1) - TimeUnit.MINUTES.toSeconds
                                (TimeUnit.MILLISECONDS.toMinutes(1)));

                timer.setText(sDuration);
            }

            @Override
            public void onFinish() {
                timer.setVisibility(View.GONE);

                Toast.makeText(getApplicationContext()
                        , "Rest has ended", Toast.LENGTH_LONG).show();
            }
        }.start();

        nextWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GoBackToWorkoutTimer();
            }
        });
    }

    public void GoBackToWorkoutTimer() {
        Intent intent = new Intent(this, WorkoutTimer.class);

        switch (launchState) {
            case 1:
                reportCodeAbs++;
                startActivity(intent);

                break;
            case 2:
                reportCodeArms++;
                startActivity(intent);

                break;

            case 3:
                reportCodeBack++;
                startActivity(intent);

                break;


            case 4:
                reportCodeChest++;
                startActivity(intent);

                break;

            case 5:
                reportCodeLegs++;
                startActivity(intent);

                break;

            case 6:
                reportCodeShoulder++;
                startActivity(intent);

                break;
        }


    }
}
