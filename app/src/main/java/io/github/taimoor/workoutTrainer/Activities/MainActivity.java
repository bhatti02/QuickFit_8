package io.github.taimoor.workoutTrainer.Activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.squareup.picasso.Picasso;

import io.github.taimoor.workoutTrainer.AbsWorkout.AbsInstructionsActivity;
import io.github.taimoor.workoutTrainer.AbsWorkout.ListOfAbsExercisesActivity;
import io.github.taimoor.workoutTrainer.ArmWorkout.ArmInstructionsActivity;
import io.github.taimoor.workoutTrainer.ArmWorkout.ListOfArmExerciseActivity;
import io.github.taimoor.workoutTrainer.BMI.BMI_activity;
import io.github.taimoor.workoutTrainer.ButtWorkout.ButtInstructionsActivity;
import io.github.taimoor.workoutTrainer.ButtWorkout.ListOfButtExerciseActivity;
import io.github.taimoor.workoutTrainer.ClassicWorkout.ClassicInstructionsActivity;
import io.github.taimoor.workoutTrainer.ClassicWorkout.ListOfExerciseActivity;
import io.github.taimoor.workoutTrainer.LegWorkout.LegInstructionsActivity;
import io.github.taimoor.workoutTrainer.LegWorkout.ListOfLegExerciseActivity;
import io.github.taimoor.workoutTrainer.R;

public class MainActivity extends AppCompatActivity {
    @Override
    public void onBackPressed() {
        finishAffinity();
    }

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ImageView imageView = findViewById(R.id.imageView);
        Picasso.get().load(R.drawable.workout).into(imageView);

        ImageView absImage =findViewById(R.id.absImg);
        Picasso.get().load(R.drawable.absworkout).into(absImage);


        ImageView armImage =findViewById(R.id.armImg);
        Picasso.get().load(R.drawable.arms).into(armImage);


        ImageView buttImage =findViewById(R.id.ButtImg);
        Picasso.get().load(R.drawable.butts).into(buttImage);

        ImageView LegImage =findViewById(R.id.legImg);
        Picasso.get().load(R.drawable.leg_workout).into(LegImage);

        androidx.appcompat.widget.Toolbar toolbar =findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Intelligent Workout Trainer");

        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.action_BMI) {
                    Intent intent3 = new Intent(MainActivity.this, BMI_activity.class);
                    startActivity(intent3);
                } else if (itemId == R.id.action_instructions) {
                    Intent intent = new Intent(MainActivity.this, AllInstructionsActivity.class);
                    startActivity(intent);
                } else if (itemId == R.id.action_about_us) {
                    Intent intent2 = new Intent(MainActivity.this, AboutUsActivity.class);
                    startActivity(intent2);
                }
                return true;
            }
        });


        Button btnClassicInstructions =findViewById(R.id.btnInstructions);
        btnClassicInstructions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ClassicInstructionsActivity.class);
                startActivity(intent);

            }
        });

        Button btnStart = findViewById(R.id.btnStart);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, ListOfExerciseActivity.class);
                    startActivity(intent);

            }
        });

        Button btnAbsInstructions = findViewById(R.id.btnAbsInstructions);
        btnAbsInstructions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AbsInstructionsActivity.class);
                startActivity(intent);
            }
        });

        Button btnAbsStart = findViewById(R.id.btnAbsStart);
        btnAbsStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, ListOfAbsExercisesActivity.class);
                    startActivity(intent);

            }
        });

        Button btnArmStart = findViewById(R.id.btnArmStart);
        btnArmStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, ListOfArmExerciseActivity.class);
                    startActivity(intent);
            }
        });


        Button btnArmInstructions = findViewById(R.id.btnArmInstructions);
        btnArmInstructions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ArmInstructionsActivity.class);
                startActivity(intent);
            }
        });

        Button btnButtStart = findViewById(R.id.btnButtStart);
        btnButtStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListOfButtExerciseActivity.class);
                startActivity(intent);
            }
        });


        Button btnButtInstructions = findViewById(R.id.btnButtInstructions);
        btnButtInstructions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ButtInstructionsActivity.class);
                startActivity(intent);
            }
        });

        Button btnLegStart = findViewById(R.id.btnLegStart);
        btnLegStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, ListOfLegExerciseActivity.class);
                    startActivity(intent);
                }
        });


        Button btnLegInstructions = findViewById(R.id.btnLegInstructions);
        btnLegInstructions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LegInstructionsActivity.class);
                startActivity(intent);
            }
        });
    }

}
