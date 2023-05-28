package io.github.taimoor.workoutTrainer.ButtWorkout;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.speech.tts.TextToSpeech;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Locale;

import io.github.taimoor.workoutTrainer.R;
import pl.droidsonroids.gif.GifImageView;

public class ButtExerciseActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {
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
        setContentView(R.layout.activity_butt_exercise);
        androidx.appcompat.widget.Toolbar toolbar =findViewById(R.id.buttToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Butt Workout");
        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialogCreate();
            }
        });
        textToSpeech = new TextToSpeech(ButtExerciseActivity.this, ButtExerciseActivity.this);
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
        exeName = findViewById(R.id.buttExerciseName);
        num = findViewById(R.id.tvButtNum);
        ready = findViewById(R.id.buttReady);
        skip = findViewById(R.id.buttSkip);
        progressBar = findViewById(R.id.buttProgressBar);
        GifImageView gifImageView = findViewById(R.id.gifButtImageView);
        progressBar.setProgress(0);
        final long time = startTime;

        if (startTime == 16000)
        {
            if (exeRestNum == 0) {
                ready.setText("Make Yourself Ready !");
                exeName.setText("1/12 Squats");
                gifImageView.setImageResource(R.drawable.squats);
                setTempSpeech("Make yourself ready . exercise 1 of 12 squats ");
                speek();
            } else if (exeRestNum == 1) {
                ready.setText("Make Yourself Ready !");
                exeName.setText("2/12 Froggy Glute Lifts");
                gifImageView.setImageResource(R.drawable.froggy_glute_lifts);
                setTempSpeech("Take Rest Make yourself ready . exercise 2 of 12 froggy glute lifts");
                speek();
            } else if (exeRestNum == 2) {
                ready.setText("Make Yourself Ready !");
                exeName.setText("3/12 Lunges");
                gifImageView.setImageResource(R.drawable.lunge);
                setTempSpeech("Take rest Make yourself ready . exercise 3 of 12 lunges");
                speek();
            } else if (exeRestNum == 3) {
                ready.setText("Make Yourself Ready !");
                gifImageView.setImageResource(R.drawable.butt_bridge);
                exeName.setText("4/12 Butt Bridge");
                setTempSpeech("Take rest Make yourself ready . exercise 4 of 12 Butt Bridge");
                speek();
            } else if (exeRestNum == 4) {
                ready.setText("Make Yourself Ready !");
                gifImageView.setImageResource(R.drawable.donkey_kick);
                exeName.setText("5/12 Donkey Kick Left");
                setTempSpeech("take rest Make yourself ready . exercise 5 of 12 donkey kick left");
                speek();
            } else if (exeRestNum == 5) {
                ready.setText("Make Yourself Ready !");
                exeName.setText("6/12 Donkey Kick Right");
                gifImageView.setImageResource(R.drawable.donkey_kick);
                setTempSpeech("take rest Make yourself ready . exercise 6 of 12 donkey kick right");
                speek();
            } else if (exeRestNum == 6) {
                ready.setText("Make Yourself Ready !");
                exeName.setText("7/12 Split Squat Right");
                gifImageView.setImageResource(R.drawable.split_squats);
                setTempSpeech("take rest Make yourself ready . exercise 7 of 12 split squat right");
                speek();
            } else if (exeRestNum == 7) {
                ready.setText("Make Yourself Ready !");
                exeName.setText("8/12 Split Squat Left");
                gifImageView.setImageResource(R.drawable.split_squats);
                setTempSpeech("take rest Make yourself ready . exercise 8 of 12 split squat left");
                speek();
            } else if (exeRestNum == 8) {
                ready.setText("Make Yourself Ready !");
                exeName.setText("9/12 Booty Squeeze Left");
                gifImageView.setImageResource(R.drawable.booty_squeeze);
                setTempSpeech("take rest Make yourself ready . exercise 9 of 12 booty squeeze left");
                speek();
            } else if (exeRestNum == 9) {
                ready.setText("Make Yourself Ready !");
                exeName.setText("10/12 booty squeeze right");
                gifImageView.setImageResource(R.drawable.booty_squeeze);
                setTempSpeech("take rest Make yourself ready . exercise 10 of 12 booty squeeze right");
                speek();
            } else if (exeRestNum == 10) {
                ready.setText("Make Yourself Ready !");
                exeName.setText("11/12 Plie Squats");
                gifImageView.setImageResource(R.drawable.plie_squats);
                setTempSpeech("take rest Make yourself ready . exercise 11 of 12 plie squats");
                speek();
            } else if (exeRestNum == 11) {
                ready.setText("Make Yourself Ready !");
                exeName.setText("12/12 Sumo Squat Calf Raises");
                gifImageView.setImageResource(R.drawable.sumo_squat_calf_raises);
                setTempSpeech("Make yourself ready . exercise 12 of 12 sumo squat calf raises");
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
        LayoutInflater factory = LayoutInflater.from(ButtExerciseActivity.this);
        final View view = factory.inflate(R.layout.sample, null);

        new AlertDialog.Builder(ButtExerciseActivity.this)
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
        new AlertDialog.Builder(ButtExerciseActivity.this)
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
                            Intent intent = new Intent(ButtExerciseActivity.this, ButtInstructionsActivity.class);
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
