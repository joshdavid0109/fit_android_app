package com.example.gymprogs2224514;

import static com.example.gymprogs2224514.WorkoutAbs.launchState;

import androidx.appcompat.app.AppCompatActivity;

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

public class WorkoutTimer extends AppCompatActivity {

    Animation timeranim;
    ImageView timericanchor, abGifView;
    TextView abExercisesTextView, abRepsTextView;
    Button startButtAbs1, nextWorkoutButt;
    Chronometer timerAbs1;

    public static int reportCodeAbs = 0;
    public static int reportCodeArms = 0;
    public static int reportCodeChest = 0;
    public static int reportCodeLegs = 0;
    public static int reportCodeShoulder = 0;
    public static int reportCodeBack = 0;

    static int currentAbExercise = 0;
    static int currentAbRep = 0;
    static int currentImage = 0;

    String[] abExercises = {"ABDOMINAL CRUNCHES", "RUSSIAN TWISTS",
            "MOUNTAIN CLIMBERS", "LEG RAISES", "PLANK"};

    String[] armExercises = {"REVERSE CURLS", "SKULL CRUSHERS",
            "SEATED WRIST CURLS", "TATE PRESS", "TWISTING DUMBBELL CURL"};

    String[] backExercises = {"LAT PULLDOWN", "BARBELL ROWS",
            "SINGLE ARM ROWS", "SINGLE ARMS T-BAR ROWS", "DEADLIFT"};

    String[] chestExercises = {"CABLE CROSSOVER", "DUMBBELL BENCH PRESS",
            "DUMBBELL CLOSE GRIP PRESS", "INCLINE DUMBBELL PRESS", "SEATED CHEST FLY"};

    String[] legsExercises = {"BARBELL SQUAT", "BULGARIAN SPLIT SQUAT",
            "HAMSTRING CURLS", "LEG EXTENSION", "CALF RAISE"};

    String[] shoulderExercises = {"BENT OVER REVERSE FLY", "DUMBBELL FRONT RAISE",
            "LATERAL RAISE", "MILITARY PRESS", "SEATED SHOULDER PRESS"};

    String[] abRep = {"10 REPS", "16 REPS", "30 SECONDS", "10 REPS", "30 SECONDS"};

    String[] armRep = {"10 REPS", "16 REPS", "30 SECONDS", "10 REPS", "30 SECONDS"};

    String[] backRep = {"10 REPS", "16 REPS", "30 SECONDS", "10 REPS", "30 SECONDS"};

    String[] chestRep = {"10 REPS", "16 REPS", "30 SECONDS", "10 REPS", "30 SECONDS"};

    String[] legsRep = {"10 REPS", "16 REPS", "30 SECONDS", "10 REPS", "30 SECONDS"};

    String[] shoulderRep = {"10 REPS", "16 REPS", "30 SECONDS", "10 REPS", "30 SECONDS"};

    int abRepLength = abRep.length;
    int abExercisesLength = abExercises.length;

    int armRepLength = armRep.length;
    int armExercisesLength = armExercises.length;

    int backRepLength = backRep.length;
    int backExercisesLength = backExercises.length;

    int chestRepLength = chestRep.length;
    int chestExercisesLength = chestExercises.length;

    int legsRepLength = legsRep.length;
    int legsExercisesLength = legsExercises.length;

    int shoulderRepLength = shoulderRep.length;
    int shoulderExercisesLength = shoulderExercises.length;

    int[] abGifs = {R.drawable.absexercise1, R.drawable.absexercise2, R.drawable.abexercise3,
            R.drawable.abexercise4, R.drawable.abexercise5};

    int[] armGifs = {R.drawable.armexercise1, R.drawable.armexercise2, R.drawable.armexercise3,
            R.drawable.armexercise4, R.drawable.armexercise5};

    int[] backGifs = {R.drawable.backexercise1, R.drawable.backexercise2, R.drawable.backexercise3,
            R.drawable.backexercise4, R.drawable.backexercise5};

    int[] chestGifs = {R.drawable.chestexercise1, R.drawable.chestexercise2, R.drawable.chestexercise3,
            R.drawable.chestexercise4, R.drawable.chestexercise5};

    int[] legsGifs = {R.drawable.legsexercise1, R.drawable.legsexercise2, R.drawable.legsexercise3,
            R.drawable.legsexercise4, R.drawable.legsexercise5};

    int[] shoulderGifs = {R.drawable.shoulderexercise1, R.drawable.shoulderexercise2,
            R.drawable.shoulderexercise3, R.drawable.shoulderexercise4, R.drawable.shoulderexercise5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_abs_timer);

        // Exercises, GIF and Reps

        abExercisesTextView = findViewById(R.id.absExcerciseText);
        abRepsTextView = findViewById(R.id.absReps);
        abGifView = findViewById(R.id.abGifView);

        // Back
        startButtAbs1 = findViewById(R.id.startAbsTimer1);
        nextWorkoutButt = findViewById(R.id.nextAbsWorkout);
        timericanchor = findViewById(R.id.workoutsTimerAnchor);
        timerAbs1 = findViewById(R.id.timerAbs);

        nextWorkoutButt.setAlpha(0);

        timeranim = AnimationUtils.loadAnimation(this, R.anim.timeranim);

        System.out.println("Launch state is: " + launchState);
        System.out.println("Report Code Abs = " + reportCodeAbs);

        /*
        Launch States

        Abs = [1]
        Arms = [2]
        Back = [3]
        Chest = [4]
        Legs = [5]
        Shoulder = [6]
         */

        switch (launchState) {
            case 1:
                if (reportCodeAbs == 0) {
                    abExercisesTextView.setText(abExercises[currentAbExercise]);
                    abRepsTextView.setText(abRep[currentAbRep]);
                    abGifView.setImageResource(abGifs[currentImage]);
                }
                break;

            case 2:
                if (reportCodeArms == 0) {
                    abExercisesTextView.setText(armExercises[currentAbExercise]);
                    abRepsTextView.setText(armRep[currentAbRep]);
                    abGifView.setImageResource(armGifs[currentImage]);
                }

                break;

            case 3:
                if (reportCodeBack == 0) {
                    abExercisesTextView.setText(backExercises[currentAbExercise]);
                    abRepsTextView.setText(backRep[currentAbRep]);
                    abGifView.setImageResource(backGifs[currentImage]);
                }

                break;


            case 4:
                if (reportCodeChest == 0) {
                    abExercisesTextView.setText(chestExercises[currentAbExercise]);
                    abRepsTextView.setText(chestRep[currentAbRep]);
                    abGifView.setImageResource(chestGifs[currentImage]);
                }
                break;
            case 5:
                if (reportCodeLegs == 0) {
                    abExercisesTextView.setText(legsExercises[currentAbExercise]);
                    abRepsTextView.setText(legsRep[currentAbRep]);
                    abGifView.setImageResource(legsGifs[currentImage]);
                }
                break;
            case 6:
                if (reportCodeShoulder == 0) {
                    abExercisesTextView.setText(shoulderExercises[currentAbExercise]);
                    abRepsTextView.setText(shoulderRep[currentAbRep]);
                    abGifView.setImageResource(shoulderGifs[currentImage]);
                }
                break;
        }

        // Check if reportCode has value
        if (reportCodeAbs != 0) {
            currentAbExercise++;
            currentAbRep++;
            currentImage++;

            currentImage = currentImage % abGifs.length;
            currentAbExercise = currentAbExercise % abExercisesLength;
            currentAbRep = currentAbRep % abRepLength;

            abExercisesTextView.setText(abExercises[currentAbExercise]);
            abRepsTextView.setText(abRep[currentAbRep]);
            abGifView.setImageResource(abGifs[currentImage]);

        } else if (reportCodeArms != 0) {
            currentAbExercise++;
            currentAbRep++;
            currentImage++;

            currentImage = currentImage % armGifs.length;
            currentAbExercise = currentAbExercise % armExercisesLength;
            currentAbRep = currentAbRep % armRepLength;

            abExercisesTextView.setText(armExercises[currentAbExercise]);
            abRepsTextView.setText(armRep[currentAbRep]);
            abGifView.setImageResource(armGifs[currentImage]);

        } else if (reportCodeBack != 0) {
            currentAbExercise++;
            currentAbRep++;
            currentImage++;

            currentImage = currentImage % backGifs.length;
            currentAbExercise = currentAbExercise % backExercisesLength;
            currentAbRep = currentAbRep % backRepLength;

            abExercisesTextView.setText(backExercises[currentAbExercise]);
            abRepsTextView.setText(backRep[currentAbRep]);
            abGifView.setImageResource(backGifs[currentImage]);
        } else if (reportCodeChest != 0) {
            currentAbExercise++;
            currentAbRep++;
            currentImage++;

            currentImage = currentImage % chestGifs.length;
            currentAbExercise = currentAbExercise % chestExercisesLength;
            currentAbRep = currentAbRep % chestRepLength;

            abExercisesTextView.setText(chestExercises[currentAbExercise]);
            abRepsTextView.setText(chestRep[currentAbRep]);
            abGifView.setImageResource(chestGifs[currentImage]);

        } else if (reportCodeLegs != 0) {
            currentAbExercise++;
            currentAbRep++;
            currentImage++;

            currentImage = currentImage % legsGifs.length;
            currentAbExercise = currentAbExercise % legsExercisesLength;
            currentAbRep = currentAbRep % legsRepLength;

            abExercisesTextView.setText(legsExercises[currentAbExercise]);
            abRepsTextView.setText(legsRep[currentAbRep]);
            abGifView.setImageResource(legsGifs[currentImage]);
        } else if (reportCodeShoulder != 0) {
            currentAbExercise++;
            currentAbRep++;
            currentImage++;

            currentImage = currentImage % shoulderGifs.length;
            currentAbExercise = currentAbExercise % shoulderExercisesLength;
            currentAbRep = currentAbRep % shoulderRepLength;

            abExercisesTextView.setText(shoulderExercises[currentAbExercise]);
            abRepsTextView.setText(shoulderRep[currentAbRep]);
            abGifView.setImageResource(shoulderGifs[currentImage]);
        }

        startButtAbs1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timericanchor.startAnimation(timeranim);
                nextWorkoutButt.animate().alpha(1).translationY(0).setDuration(300).start();
                startButtAbs1.animate().alpha(0).setDuration(300).start();

                timerAbs1.setBase(SystemClock.elapsedRealtime());
                timerAbs1.start();
            }
        });

        nextWorkoutButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // If report code == 4, workout has ended
                if (reportCodeAbs < 4) {
                    reportCodeAbs = 0; //initialize report code back to 0
                    GoToTimerEnd();
                } else if (reportCodeArms < 4) {
                    reportCodeArms = 0;
                    GoToTimerEnd();
                } else if (reportCodeBack < 4) {
                    reportCodeBack = 0;
                    GoToTimerEnd();
                } else if (reportCodeChest < 4) {
                    reportCodeChest = 0;
                    GoToTimerEnd();
                } else if (reportCodeLegs < 4) {
                    reportCodeLegs = 0;
                    GoToTimerEnd();
                } else if (reportCodeShoulder < 4) {
                    reportCodeShoulder = 0;
                    GoToTimerEnd();
                }
                GoToWorkoutRest();

            }
        });
    }

    public void GoToWorkoutRest() {
        Intent intent = new Intent(this, WorkoutRest.class);
        startActivity(intent);
    }

    public void GoToTimerEnd() {
        Intent intent = new Intent(this, WorkoutTimerEnd.class);
        startActivity(intent);
    }
}