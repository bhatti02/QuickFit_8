package io.github.taimoor.workoutTrainer.ArmWorkout;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import io.github.taimoor.workoutTrainer.R;

public class ListOfArmExerciseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_arm_exercise);
        Button btnGo = findViewById(R.id.btnArmGO);
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListOfArmExerciseActivity.this,ArmExerciseActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
