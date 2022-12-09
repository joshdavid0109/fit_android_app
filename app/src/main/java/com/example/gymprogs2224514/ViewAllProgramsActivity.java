package com.example.gymprogs2224514;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ViewAllProgramsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all);

        ImageButton backButt = findViewById(R.id.backButton);
        ImageButton qMarkPrograms = findViewById(R.id.qMarkPrograms);
        ImageButton hiitButt = findViewById(R.id.mainProgram);
        ImageButton weightButt = findViewById(R.id.weightButt);
        ImageButton muscleButt = findViewById(R.id.muscleButt);
        ImageButton strengthButt = findViewById(R.id.strengthButt);
        ImageButton fullButt = findViewById(R.id.fullButt);

        backButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BackToMainActivity();
            }
        });

        qMarkPrograms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToViewAllProgramsQuestion();
            }
        });
        hiitButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GoToHiitProgram();
            }
        });
        weightButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GoToWeightProgram();
            }
        });
        muscleButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GoToMuscleProgram();
            }
        });
        strengthButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GoToStrengthProgram();
            }
        });
        fullButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GoToFullBodyProgram();
            }
        });
    }

    public void BackToMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void ToViewAllProgramsQuestion() {
        Intent intent = new Intent(this, ViewAllProgramsQuestion.class);
        startActivity(intent);
    }

    public void GoToHiitProgram() {
        Intent intent = new Intent(this, ViewAllProgramsHIIT.class);
        startActivity(intent);
    }

    public void GoToWeightProgram() {
        Intent intent = new Intent(this, ViewAllProgramsWeightLoss.class);
        startActivity(intent);
    }

    public void GoToMuscleProgram() {
        Intent intent = new Intent(this, ViewAllProgramsMuscle.class);
        startActivity(intent);
    }

    public void GoToStrengthProgram() {
        Intent intent = new Intent(this, ViewAllProgramsStrength.class);
        startActivity(intent);
    }

    public void GoToFullBodyProgram() {
        Intent intent = new Intent(this, ViewAllProgramsFullBody.class);
        startActivity(intent);
    }
}