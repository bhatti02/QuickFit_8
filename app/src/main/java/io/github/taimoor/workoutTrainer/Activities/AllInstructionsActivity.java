package io.github.taimoor.workoutTrainer.Activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import io.github.taimoor.workoutTrainer.AbsWorkout.AbsInstructionsActivity;
import io.github.taimoor.workoutTrainer.ArmWorkout.ArmInstructionsActivity;
import io.github.taimoor.workoutTrainer.BMI.BMI_activity;
import io.github.taimoor.workoutTrainer.ButtWorkout.ButtInstructionsActivity;
import io.github.taimoor.workoutTrainer.ClassicWorkout.ClassicInstructionsActivity;
import io.github.taimoor.workoutTrainer.LegWorkout.LegInstructionsActivity;
import io.github.taimoor.workoutTrainer.R;

public class AllInstructionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_instructions);
        androidx.appcompat.widget.Toolbar toolbar =findViewById(R.id.allInstToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Instructions");
        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            finish();
            }
        });
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.action_instructions);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_BMI:
                        Intent intent3 = new Intent(AllInstructionsActivity.this, BMI_activity.class);
                        startActivity(intent3);
                        break;
                    case R.id.action_home:
                        Intent intent = new Intent(AllInstructionsActivity.this,MainActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.action_about_us:
                        Intent intent2 = new Intent(AllInstructionsActivity.this,AboutUsActivity.class);
                        startActivity(intent2);
                        break;
                }
                return true;
            }
        });

        Button btnClassicInst = findViewById(R.id.btnClassicIconInstructions);
        btnClassicInst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AllInstructionsActivity.this, ClassicInstructionsActivity.class);
                startActivity(intent);
            }
        });

        Button btnAbsInst = findViewById(R.id.btnAbsIconInstructions);
        btnAbsInst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AllInstructionsActivity.this, AbsInstructionsActivity.class);
                startActivity(intent);
            }
        });

       Button btnArmsInst = findViewById(R.id.btnArmIconInstructions);
       btnArmsInst.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent(AllInstructionsActivity.this ,ArmInstructionsActivity.class );
               startActivity(intent);
           }
       });

       Button btnButtInst = findViewById(R.id.btnButtIconInstructions);
       btnButtInst.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent(AllInstructionsActivity.this, ButtInstructionsActivity.class);
               startActivity(intent);
           }
       });

        Button btnLegInst = findViewById(R.id.btnLegIconInstructions);
        btnLegInst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AllInstructionsActivity.this, LegInstructionsActivity.class);
                startActivity(intent);
            }
        });
    }
}
