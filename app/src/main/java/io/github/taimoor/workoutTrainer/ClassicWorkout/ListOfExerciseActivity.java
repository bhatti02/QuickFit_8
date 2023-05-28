package io.github.taimoor.workoutTrainer.ClassicWorkout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import io.github.taimoor.workoutTrainer.R;

public class ListOfExerciseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_exercise);
        Button btnGo = findViewById(R.id.btnGO);
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // exerciseStarted();
                Intent intent = new Intent(ListOfExerciseActivity.this,ClassicExerciseActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

//    public void exerciseStarted(){
//        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
//        Workout workout = new Workout("Classic", new Date().getTime(), 0);
//        FirebaseFirestore fireStore = FirebaseFirestore.getInstance();
//        fireStore
//                .collection("workout_history")
//                .document(user.getUid())
//                .collection("workouts")
//                .add(workout.toMap());
//    }

}
