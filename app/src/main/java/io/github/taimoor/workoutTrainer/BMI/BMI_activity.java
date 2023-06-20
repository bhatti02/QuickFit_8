package io.github.taimoor.workoutTrainer.BMI;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import java.text.DecimalFormat;

import io.github.taimoor.workoutTrainer.Activities.SuggestPlanActivity;
import io.github.taimoor.workoutTrainer.R;

public class BMI_activity extends AppCompatActivity {
    EditText age,height,weight;
    Button calculate , btnDietPlan;
    TextView result;
    TextView underweight;
    TextView underweight_value;
    TextView healthy;
    TextView healthy_value;
    TextView overweight;
    TextView overweight_value;
    TextView obese;
    TextView obese_value;

    String bmiResult = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_activity);
        age=findViewById(R.id.ed_age);
        height=findViewById(R.id.ed_height);
        weight=findViewById(R.id.ed_weight);
        calculate=findViewById(R.id.btn_calculate);
        result=findViewById(R.id.Result);
        underweight=findViewById(R.id.underweight);
        underweight_value=findViewById(R.id.underweight_value);
        healthy=findViewById(R.id.healthy);
        healthy_value=findViewById(R.id.healthy_value);
        overweight=findViewById(R.id.Overweight);
        overweight_value=findViewById(R.id.overweight_value);
        obese=findViewById(R.id.Obese);
        obese_value=findViewById(R.id.Obese_value);
        btnDietPlan = findViewById(R.id.btn_diet_plan);


        calculate.setOnClickListener(v -> {

            if (validate()){
                Double bmi = calculateBMI("Male");
                final DecimalFormat df = new DecimalFormat(".#") ;

                result.setText("Your BMI is: "+df.format(bmi));

                if(bmi<18.5)
                {
                    bmiResult = "underweight";
                    underweight.setBackgroundColor(Color.YELLOW);
                    underweight_value.setBackgroundColor(Color.YELLOW);

                    healthy.setBackgroundColor(Color.WHITE);
                    healthy_value.setBackgroundColor(Color.WHITE);
                    overweight.setBackgroundColor(Color.WHITE);
                    overweight_value.setBackgroundColor(Color.WHITE);
                    obese.setBackgroundColor(Color.WHITE);
                    obese_value.setBackgroundColor(Color.WHITE);
                }
                else if(bmi >= 18.5 && bmi <= 24.9)
                {
                    bmiResult = "healthy";
                    underweight.setBackgroundColor(Color.WHITE);
                    underweight_value.setBackgroundColor(Color.WHITE);

                    healthy.setBackgroundColor(Color.YELLOW);
                    healthy_value.setBackgroundColor(Color.YELLOW);
                    overweight.setBackgroundColor(Color.WHITE);
                    overweight_value.setBackgroundColor(Color.WHITE);
                    obese.setBackgroundColor(Color.WHITE);
                    obese_value.setBackgroundColor(Color.WHITE);
                }
                else if(bmi >= 25.0 && bmi <= 29.9)
                {
                    bmiResult = "overweight";
                    underweight.setBackgroundColor(Color.WHITE);
                    underweight_value.setBackgroundColor(Color.WHITE);

                    healthy.setBackgroundColor(Color.WHITE);
                    healthy_value.setBackgroundColor(Color.WHITE);
                    overweight.setBackgroundColor(Color.YELLOW);
                    overweight_value.setBackgroundColor(Color.YELLOW);
                    obese.setBackgroundColor(Color.WHITE);
                    obese_value.setBackgroundColor(Color.WHITE);
                }
                else
                {
                    bmiResult = "obese";
                    underweight.setBackgroundColor(Color.WHITE);
                    underweight_value.setBackgroundColor(Color.WHITE);

                    healthy.setBackgroundColor(Color.WHITE);
                    healthy_value.setBackgroundColor(Color.WHITE);
                    overweight.setBackgroundColor(Color.WHITE);
                    overweight_value.setBackgroundColor(Color.WHITE);
                    obese.setBackgroundColor(Color.YELLOW);
                    obese_value.setBackgroundColor(Color.YELLOW);
                }
            }


        });

        btnDietPlan.setOnClickListener(v ->{
         if (!bmiResult.isEmpty()){
             generateWorkoutPlan();
         }
         else {
             Toast.makeText(this, "Calculate your BMI first!", Toast.LENGTH_SHORT).show();
         }
        });

    }

    private void generateWorkoutPlan() {

        Intent intent = new Intent(this , SuggestPlanActivity.class);
        intent.putExtra("BMI_Result" , bmiResult);
        startActivity(intent);
    }

    public Double calculateBMI(String gender ){
        double wt;
        double ht;
        Double htinmeter;
        double bmi = 0.0;

        if(gender.equals("Male")) {
            wt=Double.parseDouble(weight.getText().toString()) ;
            ht=Double.parseDouble(height.getText().toString()) ;
            htinmeter=ht*0.3048;
            bmi=wt/(htinmeter*htinmeter);
        }
        return bmi;
    }

    private boolean validate() {
        boolean isValid = true;

        // Check the first EditText field
        if (TextUtils.isEmpty(age.getText().toString())) {
            age.setError("Field cannot be empty");
            isValid = false;
        }

        // Check the second EditText field
        if (TextUtils.isEmpty(height.getText().toString())) {
            height.setError("Field cannot be empty");
            isValid = false;
        }

        if (TextUtils.isEmpty(weight.getText().toString())) {
            weight.setError("Field cannot be empty");
            isValid = false;
        }
        return isValid;
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
