package io.github.hashim.workoutTrainer.Activities;

import android.content.Intent;
import android.graphics.Color;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import io.github.hashim.workoutTrainer.AbsWorkout.AbsInstructionsActivity;
import io.github.hashim.workoutTrainer.ArmWorkout.ArmInstructionsActivity;
import io.github.hashim.workoutTrainer.ButtWorkout.ButtInstructionsActivity;
import io.github.hashim.workoutTrainer.ClassicWorkout.ClassicInstructionsActivity;
import io.github.hashim.workoutTrainer.LegWorkout.LegInstructionsActivity;
import io.github.hashim.workoutTrainer.R;

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
