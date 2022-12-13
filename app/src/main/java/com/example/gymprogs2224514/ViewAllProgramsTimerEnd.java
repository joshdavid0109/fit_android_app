package com.example.gymprogs2224514;


import static com.example.gymprogs2224514.ViewAllProgramsTimer.currentProgramExercise;
import static com.example.gymprogs2224514.ViewAllProgramsTimer.currentProgramImage;
import static com.example.gymprogs2224514.ViewAllProgramsTimer.currentProgramRep;
import static com.example.gymprogs2224514.WorkoutTimer.currentAbExercise;
import static com.example.gymprogs2224514.WorkoutTimer.currentAbRep;
import static com.example.gymprogs2224514.WorkoutTimer.currentImage;

import static com.example.gymprogs2224514.ViewAllProgramsTimer.reportCodeFullBody;
import static com.example.gymprogs2224514.ViewAllProgramsTimer.reportCodeHIIT;
import static com.example.gymprogs2224514.ViewAllProgramsTimer.reportCodeMuscle;
import static com.example.gymprogs2224514.ViewAllProgramsTimer.reportCodeStrength;
import static com.example.gymprogs2224514.ViewAllProgramsTimer.reportCodeWeight;
import static com.example.gymprogs2224514.ViewAllProgramsHIIT.launchStatePrograms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

import nl.dionsegijn.konfetti.core.Party;
import nl.dionsegijn.konfetti.core.PartyFactory;
import nl.dionsegijn.konfetti.core.emitter.Emitter;
import nl.dionsegijn.konfetti.core.emitter.EmitterConfig;
import nl.dionsegijn.konfetti.core.models.Shape;
import nl.dionsegijn.konfetti.xml.KonfettiView;

public class ViewAllProgramsTimerEnd extends AppCompatActivity {

    KonfettiView celebrationView2 = null;
    Shape.DrawableShape drawableShape2 = null;

    TextView endViewWorkoutText, viewAllWork1, viewAllWork2, viewAllWork3,
            viewAllWork4, viewAllWork5, viewAllWork6, viewAllWork7;

    ImageView endWorkoutPic2;
    Button backToMenu;

    String[] viewAllEndWorkouts = {"HIIT PROGRAM", "MUSCLE GAIN PROGRAM", "STRENGTH PROGRAM",
            "WEIGHT LOSS PROGRAM", "FULL BODY PROGRAM"};

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
            "BARBELL SQUATS", "LEG CURLS", "SEATED DUMBBELL",
            "INCLINE CURLS", "TRICEP PRESSDOWN"};

    int[] viewAllPicEnd = {R.drawable.gympic1, R.drawable.gympic8, R.drawable.gympic11,
            R.drawable.gympic10, R.drawable.gympic9};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_programs_timer_end);

        backToMenu = findViewById(R.id.backToMenu);
        endViewWorkoutText = findViewById(R.id.endViewAllWorkoutText);
        endWorkoutPic2 = findViewById(R.id.endWorkoutPic2);
        viewAllWork1 = findViewById(R.id.viewAllWork1);
        viewAllWork2 = findViewById(R.id.viewAllWork2);
        viewAllWork3 = findViewById(R.id.viewAllWork3);
        viewAllWork4 = findViewById(R.id.viewAllWork4);
        viewAllWork5 = findViewById(R.id.viewAllWork5);
        viewAllWork6 = findViewById(R.id.viewAllWork6);
        viewAllWork7 = findViewById(R.id.viewAllWork7);

        final Drawable drawable = ContextCompat.getDrawable(getApplicationContext(),
                R.drawable.ic_android_black_24dp);
        drawableShape2 = new Shape.DrawableShape(drawable, true);
        celebrationView2 = findViewById(R.id.celebrationEnd2);
        EmitterConfig emitterConfig = new Emitter(5L, TimeUnit.SECONDS).perSecond(50);
        Party party = new PartyFactory(emitterConfig)
                .angle(270)
                .spread(90)
                .setSpeedBetween(1f, 5f)
                .timeToLive(2000L)
                .shapes(new Shape.Rectangle(0.2f), drawableShape2)
                .position(0.0, 0.0, 1.0, 1.0)
                .build();


        System.out.println("Launch state is: " + launchStatePrograms);

        celebrationView2.start(party);

        switch (launchStatePrograms) {
            case 1:
                endWorkoutPic2.setImageResource(viewAllPicEnd[0]);
                endViewWorkoutText.setText(viewAllEndWorkouts[0]);
                viewAllWork1.setText(hiitProgram[0]);
                viewAllWork2.setText(hiitProgram[1]);
                viewAllWork3.setText(hiitProgram[2]);
                viewAllWork4.setText(hiitProgram[3]);
                viewAllWork5.setText(hiitProgram[4]);
                viewAllWork4.setText(hiitProgram[5]);
                viewAllWork5.setText(hiitProgram[6]);
                launchStatePrograms = 0;
                break;

            case 2:
                endWorkoutPic2.setImageResource(viewAllPicEnd[1]);
                endViewWorkoutText.setText(viewAllEndWorkouts[1]);
                viewAllWork1.setText(muscleGainProgramD1[0]);
                viewAllWork2.setText(muscleGainProgramD1[1]);
                viewAllWork3.setText(muscleGainProgramD1[2]);
                viewAllWork4.setText(muscleGainProgramD1[3]);
                viewAllWork5.setText(muscleGainProgramD1[4]);
                viewAllWork6.setText(muscleGainProgramD1[5]);
                viewAllWork7.setText(muscleGainProgramD1[6]);
                launchStatePrograms = 0;
                break;

            case 3:
                endWorkoutPic2.setImageResource(viewAllPicEnd[2]);
                endViewWorkoutText.setText(viewAllEndWorkouts[2]);
                viewAllWork1.setText(strengthProgram[0]);
                viewAllWork2.setText(strengthProgram[1]);
                viewAllWork3.setText(strengthProgram[2]);
                viewAllWork4.setText(strengthProgram[3]);
                viewAllWork5.setText(strengthProgram[4]);
                viewAllWork6.setText(strengthProgram[5]);
                viewAllWork7.setText(strengthProgram[6]);
                launchStatePrograms = 0;
                break;

            case 4:
                endWorkoutPic2.setImageResource(viewAllPicEnd[3]);
                endViewWorkoutText.setText(viewAllEndWorkouts[3]);
                viewAllWork1.setText(weightLossProgram[0]);
                viewAllWork2.setText(weightLossProgram[1]);
                viewAllWork3.setText(weightLossProgram[2]);
                viewAllWork4.setText(weightLossProgram[3]);
                viewAllWork5.setText(weightLossProgram[4]);
                viewAllWork6.setText(weightLossProgram[5]);
                viewAllWork7.setText(weightLossProgram[6]);
                launchStatePrograms = 0;
                break;

            case 5:
                endWorkoutPic2.setImageResource(viewAllPicEnd[4]);
                endViewWorkoutText.setText(viewAllEndWorkouts[4]);
                viewAllWork1.setText(fullBodyProgramD1[0]);
                viewAllWork2.setText(fullBodyProgramD1[1]);
                viewAllWork3.setText(fullBodyProgramD1[2]);
                viewAllWork4.setText(fullBodyProgramD1[3]);
                viewAllWork5.setText(fullBodyProgramD1[4]);
                viewAllWork6.setText(fullBodyProgramD1[5]);
                viewAllWork7.setText(fullBodyProgramD1[6]);
                launchStatePrograms = 0;
                break;
        }

        backToMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Launch state is: " + launchStatePrograms);
                AbsBackToMainMenu();
            }
        });


    }

    public void AbsBackToMainMenu() {
        Intent intent = new Intent(this, MainActivity.class);
        // Reset count back to 0, when going back to main menu'
        launchStatePrograms = 0;
        currentProgramExercise = 0;
        currentProgramImage = 0;
        currentProgramRep = 0;
        reportCodeHIIT = 0;
        reportCodeMuscle = 0;
        reportCodeFullBody = 0;
        reportCodeStrength = 0;
        reportCodeWeight= 0;
        startActivity(intent);
    }
}