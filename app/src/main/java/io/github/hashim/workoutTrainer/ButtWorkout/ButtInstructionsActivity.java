package io.github.hashim.workoutTrainer.ButtWorkout;

import android.graphics.Color;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import io.github.hashim.workoutTrainer.R;

public class ButtInstructionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_butt_instructions);
        androidx.appcompat.widget.Toolbar toolbar =findViewById(R.id.buttInstructionToolbar);
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
