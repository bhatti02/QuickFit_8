package io.github.taimoor.workoutTrainer.Activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import io.github.taimoor.workoutTrainer.R;

public class WorkoutPlanActivity extends AppCompatActivity {

    String age;
    String height;
    String weight;
    TextView tvPlan;
    EditText ageEditText;
    EditText weightEditText;
    EditText heightEditText;
    EditText genderSpinner;
    EditText goalsEditText;
    EditText daysEditText;
    EditText mealsEditText;
    EditText snacksEditText;

    Button btn_getPlan;
    Intent intent;

    String authToken = "Bearer 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";
    String prompt = "";
    private String gender;
    private String PrimaryFitnessHealthGoals;
    private String daysInGym;
    private String mealsPerDay;
    private String snacksPerDay;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_plan);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Generating your plan...");
        progressDialog.setCancelable(false);

        tvPlan = findViewById(R.id.tvPlan);

        ageEditText = findViewById(R.id.ageEditText);
        weightEditText = findViewById(R.id.weightEditText);
        heightEditText = findViewById(R.id.heightEditText);
        genderSpinner = findViewById(R.id.genderSpinner);
        goalsEditText = findViewById(R.id.goalsEditText);
        daysEditText = findViewById(R.id.daysEditText);
        mealsEditText = findViewById(R.id.mealsEditText);
        snacksEditText = findViewById(R.id.snacksEditText);

        btn_getPlan = findViewById(R.id.btn_getPlan);

        age = ageEditText.getText().toString();
        gender = genderSpinner.getText().toString();
        height = heightEditText.getText().toString();
        weight = weightEditText.getText().toString();
        PrimaryFitnessHealthGoals = goalsEditText.getText().toString();
        daysInGym = daysEditText.getText().toString();
        mealsPerDay = mealsEditText.getText().toString();
        snacksPerDay = snacksEditText.getText().toString();

        prompt = "You are a highly renowned health and nutrition expert FitnessGPT. " +
                "Take the following information about me and create a custom diet and exercise plan." +
                " I am "+age+" years old, "+gender+", "+height+". My current weight is "+weight+". " +
                "My current medical conditions are healthy. I have food allergies to none. " +
                "My primary fitness and health goals are "+PrimaryFitnessHealthGoals+". " +
                "I can commit to working out "+daysInGym+" days per week. I want to have "+mealsPerDay+" Meals and "+snacksPerDay+" Snacks." +
                "Create a detailed workout program for my exercise plan. " +
                "Create a detailed Meal Plan for my diet. " +
                "Avoid any superfluous pre and post descriptive text. " +
                "Don't break character under any circumstance.";
        btn_getPlan.setOnClickListener(v -> {
                if (validate()){
                    progressDialog.show();
                    generatePlan(prompt);
                }

        });

    }

    private boolean validate() {
        boolean isValid = true;

        // Check the first EditText field
        if (TextUtils.isEmpty(ageEditText.getText().toString())) {
            ageEditText.setError("Field cannot be empty");
            isValid = false;
        }

        // Check the second EditText field
        if (TextUtils.isEmpty(heightEditText.getText().toString())) {
            heightEditText.setError("Field cannot be empty");
            isValid = false;
        }

        if (TextUtils.isEmpty(weightEditText.getText().toString())) {
            weightEditText.setError("Field cannot be empty");
            isValid = false;
        }

        if (TextUtils.isEmpty(genderSpinner.getText().toString())) {
            genderSpinner.setError("Field cannot be empty");
            isValid = false;
        }

        if (TextUtils.isEmpty(goalsEditText.getText().toString())) {
            goalsEditText.setError("Field cannot be empty");
            isValid = false;
        }

        if (TextUtils.isEmpty(daysEditText.getText().toString())) {
            daysEditText.setError("Field cannot be empty");
            isValid = false;
        }

        if (TextUtils.isEmpty(mealsEditText.getText().toString())) {
            mealsEditText.setError("Field cannot be empty");
            isValid = false;
        }

        if (TextUtils.isEmpty(snacksEditText.getText().toString())) {
            snacksEditText.setError("Field cannot be empty");
            isValid = false;
        }
        return isValid;

    }

    private void generatePlan(String promptMessage) {

        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("model", "text-davinci-003");
            jsonObject.put("prompt", promptMessage);
            jsonObject.put("max_tokens", 100);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest postRequest = new JsonObjectRequest(Request.Method.POST, "https://api.openai.com/v1/completions", jsonObject,
                response -> {
                    try {
                        String responseMsg = response.getJSONArray("choices").getJSONObject(0).getString("text");
                        progressDialog.dismiss();
                        tvPlan.setText(responseMsg);
                        tvPlan.setVisibility(View.VISIBLE);
                    } catch (JSONException e) {
                        progressDialog.dismiss();
                        e.printStackTrace();
                    }
                },
                error -> progressDialog.dismiss())
        {
            @Override
            public Map<String, String> getHeaders() {
                Map<String, String> params = new HashMap<>();
                params.put("Content-Type", "application/json");
                params.put("Authorization", authToken);
                return params;
            }
        };

        postRequest.setRetryPolicy(new DefaultRetryPolicy(
                0,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        queue.add(postRequest);

    }
}