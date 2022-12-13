package com.example.gymprogs2224514;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.gymprogs2224514.MainActivity.mainActivityStatus;
import static com.example.gymprogs2224514.ViewAllProgramsHIIT.launchStatePrograms;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class ViewAllProgramsWeightLoss extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_programs_weight_loss);
        ImageButton backButt = findViewById(R.id.backFromWeight);
        Button startWeight = findViewById(R.id.startWeight);

        backButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BackToViewAll();
            }

        });

        startWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               GoToWeightProgram();
            }

        });
    }

    public void BackToViewAll() {
        Intent intent = new Intent(this, ViewAllProgramsActivity.class);
        startActivity(intent);
    }

    public void GoToWeightProgram() {
        Intent intent = new Intent(this, ViewAllProgramsTimer.class);
        mainActivityStatus = 0;
        launchStatePrograms = 4;
        startActivity(intent);
    }
}