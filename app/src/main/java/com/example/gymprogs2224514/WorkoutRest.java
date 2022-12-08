package com.example.gymprogs2224514;

import static com.example.gymprogs2224514.WorkoutAbsTimer.reportCode;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_rest);

        TextView timer;
        Button nextAbsWorkout2;

        timer = findViewById(R.id.timer30Second);
        nextAbsWorkout2 = findViewById(R.id.nextAbsWorkout2);

        new CountDownTimer(restDuration, 1000) {
            @Override
            public void onTick(long l) {

                // Convert Millisecond to minute and seconds
                String sDuration = String.format(Locale.ENGLISH,"%02d : %02d",
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

        nextAbsWorkout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GoBackToWorkoutAbsTimer();
            }
        });
    }

    public void GoBackToWorkoutAbsTimer() {
        Intent intent = new Intent(this, WorkoutAbsTimer.class);
        reportCode++;
        startActivity(intent);
    }
}
