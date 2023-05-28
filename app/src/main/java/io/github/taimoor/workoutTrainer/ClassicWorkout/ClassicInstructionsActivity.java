package io.github.taimoor.workoutTrainer.ClassicWorkout;

import android.graphics.Color;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import io.github.taimoor.workoutTrainer.R;

public class ClassicInstructionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classic_instructions);
        androidx.appcompat.widget.Toolbar toolbar =findViewById(R.id.classicInstructionToolbar);
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


    }
}
