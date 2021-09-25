package io.github.hashim.workoutTrainer.Activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import io.github.hashim.workoutTrainer.BMI.BMI_activity;
import io.github.hashim.workoutTrainer.R;

public class AboutUsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        androidx.appcompat.widget.Toolbar toolbar =findViewById(R.id.aboutUsToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("About Us");
        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.action_about_us);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_BMI:
                        Intent intent3 = new Intent(AboutUsActivity.this, BMI_activity.class);
                        startActivity(intent3);
                        break;
                    case R.id.action_instructions:
                        Intent intent = new Intent(AboutUsActivity.this,AllInstructionsActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.action_home:
                        Intent intent2 = new Intent(AboutUsActivity.this,MainActivity.class);
                        startActivity(intent2);
                        break;
                }
                return true;
            }
        });
    }
}
