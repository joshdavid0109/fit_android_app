package com.example.gymprogs2224514;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.gymprogs2224514.MainActivity.mainActivityStatus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class ViewAllProgramsHIIT extends AppCompatActivity {

    public static int launchStatePrograms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_programs_hiit);

        ImageButton backButt = findViewById(R.id.backFromHiit);
        Button startHitt = findViewById(R.id.hiitProgramStart);

        backButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mainActivityStatus > 1) {
                    BackToViewAll();
                } else
                    BackToMainActivity();

            }
        });

        startHitt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GoToHIITProgram();
            }
        });

    }

    public void BackToViewAll() {
        Intent intent = new Intent(this, ViewAllProgramsActivity.class);
        mainActivityStatus = 0;
        startActivity(intent);
    }

    public void BackToMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        // Reset mainActivityStatus
        mainActivityStatus = 0;
        startActivity(intent);
    }

    public void GoToHIITProgram() {
        Intent intent = new Intent(this, ViewAllProgramsTimer.class);
        mainActivityStatus = 0;
        launchStatePrograms = 1;
        startActivity(intent);
    }
}