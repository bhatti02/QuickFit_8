package io.github.taimoor.workoutTrainer.BMI;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

import io.github.taimoor.workoutTrainer.R;

public class BMI_activity extends AppCompatActivity {
    EditText age,height,weight;
    Button calculate;
    TextView result,underweight,underweight_value,healthy,healthy_value,overweight,overweight_value,obese,obese_value;
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

//create a list of items for the spinner.
      //  String[] items = new String[]{"cm", "ft+in"};
//create an adapter to describe how the items are displayed, adapters are used in several places in android.
//There are multiple variations of this, but this is the basic variant.
        //ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
//set the spinners adapter to the previously created one.
        //dropdown.setAdapter(adapter);

        //dropdown = findViewById(R.id.spinner2);
//create a list of items for the spinner.
        //items = new String[]{"kg", "lb(pound)"};
//create an adapter to describe how the items are displayed, adapters are used in several places in android.
//There are multiple variations of this, but this is the basic variant.
        //adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
//set the spinners adapter to the previously created one.
        //dropdown.setAdapter(adapter);


        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Double bmi = calculateBMI("Male");
                final DecimalFormat df = new DecimalFormat(".#") ;

                result.setText("Your BMI is: "+df.format(bmi));

                if(bmi<18.5)
                {
                    underweight.setBackgroundColor(Color.YELLOW);
                    underweight_value.setBackgroundColor(Color.YELLOW);
                }
                else if(bmi >= 18.5 && bmi <= 24.9)
                {
                    healthy.setBackgroundColor(Color.YELLOW);
                    healthy_value.setBackgroundColor(Color.YELLOW);
                }
                else if(bmi >= 25.0 && bmi <= 29.9)
                {
                    overweight.setBackgroundColor(Color.YELLOW);
                    overweight_value.setBackgroundColor(Color.YELLOW);
                }
                else
                {
                    obese.setBackgroundColor(Color.YELLOW);
                    obese_value.setBackgroundColor(Color.YELLOW);
                }
            }
        });

    }
    public Double calculateBMI(String gender ){
        Double wt,ht,htinmeter, bmi = 0.0;

        if(gender.equals("Male")) {
            wt=Double.parseDouble(weight.getText().toString()) ;
            ht=Double.parseDouble(height.getText().toString()) ;
            htinmeter=ht*0.3048;
            bmi=wt/(htinmeter*htinmeter);
        }
        else{

        }
        return bmi;

    }
}
