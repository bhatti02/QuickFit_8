package io.github.hashim.workoutTrainer.AbsWorkout;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

import io.github.hashim.workoutTrainer.R;
import pl.droidsonroids.gif.GifImageView;

public class AbsExerciseActivity extends AppCompatActivity implements  TextToSpeech.OnInitListener{

    int progress;
    TextToSpeech textToSpeech;
    public String tempSpeech;
    public TextView num;
    public ImageButton skip;
    public TextView ready;
    public TextView exeName;
    public ProgressBar progressBar;
    public int exeRestNum = 0;
    public int exeNum = 0;
    public MediaPlayer mp ;
    int hash=0;
    Boolean goToInstructions = false ;
    CountDownTimer countDownTimer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abs_exercise);
        androidx.appcompat.widget.Toolbar toolbar =findViewById(R.id.absToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Abs Workout");
        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialogCreate();
            }
        });
        textToSpeech = new TextToSpeech(AbsExerciseActivity.this, AbsExerciseActivity.this);
        setUpUI(16000);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.instructions_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_instructions:
                AlertDialogCreate();
                goToInstructions = true;
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onDestroy() {
        countDownTimer.cancel();
        textToSpeech.shutdown();
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        AlertDialogCreate();
    }

    public void setUpUI(final long startTime)

    {
        exeName = findViewById(R.id.absExerciseName);
        num = findViewById(R.id.tvAbsNum);
        ready = findViewById(R.id.absReady);
        skip = findViewById(R.id.absSkip);
        progressBar = findViewById(R.id.absProgressBar);
        GifImageView gifImageView = findViewById(R.id.gifAbsImageView);
        progressBar.setProgress(0);
        final long time = startTime;

        if (startTime == 16000)
        {
            if (exeRestNum == 0) {
                ready.setText("Make Yourself Ready !");
                exeName.setText("1/14 Jumping Squats");
                gifImageView.setImageResource(R.drawable.jumping_squats);
                setTempSpeech("Make yourself ready . exercise 1 of 14 Jumping Squats ");
                speek();
            } else if (exeRestNum == 1) {
                ready.setText("Make Yourself Ready !");
                exeName.setText("2/14 Reverse Crunches");
                gifImageView.setImageResource(R.drawable.reverse_crunches);
                setTempSpeech("Take Rest Make yourself ready . exercise 2 of 14 Reverse Crunches");
                speek();
            } else if (exeRestNum == 2) {
                ready.setText("Make Yourself Ready !");
                exeName.setText("3/14 Straight Arm Plank");
                gifImageView.setImageResource(R.drawable.strightarmplank);
                setTempSpeech("Take rest Make yourself ready . exercise 3 of 14 straight arm plank");
                speek();
            } else if (exeRestNum == 3) {
                ready.setText("Make Yourself Ready !");
                gifImageView.setImageResource(R.drawable.russiantwist);
                exeName.setText("4/14 russian twist");
                setTempSpeech("Take rest Make yourself ready . exercise 4 of 14 russian twist");
                speek();
            } else if (exeRestNum == 4) {
                ready.setText("Make Yourself Ready !");
                gifImageView.setImageResource(R.drawable.bird_dog);
                exeName.setText("5/14 Bird Dog");
                setTempSpeech("take rest Make yourself ready . exercise 5 of 14 bird dog");
                speek();
            } else if (exeRestNum == 5) {
                ready.setText("Make Yourself Ready !");
                exeName.setText("6/14 Burpees");
                gifImageView.setImageResource(R.drawable.burpees);
                setTempSpeech("take rest Make yourself ready . exercise 6 of 14 burpees");
                speek();
            } else if (exeRestNum == 6) {
                ready.setText("Make Yourself Ready !");
                exeName.setText("7/14 Long Arm Crunches");
                gifImageView.setImageResource(R.drawable.long_arm_crunches);
                setTempSpeech("take rest Make yourself ready . exercise 7 of 14 long arm crunches");
                speek();
            } else if (exeRestNum == 7) {
                ready.setText("Make Yourself Ready !");
                exeName.setText("8/14 One Leg Bridge");
                gifImageView.setImageResource(R.drawable.leg_bridge);
                setTempSpeech("take rest Make yourself ready . exercise 8 of 14 one leg bridge");
                speek();
            } else if (exeRestNum == 8) {
                ready.setText("Make Yourself Ready !");
                exeName.setText("9/14 One Leg Pushups");
                gifImageView.setImageResource(R.drawable.one_leg_pushup);
                setTempSpeech("take rest Make yourself ready . exercise 9 of 14 one leg pushups");
                speek();
            } else if (exeRestNum == 9) {
                ready.setText("Make Yourself Ready !");
                exeName.setText("10/14 Plank");
                gifImageView.setImageResource(R.drawable.plank);
                setTempSpeech("take rest Make yourself ready . exercise 10 of 14 plank");
                speek();
            } else if (exeRestNum == 10) {
                ready.setText("Make Yourself Ready !");
                exeName.setText("11/14 Cross Arm Crunches");
                gifImageView.setImageResource(R.drawable.crose_arm_crunches);
                setTempSpeech("take rest Make yourself ready . exercise 11 of 14 cross arm crunches");
                speek();
            } else if (exeRestNum == 11) {
                ready.setText("Make Yourself Ready !");
                exeName.setText("12/14 Mountain Climber");
                gifImageView.setImageResource(R.drawable.mountain_climber);
                setTempSpeech("Make yourself ready . exercise 12 of 14 mountain climber");
                speek();
            } else if (exeRestNum == 12) {
                ready.setText("Make Yourself Ready !");
                exeName.setText("13/14 Bridge");
                gifImageView.setImageResource(R.drawable.bridge);
                setTempSpeech("Make yourself ready . exercise 13 of 14 bridge");
                speek();
            }
            else if (exeRestNum == 13) {
                ready.setText("Make Yourself Ready !");
                exeName.setText("14/14 Bicycle Crunches");
                gifImageView.setImageResource(R.drawable.bicycle_crunches);
                setTempSpeech("Make yourself ready . exercise 14 of 14 bicycle crunches");
                speek();
            }
            else {
                CongoDialogCreate();
            }
        }
        if (startTime == 31000) {
            mp = MediaPlayer.create(getApplicationContext(), R.raw.whistle_sound);
            mp.start();
        }

        countDownTimer = new CountDownTimer(time, 1000)
        {

            private void endSpeeking(){
                cancel();
            }

            @Override
            public void onTick(long l) {

                skip.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        hash=1;
                    }
                });
                if(hash==1){
                    cancel();
                    onFinish();
                }

                if(hash != 1) {
                    num.setText("" + l / 1000);
                    if (time == 16000) {
                        progress = (int) (progress + 6.7);
                        progressBar.setProgress(progress);
                        if (l / 1000 == 3) {
                            setTempSpeech("3");
                            speek();
                        }
                        if (l / 1000 == 2) {
                            setTempSpeech("2");
                            speek();
                        }
                        if (l / 1000 == 1) {
                            setTempSpeech("1");
                            speek();
                        }
                    } else {

                        if (l / 1000 == 15) {
                            setTempSpeech("half the time");
                            speek();
                        }
                        if (l / 1000 == 3) {
                            setTempSpeech("3");
                            speek();
                        }
                        if (l / 1000 == 2) {
                            setTempSpeech("2");
                            speek();
                        }
                        if (l / 1000 == 1) {
                            setTempSpeech("1");
                            speek();
                        }
                        progress = (int) (progress + 3.5);
                        progressBar.setProgress(progress);
                    }
                }
            }

            @Override
            public void onFinish() {
                hash=0;
                if (time == 16000) {
                    ready.setText("Start Exercise");
                    exeRestNum++;
                    num.setText("0");
                    progressBar.setProgress(100);
                    progress = 0;
                    setUpUI(31000);
                }
                if (time == 31000) {
                    ready.setText("Make Yourself Ready !");
                    exeNum++;
                    num.setText("0");
                    progressBar.setProgress(100);
                    progress = 0;
                    setUpUI(16000);
                }
            }
        }.start();

    }

    public void speek() {
        TextToSpeechFunction();
    }

    public void TextToSpeechFunction() {
        String speech = getTempSpeech();
        textToSpeech.speak(speech, TextToSpeech.QUEUE_FLUSH, null);
        speech = "";
    }

    @Override
    public void onInit(int Text2SpeechCurrentStatus) {
        if (Text2SpeechCurrentStatus == TextToSpeech.SUCCESS) {
            textToSpeech.setLanguage(Locale.US);
            TextToSpeechFunction();
        }

    }

    public String getTempSpeech() {
        return tempSpeech;
    }

    public void setTempSpeech(String tempSpeech1) {
        tempSpeech = tempSpeech1;
    }

    public void CongoDialogCreate(){
        LayoutInflater factory = LayoutInflater.from(AbsExerciseActivity.this);
        final View view = factory.inflate(R.layout.sample, null);

        new AlertDialog.Builder(AbsExerciseActivity.this)
                .setView(view)
                .setPositiveButton("OK",null)
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        countDownTimer.cancel();
                        finish();
                    }
                }).show();
    }





    public void AlertDialogCreate(){
        new AlertDialog.Builder(AbsExerciseActivity.this)
                .setIcon(R.mipmap.ic_launcher)
                .setTitle("8 MINUTES")
                .setMessage("Are you sure Exit 8 MINUTES Workout ? ")
                .setPositiveButton("OK", null)
                .setNegativeButton("Cancel", null)
                .setPositiveButton("OK", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        setTempSpeech("");
                        if (mp != null )
                        {
                            mp.stop();
                            mp.pause();
                        }
                        countDownTimer.cancel();
                        finish();
                        if (goToInstructions.booleanValue() == true  ){
                            goToInstructions= false;
                            Intent intent = new Intent(AbsExerciseActivity.this, AbsInstructionsActivity.class);
                            startActivity(intent);
                        }

                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                    }
                }).show();
    }

}
