package io.github.taimoor.workoutTrainer.Activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import io.github.taimoor.workoutTrainer.Fragments.PlanFour;
import io.github.taimoor.workoutTrainer.Fragments.PlanOne;
import io.github.taimoor.workoutTrainer.Fragments.PlanThree;
import io.github.taimoor.workoutTrainer.Fragments.PlanTwo;
import io.github.taimoor.workoutTrainer.R;

public class SuggestPlanActivity extends AppCompatActivity {
    public static final String SELECTED_FRAGMENT = "selectedFragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggest_plan);

        // Fetch value from previous activity and launch fragment accordingly
        String BMI_value = getIntent().getStringExtra("BMI_Result");
        openSelectedFragment(BMI_value);
    }

    // Switch cases for selection of fragment
    private void openSelectedFragment(String selectedFragment) {
        switch (selectedFragment) {
            case "underweight":
                launchFragment(new PlanOne());
                break;
            case "healthy":
                launchFragment(new PlanTwo());
                break;
            case "overweight":
                launchFragment(new PlanThree());
                break;
            case "obese":
                launchFragment(new PlanFour());
                break;
        }
    }

    // Launch desired fragment
    private void launchFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .add(R.id.frameLayout, fragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
