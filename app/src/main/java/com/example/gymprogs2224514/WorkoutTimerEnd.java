package com.example.gymprogs2224514;

import static com.example.gymprogs2224514.WorkoutAbs.launchState;
import static com.example.gymprogs2224514.WorkoutTimer.currentAbExercise;
import static com.example.gymprogs2224514.WorkoutTimer.currentAbRep;
import static com.example.gymprogs2224514.WorkoutTimer.currentImage;
import static com.example.gymprogs2224514.WorkoutTimer.reportCodeAbs;
import static com.example.gymprogs2224514.WorkoutTimer.reportCodeArms;
import static com.example.gymprogs2224514.WorkoutTimer.reportCodeBack;
import static com.example.gymprogs2224514.WorkoutTimer.reportCodeChest;
import static com.example.gymprogs2224514.WorkoutTimer.reportCodeLegs;
import static com.example.gymprogs2224514.WorkoutTimer.reportCodeShoulder;

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

public class WorkoutTimerEnd extends AppCompatActivity {

    KonfettiView celebrationView = null;
    Shape.DrawableShape drawableShape = null;
    ImageView endWorkoutPic;
    Button absBackToMenu;
    TextView endWorkoutText, workout1, workout2, workout3, workout4, workout5;

    String[] endWorkouts = {"ABS WORKOUT", "ARMS WORKOUT", "BACK WORKOUT",
            "CHEST WORKOUT", "LEGS WORKOUT", "SHOULDER WORKOUT"};

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

    int[] exercisesPicEnd = {R.drawable.gympic2, R.drawable.gympic3, R.drawable.gympic4,
            R.drawable.gympic5, R.drawable.gympic6, R.drawable.gympic7};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_timer_end);


        absBackToMenu = findViewById(R.id.absBackToMenu);
        endWorkoutText = findViewById(R.id.endWorkout);
        endWorkoutPic = findViewById(R.id.endWorkoutPic);
        workout1 = findViewById(R.id.workout1);
        workout2 = findViewById(R.id.workout2);
        workout3 = findViewById(R.id.workout3);
        workout4 = findViewById(R.id.workout4);
        workout5 = findViewById(R.id.workout5);
        System.out.println("Launch state is: " + launchState);

        final Drawable drawable = ContextCompat.getDrawable(getApplicationContext(),
                R.drawable.ic_android_black_24dp);
        drawableShape = new Shape.DrawableShape(drawable, true);
        celebrationView = findViewById(R.id.celebrationEnd);
        EmitterConfig emitterConfig = new Emitter(5L, TimeUnit.SECONDS).perSecond(50);
        Party party = new PartyFactory(emitterConfig)
                .angle(270)
                .spread(90)
                .setSpeedBetween(1f, 5f)
                .timeToLive(2000L)
                .shapes(new Shape.Rectangle(0.2f), drawableShape)
                .position(0.0, 0.0, 1.0, 1.0)
                .build();

        celebrationView.start(party);

        switch (launchState) {
            case 1:
                endWorkoutPic.setImageResource(exercisesPicEnd[0]);
                endWorkoutText.setText(endWorkouts[0]);
                workout1.setText(abExercises[0]);
                workout2.setText(abExercises[1]);
                workout3.setText(abExercises[2]);
                workout4.setText(abExercises[3]);
                workout5.setText(abExercises[4]);
                launchState = 0;
                break;

            case 2:
                endWorkoutPic.setImageResource(exercisesPicEnd[5]);
                endWorkoutText.setText(endWorkouts[1]);
                workout1.setText(armExercises[0]);
                workout2.setText(armExercises[1]);
                workout3.setText(armExercises[2]);
                workout4.setText(armExercises[3]);
                workout5.setText(armExercises[4]);
                launchState = 0;
                break;

            case 3:
                endWorkoutPic.setImageResource(exercisesPicEnd[3]);
                endWorkoutText.setText(endWorkouts[1]);
                workout1.setText(backExercises[0]);
                workout2.setText(backExercises[1]);
                workout3.setText(backExercises[2]);
                workout4.setText(backExercises[3]);
                workout5.setText(backExercises[4]);
                launchState = 0;
                break;

            case 4:
                endWorkoutPic.setImageResource(exercisesPicEnd[1]);
                endWorkoutText.setText(endWorkouts[3]);
                workout1.setText(chestExercises[0]);
                workout2.setText(chestExercises[1]);
                workout3.setText(chestExercises[2]);
                workout4.setText(chestExercises[3]);
                workout5.setText(chestExercises[4]);
                launchState = 0;
                break;

            case 5:
                endWorkoutPic.setImageResource(exercisesPicEnd[4]);
                endWorkoutText.setText(endWorkouts[4]);
                workout1.setText(legsExercises[0]);
                workout2.setText(legsExercises[1]);
                workout3.setText(legsExercises[2]);
                workout4.setText(legsExercises[3]);
                workout5.setText(legsExercises[4]);
                launchState = 0;
                break;

            case 6:
                endWorkoutPic.setImageResource(exercisesPicEnd[2]);
                endWorkoutText.setText(endWorkouts[5]);
                workout1.setText(shoulderExercises[0]);
                workout2.setText(shoulderExercises[1]);
                workout3.setText(shoulderExercises[2]);
                workout4.setText(shoulderExercises[3]);
                workout5.setText(shoulderExercises[4]);
                launchState = 0;
                break;

        }

        absBackToMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Launch state is: " + launchState);
                AbsBackToMainMenu();
            }
        });


    }

    public void AbsBackToMainMenu() {
        Intent intent = new Intent(this, MainActivity.class);
        // Reset count back to 0, when going back to main menu
        launchState = 0;
        currentAbExercise = 0;
        currentImage = 0;
        currentAbRep = 0;
        reportCodeAbs = 0;
        reportCodeArms = 0;
        reportCodeBack = 0;
        reportCodeChest = 0;
        reportCodeLegs = 0;
        reportCodeShoulder = 0;
        startActivity(intent);
    }
}
