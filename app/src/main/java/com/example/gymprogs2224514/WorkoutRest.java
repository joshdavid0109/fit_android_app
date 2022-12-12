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
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class WorkoutRest extends AppCompatActivity {


    Animation timeranimrest;
    ImageView timericanchorrest;
    private CountDownTimer countDownTimer;
    private int remainingTime = 30;

    // Initialize next exercises
    String[] abExercises = {"RUSSIAN TWISTS",
            "MOUNTAIN CLIMBERS", "LEG RAISES", "PLANK"};

    String[] armExercises = {"SKULL CRUSHERS",
            "SEATED WRIST CURLS", "TATE PRESS", "TWISTING DUMBBELL CURL"};

    String[] backExercises = { "BARBELL ROWS",
            "SINGLE ARM ROWS", "SINGLE ARMS T-BAR ROWS", "DEADLIFT"};

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
        timericanchorrest = findViewById(R.id.timeranchorrest);

        timeranimrest = AnimationUtils.loadAnimation(this, R.anim.timeranim);
        timericanchorrest.startAnimation(timeranimrest);

        switch (launchState) {
            case 1:
                if (currentAbExercise != 4) {
                    nextAbsExercise.setText(abExercises[currentAbExercise]);
                }

                break;

            case 2:
                if (currentAbExercise != 4) {
                    nextAbsExercise.setText(armExercises[currentAbExercise]);
                    break;

                }

            case 3:
                if (currentAbExercise != 4) {
                    nextAbsExercise.setText(backExercises[currentAbExercise]);
                    break;
                }

            case 4:
                if (currentAbExercise != 4) {
                    nextAbsExercise.setText(chestExercises[currentAbExercise]);
                    break;
                }


            case 5:
                if (currentAbExercise != 4) {
                    nextAbsExercise.setText(legsExercises[currentAbExercise]);
                    break;
                }


            case 6:
                if (currentAbExercise != 4) {
                    nextAbsExercise.setText(shoulderExercises[currentAbExercise]);
                    break;
                }


        }

        countDownTimer = new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long milliUntilDone) {
                remainingTime = (int) milliUntilDone / 1000;
                timer.setText(String.valueOf(remainingTime));

            }

            @Override
            public void onFinish() {
                timer.setText("REST FINISHED");
            }
        };

        countDownTimer.start();

        nextWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentAbExercise != 4) {
                    GoBackToWorkoutTimer();
                } else {
                    GoToTimerEnd();
                }
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

    public void GoToTimerEnd() {
        Intent intent = new Intent(this, WorkoutTimerEnd.class);
        startActivity(intent);
    }
}
