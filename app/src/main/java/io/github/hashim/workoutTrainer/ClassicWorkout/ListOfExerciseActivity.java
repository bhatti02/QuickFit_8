package io.github.hashim.workoutTrainer.ClassicWorkout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import io.github.hashim.workoutTrainer.R;

public class ListOfExerciseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_exercise);
        final AdView mAdView = findViewById(R.id.adClassicView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        mAdView.setAdListener(new AdListener(){
            @Override
            public void onAdLoaded() {
                mAdView.setVisibility(View.VISIBLE);
            }

        });
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
