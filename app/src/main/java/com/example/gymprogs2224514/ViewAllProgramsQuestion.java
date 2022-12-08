package com.example.gymprogs2224514;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class ViewAllProgramsQuestion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_programs_question);

        ImageButton backQMark = findViewById(R.id.backFromQMark);

        backQMark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backToViewAllProgramsActivity();
            }
        });
    }
    public void backToViewAllProgramsActivity() {
        Intent intent = new Intent(this, ViewAllProgramsActivity.class);
        startActivity(intent);
    }

    }
