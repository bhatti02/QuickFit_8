package io.github.hashim.workoutTrainer.BMI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import io.github.hashim.workoutTrainer.R;

public class BMIMainActivity extends AppCompatActivity {

    Button bmi;
    Button waist;
    Button bodyfat;
    Button metabolicrate;
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmimain);
        bmi=findViewById(R.id.btn_BMI);
        waist=findViewById(R.id.btn_waist);
        bodyfat=findViewById(R.id.btn_BodyFat);
        metabolicrate=findViewById(R.id.btn_MetabolicRate);
        bmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(BMIMainActivity.this, BMI_activity.class);
                startActivity(intent);
            }
        });
//        waist.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(BMIMainActivity.this,waist_to_height_ratio_activity.class);
//                startActivity(intent);
//            }
//        });
//        bodyfat.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(BMIMainActivity.this,body_fat_percentage_activity.class);
//                startActivity(intent);
//            }
//        });
//        metabolicrate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(BMIMainActivity.this,Basal_Metabolic_Rate_activity.class);
//                startActivity(intent);
//            }
//        });
    }
}
