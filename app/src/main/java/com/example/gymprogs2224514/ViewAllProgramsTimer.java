package com.example.gymprogs2224514;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.gymprogs2224514.ViewAllProgramsHIIT.launchStatePrograms;


import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewAllProgramsTimer extends AppCompatActivity {

    Animation programTimerAnim;
    ImageView programTimerIcAnchor, programGifView;

    Button startProgramTimer, nextProgramExerciseButt;
    TextView programTextTimer, programRep;

    Chronometer programTimer;

    public static int reportCodeHIIT = 0;
    public static int reportCodeMuscle = 0;
    public static int reportCodeStrength = 0;
    public static int reportCodeWeight = 0;
    public static int reportCodeFullBody = 0;

    static int currentProgramExercise = 0;
    static int currentProgramRep = 0;
    static int currentProgramImage = 0;

    String[] hiitProgram = {"JUMPING JACKS", "LUNGE JUMP",
            "HIGH KNEES", "MOUNTAIN CLIMBERS", "BURPEES", "CRUNCHES" , "BUTT KICKS"};

    String[] muscleGainProgramD1 = {"BARBELL BENCH PRESS", "INCLINE DUMBBELL PRESS",
            "DUMBBELL FLYS", "TRICEP EXTENSTIONS", "TRICEP DIPS", "DEADLIFT", "INCLINE CURLS"};

    String[] strengthProgram = {"BACK SQUAT", "DEADLIFT",
            "EZ BAR CURLS", "BENT OVER ROWS", "OVERHEAD PRESS", "BARBELL BENCH PRESS", "LAT PULLDOWN"};

    String[] weightLossProgram = {"PUSHUPS", "KETTLE BELL SWING",
            "KETTLE BELL SQUATS", "DUMBBELL STEP UP", "REVERSE LUNGES",
            "BATTLE ROPE", "JUMPING ROPE"};

    String[] fullBodyProgramD1 = {"BARBELL BENCH PRESS", "LAT PULLDOWN",
            "BARBELL SQUATS", "LEG CURLS", "SEATED DUMBBELL PRESS", "INCLINE CURLS", "TRICEP PRESSDOWN"};


    // Reps
    String[] hiitRep = {"10 REPS", "16 REPS", "30 SECONDS", "10 REPS", "30 SECONDS", "16 REPS"
            , "30 SECONDS"};

    String[] muscleGainRepD1 = {"10 REPS", "12 REPS", "12 REPS", "12 REPS", "12 REPS",
            "8-10 REPS", "12 REPS"};

    String[] strengthProgramRep = {"10 REPS", "6-10 REPS", "10-12 REPS", "10 REPS", "8 REPS", "6-8 REPS",
            "10 REPS"};

    String[] weightLossProgramRep = {"10 REPS", "16 REPS", "12 REPS", "30 SECONDS", "24 REPS", "40 SECONDS", "30 SECONDS"};

    String[] fullBodyProgramRepD1 = {"8 REPS", "10 REPS", "8 REPS", "10 REPS", "8 REPS",
            "12 REPS", "12 REPS"};

    int hiitExercisesLength = hiitProgram.length;
    int hiitRepLength = hiitRep.length;

    int muscleGainExercisesLengthD1 = muscleGainProgramD1.length;
    int muscleGainRepLengthD1 = muscleGainRepD1.length;

    int strengthExercisesLength = strengthProgram.length;
    int strengthRepLength = strengthProgramRep.length;

    int weightLossExercisesLength = weightLossProgram.length;
    int weightLossRepLength = weightLossProgramRep.length;

    int fullBodyProgramExercisesLengthD1 = fullBodyProgramD1.length;
    int fullBodyProgramRepLengthD1 = fullBodyProgramRepD1.length;

    int[] hiitGifs = {R.drawable.hiitexercise1, R.drawable.hiitexercise2, R.drawable.hiitexercise3,
            R.drawable.hiitexercise4, R.drawable.hiitexercise5, R.drawable.hiitexercise6,
            R.drawable.hiitexercise7};

    int[] muscleGainGifsD1 = {R.drawable.muscleexercise1, R.drawable.muscleexercise2, R.drawable.muscleexercise3,
            R.drawable.muscleexercise4, R.drawable.musscleexercise5, R.drawable.strengthexercise2, R.drawable.fullexercise6};

    int[] strengthGifs = {R.drawable.strengthexercise1, R.drawable.strengthexercise2,
            R.drawable.strengthexercise3, R.drawable.strengthexercise4, R.drawable.strengthexercise5, R.drawable.fullexercise1
    , R.drawable.fullexercise2};

    int[] weightLossGifs = {R.drawable.weightlossexercise1, R.drawable.weightlossexercise2,
            R.drawable.weightlossexercise3, R.drawable.weightlossexercise4, R.drawable.weightlossexercise5,
            R.drawable.weightlossexercise6, R.drawable.weightlossexercise7};

    int[] fullBodyD1Gifs = {R.drawable.fullexercise1, R.drawable.fullexercise2, R.drawable.fullexercise3,
            R.drawable.fullexercise4, R.drawable.fullexercise5, R.drawable.fullexercise6,
            R.drawable.fullexercise7};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_programs_timer);

        startProgramTimer = findViewById(R.id.startProgramTimer);
        nextProgramExerciseButt = findViewById(R.id.nextProgramExercise);

        programTextTimer = findViewById(R.id.programCurrentExercise);
        programRep = findViewById(R.id.programRep);
        programGifView = findViewById(R.id.programGifView);

        programTimer = findViewById(R.id.timerAbs2);

        programTimerIcAnchor = findViewById(R.id.programTimerAnchor);

        nextProgramExerciseButt.setAlpha(0);

        programTimerAnim = AnimationUtils.loadAnimation(this, R.anim.timeranim);

        System.out.println("Launch state is: " + launchStatePrograms);

          /*
        Program Launch States

        HIIT = [1]
        Muscle Gain Program = [2]
        Strength Program= [3]
        Weight Loss Program = [4]
        Full Body Program = [5]
         */

        switch (launchStatePrograms) {

            case 1:
                if (reportCodeHIIT == 0) {
                    programTextTimer.setText(hiitProgram[currentProgramExercise]);
                    programRep.setText(hiitRep[currentProgramRep]);
                    programGifView.setImageResource(hiitGifs[currentProgramImage]);
                    break;
                }

            case 2:
                if (reportCodeMuscle == 0) {
                    programTextTimer.setText(muscleGainProgramD1[currentProgramExercise]);
                    programRep.setText(muscleGainRepD1[currentProgramRep]);
                    programGifView.setImageResource(muscleGainGifsD1[currentProgramImage]);
                    break;

                }

            case 3:
                if (reportCodeStrength == 0) {
                    programTextTimer.setText(strengthProgram[currentProgramExercise]);
                    programRep.setText(strengthProgramRep[currentProgramRep]);
                    programGifView.setImageResource(strengthGifs[currentProgramImage]);
                    break;
                }


            case 4:

                if (reportCodeWeight == 0) {
                    programTextTimer.setText(weightLossProgram[currentProgramExercise]);
                    programRep.setText(weightLossProgramRep[currentProgramRep]);
                    programGifView.setImageResource(weightLossGifs[currentProgramImage]);
                    break;
                }

            case 5:

                if (reportCodeFullBody == 0) {
                    programTextTimer.setText(fullBodyProgramD1[currentProgramExercise]);
                    programRep.setText(fullBodyProgramRepD1[currentProgramRep]);
                    programGifView.setImageResource(fullBodyD1Gifs[currentProgramImage]);
                    break;
                }
        }

        if (reportCodeHIIT != 0) {

            currentProgramExercise++;
            currentProgramRep++;
            currentProgramImage++;

            currentProgramImage = currentProgramImage % hiitGifs.length;
            currentProgramExercise = currentProgramExercise % hiitExercisesLength;
            currentProgramRep = currentProgramRep % hiitRepLength;

            programTextTimer.setText(hiitProgram[currentProgramExercise]);
            programRep.setText(hiitRep[currentProgramRep]);
            programGifView.setImageResource(hiitGifs[currentProgramImage]);

        } else if (reportCodeMuscle != 0) {
            currentProgramExercise++;
            currentProgramRep++;
            currentProgramImage++;

            currentProgramImage = currentProgramImage % muscleGainGifsD1.length;
            currentProgramExercise = currentProgramExercise % muscleGainExercisesLengthD1;
            currentProgramRep = currentProgramRep % muscleGainRepLengthD1;

            programTextTimer.setText(muscleGainProgramD1[currentProgramExercise]);
            programRep.setText(muscleGainRepD1[currentProgramRep]);
            programGifView.setImageResource(muscleGainGifsD1[currentProgramImage]);

        } else if (reportCodeStrength != 0) {
            currentProgramExercise++;
            currentProgramRep++;
            currentProgramImage++;

            currentProgramImage = currentProgramImage % strengthGifs.length;
            currentProgramExercise = currentProgramExercise % strengthExercisesLength;
            currentProgramRep = currentProgramRep % strengthRepLength;

            programTextTimer.setText(strengthProgram[currentProgramExercise]);
            programRep.setText(strengthProgramRep[currentProgramRep]);
            programGifView.setImageResource(strengthGifs[currentProgramImage]);

        } else if (reportCodeWeight != 0) {

            currentProgramExercise++;
            currentProgramRep++;
            currentProgramImage++;

            currentProgramImage = currentProgramImage % weightLossGifs.length;
            currentProgramExercise = currentProgramExercise % weightLossExercisesLength;
            currentProgramRep = currentProgramRep % weightLossRepLength;

            programTextTimer.setText(weightLossProgram[currentProgramExercise]);
            programRep.setText(weightLossProgramRep[currentProgramRep]);
            programGifView.setImageResource(weightLossGifs[currentProgramImage]);

        } else if (reportCodeFullBody != 0) {
            currentProgramExercise++;
            currentProgramRep++;
            currentProgramImage++;

            currentProgramImage = currentProgramImage % fullBodyD1Gifs.length;
            currentProgramExercise = currentProgramExercise % fullBodyProgramExercisesLengthD1;
            currentProgramRep = currentProgramRep % fullBodyProgramRepLengthD1;

            programTextTimer.setText(fullBodyProgramD1[currentProgramExercise]);
            programRep.setText(fullBodyProgramRepD1[currentProgramRep]);
            programGifView.setImageResource(fullBodyD1Gifs[currentProgramImage]);

        }

        startProgramTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                programTimerIcAnchor.startAnimation(programTimerAnim);
                nextProgramExerciseButt.animate().alpha(1).translationY(0).setDuration(300).start();
                startProgramTimer.animate().alpha(0).setDuration(300).start();

                programTimer.setBase(SystemClock.elapsedRealtime());
                programTimer.start();
            }
        });

        nextProgramExerciseButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                System.out.println("repHIIT is : " + reportCodeHIIT);
                // If report code == 4, workout has ended
                if (reportCodeHIIT < 4) {
                    reportCodeHIIT = 0; //initialize report code back to 0
                    GoToViewAllTimerEnd();
                } else if (reportCodeMuscle < 4) {
                    reportCodeMuscle = 0;
                    GoToViewAllTimerEnd();
                } else if (reportCodeStrength < 4) {
                    reportCodeStrength = 0;
                    GoToViewAllTimerEnd();
                } else if (reportCodeWeight < 7) {
                    reportCodeWeight = 0;
                    GoToViewAllTimerEnd();
                } else if (reportCodeFullBody < 7) {
                    reportCodeFullBody = 0;
                    GoToViewAllTimerEnd();
                }
                GoToViewAllWorkoutRest();

            }
        });
    }

    public void GoToViewAllWorkoutRest() {
        Intent intent = new Intent(this, ViewAllProgramsRest.class);
        startActivity(intent);
    }

    public void GoToViewAllTimerEnd() {
        Intent intent = new Intent(this, ViewAllProgramsTimerEnd.class);
        startActivity(intent);
    }
}
