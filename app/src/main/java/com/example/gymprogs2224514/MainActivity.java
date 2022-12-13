package com.example.gymprogs2224514;

import androidx.appcompat.app.AppCompatActivity;
import static com.example.gymprogs2224514.ViewAllProgramsHIIT.launchStatePrograms;
import static com.example.gymprogs2224514.WorkoutAbs.launchState;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    static int mainActivityStatus = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        launchState = -10;
        launchStatePrograms = -10;

        Button viewAllButt = findViewById(R.id.viewAllButton);
        ImageButton mainProgram = findViewById(R.id.mainProgram);
        ImageButton absWorkButt = findViewById(R.id.absWorkButt);
        ImageButton chestWorkButt = findViewById(R.id.chestWorkButt);
        ImageButton shoulderWorkButt = findViewById(R.id.shoulderWorkButt);
        ImageButton backWorkButt = findViewById(R.id.backWorkButt);
        ImageButton legsWorkButt = findViewById(R.id.legsWorkButt);
        ImageButton armsWorkButt = findViewById(R.id.armsWorkButt);

        viewAllButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activityViewAll();
            }
        });

        mainProgram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToMainProgram();
            }
        });

        absWorkButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToAbsWorkout();
            }
        });

        chestWorkButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToChestWorkout();
            }
        });

        shoulderWorkButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToShoulderWorkout();
            }
        });

        backWorkButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToBackWorkout();
            }
        });

        legsWorkButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToLegsWorkout();
            }
        });

        armsWorkButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToArmsWorkout();
            }
        });
    }

    public void activityViewAll() {
        Intent intent = new Intent(this, ViewAllProgramsActivity.class);
        startActivity(intent);
    }

    public void goToMainProgram() {
        Intent intent = new Intent(this, ViewAllProgramsHIIT.class);
        mainActivityStatus++;
        startActivity(intent);
    }

    public void goToAbsWorkout() {
        Intent intent = new Intent(this, WorkoutAbs.class);
        startActivity(intent);
    }

    public void goToBackWorkout() {
        Intent intent = new Intent(this, WorkoutBack.class);
        startActivity(intent);
    }

    public void goToChestWorkout() {
        Intent intent = new Intent(this, WorkoutChest.class);
        startActivity(intent);
    }

    public void goToShoulderWorkout() {
        Intent intent = new Intent(this, WorkoutShoulder.class);
        startActivity(intent);
    }

    public void goToLegsWorkout() {
        Intent intent = new Intent(this, WorkoutLegs.class);
        startActivity(intent);
    }

    public void goToArmsWorkout() {
        Intent intent = new Intent(this, WorkoutArms.class);
        startActivity(intent);
    }


}