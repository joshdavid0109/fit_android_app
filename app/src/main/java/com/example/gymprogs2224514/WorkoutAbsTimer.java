package com.example.gymprogs2224514;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
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

public class WorkoutAbsTimer extends AppCompatActivity {

    Animation timeranim;
    ImageView timericanchor, abGifView;
    TextView abExercisesTextView,abRepsTextView,abNextExercise;
    static Button startButtAbs1,nextWorkoutButt;
    Chronometer timerAbs1;

    static int currentAbExercise;
    static int currentAbRep;
    static int currentImage;

    String[] abExercises = { "ABDOMINAL CRUNCHES", "RUSSIAN TWISTS",
            "MOUNTAIN CLIMBERS","LEG RAISES","PLANK"};

    int abExercisesLength = abExercises.length;

    String[] abRep = {"10 REPS", "16 REPS", "30 SECONDS", "10 REPS", "30 SECONDS"};

    int abRepLength = abRep.length;

    int[] abGifs = {R.drawable.abswork1, R.drawable.absexercise2, R.drawable.abexercise3,
    R.drawable.abexercise4, R.drawable.abexercise5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
           setContentView(R.layout.activity_workout_abs_timer);

        currentAbExercise = getIntent().getIntExtra("current exercise", 0);
        currentAbRep = getIntent().getIntExtra("current ab rep", 0);
        currentImage = getIntent().getIntExtra("current image", 0);

           startButtAbs1 = findViewById(R.id.startAbsTimer1);
           nextWorkoutButt = findViewById(R.id.nextAbsWorkout);
           timericanchor = findViewById(R.id.timericanchor);
           timerAbs1 =  findViewById(R.id.timerAbs1);

           // Exercises, GIF and Reps
           abExercisesTextView = findViewById(R.id.absExerciseText);
           abRepsTextView = findViewById(R.id.absReps);
           abGifView = findViewById(R.id.abGifView);

            nextWorkoutButt.setAlpha(0);

            timeranim = AnimationUtils.loadAnimation(this,R.anim.timeranim);



            startButtAbs1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            timericanchor.startAnimation(timeranim);
                            nextWorkoutButt.animate().alpha(1).translationY(-80).setDuration(300).start();
                            startButtAbs1.animate().alpha(0).setDuration(300).start();

                            timerAbs1.setBase(SystemClock.elapsedRealtime());
                            timerAbs1.start();
                        }
                    });

        nextWorkoutButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                currentAbExercise++;
                currentAbRep++;
                currentImage++;

                currentImage = currentImage % abGifs.length;
                currentAbExercise = currentAbExercise % abExercisesLength;
                currentAbRep= currentAbRep % abRepLength;

                abExercisesTextView.setText(abExercises[currentAbExercise]);

                // check if tama
                abRepsTextView.setText(abRep[currentAbRep]);
                abGifView.setImageResource(abGifs[currentImage]);

                GoToWorkoutRest();
            }
        });
    }

    public void GoToWorkoutRest() {

        String getAbExercise = abExercises[currentAbExercise];
        String getAbReps = abRep[currentAbRep];
        int getAbGifView = abGifs[currentImage];

        Intent intent = new Intent(this, WorkoutRest.class);
        intent.putExtra("current exercise", getAbExercise);
        intent.putExtra("current ab rep", getAbReps);
        intent.putExtra("current image", getAbGifView);

        startActivity(intent);
    }
}