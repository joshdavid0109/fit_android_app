package com.example.gymprogs2224514;

import static com.example.gymprogs2224514.ViewAllProgramsHIIT.launchStatePrograms;
import static com.example.gymprogs2224514.ViewAllProgramsTimer.currentProgramExercise;
import static com.example.gymprogs2224514.ViewAllProgramsTimer.reportCodeFullBody;
import static com.example.gymprogs2224514.ViewAllProgramsTimer.reportCodeHIIT;
import static com.example.gymprogs2224514.ViewAllProgramsTimer.reportCodeMuscle;
import static com.example.gymprogs2224514.ViewAllProgramsTimer.reportCodeStrength;
import static com.example.gymprogs2224514.ViewAllProgramsTimer.reportCodeWeight;

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

public class ViewAllProgramsRest extends AppCompatActivity {

    Animation timeranim;
    ImageView programTimerIcAnchor, viewAllTimer;

    TextView viewAllNextExercise, timerCD;
    Button viewAllNextWorkout;

    private CountDownTimer programCountDownTimer;
    private int programsRemainingTime = 30;

    String[] hiitProgram = { "LUNGE JUMP",
            "HIGH KNEES", "MOUNTAIN CLIMBERS", "BURPEES", "CRUNCHES" , "BUTT KICKS"};

    String[] muscleGainProgramD1 = { "INCLINE DUMBBELL PRESS",
            "DUMBBELL FLYS", "TRICEP EXTENSTIONS", "TRICEP DIPS", "DEADLIFT", "INCLINE CURLS"};

    String[] strengthProgram = { "DEADLIFT", "EZ BAR CURLS", "BENT OVER ROWS", "OVERHEAD PRESS",
            "BARBELL BENCH PRESS", "LAT PULLDOWN"};

    String[] weightLossProgram = {"KETTLE BELL SWING",
            "KETTLE BELL SQUATS", "DUMBBELL STEP UP", "REVERSE LUNGES",
            "BATTLE ROPE", "JUMPING ROPE"};

    String[] fullBodyProgramD1 = { "LAT PULLDOWN",
            "BARBELL SQUATS", "LEG CURLS", "SEATED DUMBBELL", "INCLINE CURLS", "TRICEP PRESSDOWN"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_programs_rest);

        viewAllNextWorkout = findViewById(R.id.viewAllNextWorkout);
        viewAllNextExercise = findViewById(R.id.viewAllNextExercise);
        programTimerIcAnchor = findViewById(R.id.viewAllTimerAnchorRest);
        timerCD = findViewById(R.id.viewAllCD);

        timeranim = AnimationUtils.loadAnimation(this, R.anim.timeranim);
        programTimerIcAnchor.startAnimation(timeranim);

        switch (launchStatePrograms) {
            case 1:
                if (currentProgramExercise != 6) {
                    viewAllNextExercise.setText(hiitProgram[currentProgramExercise]);
                }

                break;

            case 2:
                if (currentProgramExercise != 6) {
                    viewAllNextExercise.setText(muscleGainProgramD1[currentProgramExercise]);
                    break;

                }

            case 3:
                if (currentProgramExercise != 6) {
                    viewAllNextExercise.setText(strengthProgram[currentProgramExercise]);
                    break;
                }

            case 4:
                if (currentProgramExercise != 6) {
                    viewAllNextExercise.setText(weightLossProgram[currentProgramExercise]);
                    break;
                }


            case 5:
                if (currentProgramExercise != 6) {
                    viewAllNextExercise.setText(fullBodyProgramD1[currentProgramExercise]);
                    break;
                }
        }

        programCountDownTimer = new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long milliUntilDone) {
                programsRemainingTime = (int) milliUntilDone / 1000;
                timerCD.setText(String.valueOf(programsRemainingTime));

            }

            @Override
            public void onFinish() {
                timerCD.setText("REST FINISHED");
            }
        };

        programCountDownTimer.start();

        viewAllNextWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (launchStatePrograms) {
                    case 1:
                        if (currentProgramExercise != 6) {
                            GoBackToViewAllProgramTimer();
                        } else {
                            GoToViewAllTimerEnd();
                        }

                        break;

                    case 2:
                        if (currentProgramExercise != 6) {
                            GoBackToViewAllProgramTimer();
                        } else {
                            GoToViewAllTimerEnd();
                        }

                    case 3:
                        if (currentProgramExercise != 6) {
                            GoBackToViewAllProgramTimer();
                        } else {
                            GoToViewAllTimerEnd();
                        }

                    case 4:
                        if (currentProgramExercise != 6) {
                            GoBackToViewAllProgramTimer();
                        } else {
                            GoToViewAllTimerEnd();
                        }


                    case 5:
                        if (currentProgramExercise != 6) {
                            GoBackToViewAllProgramTimer();
                        } else {
                            GoToViewAllTimerEnd();
                        }
                }
            }
        });
    }


    public void GoBackToViewAllProgramTimer() {
        Intent intent = new Intent(this, ViewAllProgramsTimer.class);

        switch (launchStatePrograms) {
            case 1:
                reportCodeHIIT++;
                startActivity(intent);

                break;
            case 2:
                reportCodeMuscle++;
                startActivity(intent);

                break;

            case 3:
                reportCodeStrength++;
                startActivity(intent);

                break;


            case 4:
                reportCodeWeight++;
                startActivity(intent);

                break;

            case 5:
                reportCodeFullBody++;
                startActivity(intent);

                break;
        }
    }

    public void GoToViewAllTimerEnd() {
        Intent intent = new Intent(this, ViewAllProgramsTimerEnd.class);
        startActivity(intent);
    }
}