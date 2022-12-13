package com.example.gymprogs2224514;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.gymprogs2224514.MainActivity.mainActivityStatus;
import static com.example.gymprogs2224514.ViewAllProgramsHIIT.launchStatePrograms;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class ViewAllProgramsFullBody extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_programs_full_body);
        ImageButton backButt = findViewById(R.id.backFromFullBody);
        Button startFullBody = findViewById(R.id.startFullBody);

        backButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BackToViewAll();
            }

        });

        startFullBody.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              GoToFullBodyProgram();
            }

        });
    }

    public void BackToViewAll() {
        Intent intent = new Intent(this, ViewAllProgramsActivity.class);
        startActivity(intent);
    }

    public void GoToFullBodyProgram() {
        Intent intent = new Intent(this, ViewAllProgramsTimer.class);
        launchStatePrograms = 5;
        startActivity(intent);
    }
}