package com.example.gymprogs2224514;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.gymprogs2224514.MainActivity.mainActivityStatus;
import static com.example.gymprogs2224514.ViewAllProgramsHIIT.launchStatePrograms;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class ViewAllProgramsMuscle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_programs_muscle);

        ImageButton backButt = findViewById(R.id.backFromMuscle);
        Button startMuscle = findViewById(R.id.startMuscle);

        backButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BackToViewAll();
            }

        });


       startMuscle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GoToMuscleProgram();
            }

        });
    }

    public void BackToViewAll() {
        Intent intent = new Intent(this, ViewAllProgramsActivity.class);
        launchStatePrograms = 2;
        startActivity(intent);
    }

    public void GoToMuscleProgram() {
        Intent intent = new Intent(this, ViewAllProgramsTimer.class);
        mainActivityStatus = 0;
        launchStatePrograms = 2;
        startActivity(intent);
    }
}

