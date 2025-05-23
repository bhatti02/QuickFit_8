package io.github.taimoor.workoutTrainer.Activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import io.github.taimoor.workoutTrainer.BMI.BMI_activity;
import io.github.taimoor.workoutTrainer.R;

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
        toolbar.setNavigationOnClickListener(view -> finish());

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.action_about_us);
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
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
        });
    }
}
