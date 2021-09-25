package io.github.hashim.workoutTrainer.LegWorkout;

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

public class LegExerciseActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {
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
        setContentView(R.layout.activity_leg_exercise);
        androidx.appcompat.widget.Toolbar toolbar =findViewById(R.id.legToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Leg Workout");
        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialogCreate();
            }
        });
        textToSpeech = new TextToSpeech(LegExerciseActivity.this, LegExerciseActivity.this);
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
        exeName = findViewById(R.id.legExerciseName);
        num = findViewById(R.id.tvLegNum);
        ready = findViewById(R.id.legReady);
        skip = findViewById(R.id.legSkip);
        progressBar = findViewById(R.id.legProgressBar);
        GifImageView gifImageView = findViewById(R.id.gifLegImageView);
        progressBar.setProgress(0);
        final long time = startTime;

        if (startTime == 16000)
        {
            if (exeRestNum == 0) {
                ready.setText("Make Yourself Ready !");
                exeName.setText("1/11 Calf Raises");
                gifImageView.setImageResource(R.drawable.calf_raises);
                setTempSpeech("Make yourself ready . exercise 1 of 11 Calf Raises ");
                speek();
            } else if (exeRestNum == 1) {
                ready.setText("Make Yourself Ready !");
                exeName.setText("2/11 Curtsy Lunges");
                gifImageView.setImageResource(R.drawable.lunge);
                setTempSpeech("Take Rest Make yourself ready . exercise 2 of 11 curtsy lunges");
                speek();
            } else if (exeRestNum == 2) {
                ready.setText("Make Yourself Ready !");
                exeName.setText("3/11 Single Left Leg Calf Raises");
                gifImageView.setImageResource(R.drawable.single_leg_calf_raises);
                setTempSpeech("Take rest Make yourself ready . exercise 3 of 11 Single Left Leg Calf Raises");
                speek();
            } else if (exeRestNum == 3) {
                ready.setText("Make Yourself Ready !");
                gifImageView.setImageResource(R.drawable.side_lunges);
                exeName.setText("4/11 Side Lunges");
                setTempSpeech("Take rest Make yourself ready . exercise 4 of 11 side lunges");
                speek();
            } else if (exeRestNum == 4) {
                ready.setText("Make Yourself Ready !");
                gifImageView.setImageResource(R.drawable.lunge_knee_hops);
                exeName.setText("5/11 Left Lunge Knee Hops");
                setTempSpeech("take rest Make yourself ready . exercise 5 of 11 left lunge knee hops");
                speek();
            } else if (exeRestNum == 5) {
                ready.setText("Make Yourself Ready !");
                exeName.setText("6/11 Single Right Leg Calf Raises");
                gifImageView.setImageResource(R.drawable.single_leg_calf_raises);
                setTempSpeech("take rest Make yourself ready . exercise 6 of 11 single right leg calf raises");
                speek();
            } else if (exeRestNum == 6) {
                ready.setText("Make Yourself Ready !");
                exeName.setText("7/11 Bottom Leg Lift Left");
                gifImageView.setImageResource(R.drawable.bottom_leg_lift);
                setTempSpeech("take rest Make yourself ready . exercise 7 of 11 bottom leg lift left");
                speek();
            } else if (exeRestNum == 7) {
                ready.setText("Make Yourself Ready !");
                exeName.setText("8/11 Bottom Leg Lift Right");
                gifImageView.setImageResource(R.drawable.bottom_leg_lift);
                setTempSpeech("take rest Make yourself ready . exercise 8 of 11 bottom leg lift right");
                speek();
            } else if (exeRestNum == 8) {
                ready.setText("Make Yourself Ready !");
                exeName.setText("9/11 Right Lunge Knee Hops");
                gifImageView.setImageResource(R.drawable.lunge_knee_hops);
                setTempSpeech("take rest Make yourself ready . exercise 9 of 11 right lunge knee hops");
                speek();
            } else if (exeRestNum == 9) {
                ready.setText("Make Yourself Ready !");
                exeName.setText("10/11 Side Leg Circles Left");
                gifImageView.setImageResource(R.drawable.side_leg_circles);
                setTempSpeech("take rest Make yourself ready . exercise 10 of 11 side leg circles left");
                speek();
            } else if (exeRestNum == 10) {
                ready.setText("Make Yourself Ready !");
                exeName.setText("11/11 Side Leg Circles Right");
                gifImageView.setImageResource(R.drawable.side_leg_circles);
                setTempSpeech("take rest Make yourself ready . exercise 11 of 11 side leg circles right");
                speek();
            }  else {
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
        LayoutInflater factory = LayoutInflater.from(LegExerciseActivity.this);
        final View view = factory.inflate(R.layout.sample, null);

        new AlertDialog.Builder(LegExerciseActivity.this)
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
        new AlertDialog.Builder(LegExerciseActivity.this)
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
                            Intent intent = new Intent(LegExerciseActivity.this, LegInstructionsActivity.class);
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
