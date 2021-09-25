package io.github.hashim.workoutTrainer.Activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.squareup.picasso.Picasso;

import io.github.hashim.workoutTrainer.AbsWorkout.AbsInstructionsActivity;
import io.github.hashim.workoutTrainer.AbsWorkout.ListOfAbsExercisesActivity;
import io.github.hashim.workoutTrainer.ArmWorkout.ArmInstructionsActivity;
import io.github.hashim.workoutTrainer.ArmWorkout.ListOfArmExerciseActivity;
import io.github.hashim.workoutTrainer.BMI.BMI_activity;
import io.github.hashim.workoutTrainer.ButtWorkout.ButtInstructionsActivity;
import io.github.hashim.workoutTrainer.ButtWorkout.ListOfButtExerciseActivity;
import io.github.hashim.workoutTrainer.ClassicWorkout.ClassicInstructionsActivity;
import io.github.hashim.workoutTrainer.ClassicWorkout.ListOfExerciseActivity;
import io.github.hashim.workoutTrainer.LegWorkout.LegInstructionsActivity;
import io.github.hashim.workoutTrainer.LegWorkout.ListOfLegExerciseActivity;
import io.github.hashim.workoutTrainer.R;

public class MainActivity extends AppCompatActivity {
    private InterstitialAd mInterstitialAd;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        MobileAds.initialize(this, "ca-app-pub-7407537444619255~6230610124");
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-7407537444619255/2377079305");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());


        AdView mAdView = findViewById(R.id.adMainView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        ImageView imageView = findViewById(R.id.imageView);
        Picasso.get().load(R.drawable.workout).into(imageView);

        ImageView absImage =findViewById(R.id.absImg);
        Picasso.get().load(R.drawable.absworkout).into(absImage);


        ImageView armImage =findViewById(R.id.armImg);
        Picasso.get().load(R.drawable.arms).into(armImage);


        ImageView buttImage =findViewById(R.id.ButtImg);
        Picasso.get().load(R.drawable.butts).into(buttImage);

        ImageView LegImage =findViewById(R.id.legImg);
        Picasso.get().load(R.drawable.leg_workout).into(LegImage);

        androidx.appcompat.widget.Toolbar toolbar =findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("8 MINUTES");

        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_BMI:
                        Intent intent3 = new Intent(MainActivity.this, BMI_activity.class);
                        startActivity(intent3);
                        break;
                    case R.id.action_instructions:
                        Intent intent = new Intent(MainActivity.this,AllInstructionsActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.action_about_us:
                        Intent intent2 = new Intent(MainActivity.this,AboutUsActivity.class);
                        startActivity(intent2);
                        break;
                }
                return true;
            }
        });


        Button btnClassicInstructions =findViewById(R.id.btnInstructions);
        btnClassicInstructions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ClassicInstructionsActivity.class);
                startActivity(intent);

            }
        });

        Button btnStart = findViewById(R.id.btnStart);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                    mInterstitialAd.setAdListener(new AdListener(){
                        @Override
                        public void onAdClosed() {

                            Intent intent = new Intent(MainActivity.this, ListOfExerciseActivity.class);
                            startActivity(intent);
                        }
                    });
                } else {
                    Intent intent = new Intent(MainActivity.this, ListOfExerciseActivity.class);
                    startActivity(intent);
                }
            }
        });

        Button btnAbsInstructions = findViewById(R.id.btnAbsInstructions);
        btnAbsInstructions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AbsInstructionsActivity.class);
                startActivity(intent);
            }
        });

        Button btnAbsStart = findViewById(R.id.btnAbsStart);
        btnAbsStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                    mInterstitialAd.setAdListener(new AdListener(){
                        @Override
                        public void onAdClosed() {

                            Intent intent = new Intent(MainActivity.this, ListOfAbsExercisesActivity.class);
                            startActivity(intent);
                        }
                    });
                } else {
                    Intent intent = new Intent(MainActivity.this, ListOfAbsExercisesActivity.class);
                    startActivity(intent);
                }
            }
        });

        Button btnArmStart = findViewById(R.id.btnArmStart);
        btnArmStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                    mInterstitialAd.setAdListener(new AdListener(){
                        @Override
                        public void onAdClosed() {

                            Intent intent = new Intent(MainActivity.this, ListOfArmExerciseActivity.class);
                            startActivity(intent);
                        }
                    });
                } else {
                    Intent intent = new Intent(MainActivity.this, ListOfArmExerciseActivity.class);
                    startActivity(intent);
                }
            }
        });


        Button btnArmInstructions = findViewById(R.id.btnArmInstructions);
        btnArmInstructions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ArmInstructionsActivity.class);
                startActivity(intent);
            }
        });

        Button btnButtStart = findViewById(R.id.btnButtStart);
        btnButtStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {    if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
                mInterstitialAd.setAdListener(new AdListener(){
                    @Override
                    public void onAdClosed() {

                        Intent intent = new Intent(MainActivity.this, ListOfButtExerciseActivity.class);
                        startActivity(intent);
                    }
                });
            } else {
                Intent intent = new Intent(MainActivity.this, ListOfButtExerciseActivity.class);
                startActivity(intent);
            }
            }
        });


        Button btnButtInstructions = findViewById(R.id.btnButtInstructions);
        btnButtInstructions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ButtInstructionsActivity.class);
                startActivity(intent);
            }
        });

        Button btnLegStart = findViewById(R.id.btnLegStart);
        btnLegStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                    mInterstitialAd.setAdListener(new AdListener(){
                        @Override
                        public void onAdClosed() {

                            Intent intent = new Intent(MainActivity.this, ListOfLegExerciseActivity.class);
                            startActivity(intent);
                        }
                    });
                } else {
                    Intent intent = new Intent(MainActivity.this, ListOfLegExerciseActivity.class);
                    startActivity(intent);
                }
            }
        });


        Button btnLegInstructions = findViewById(R.id.btnLegInstructions);
        btnLegInstructions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LegInstructionsActivity.class);
                startActivity(intent);
            }
        });
    }



//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.options_menus,menu);
//        return super.onCreateOptionsMenu(menu);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.instructions:
//                Intent intent = new Intent(MainActivity.this
//                        , AllInstructionsActivity.class);
//                startActivity(intent);
//                return true;
//            case R.id.about:
//                Intent intent1 = new Intent(MainActivity.this
//                        , AboutUsActivity.class);
//                startActivity(intent1);
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }

}
