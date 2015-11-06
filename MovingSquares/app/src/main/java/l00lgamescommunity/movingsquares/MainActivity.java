package l00lgamescommunity.movingsquares;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Random;

public class MainActivity extends Activity {

    static int score = 0;
    static boolean running = false;
    static float bluePos = 0;
    static float blackPos = 0;
    static float yellowPos = 0;
    static float greenPos = 0;
    static float redPos = 0;
    static float purplePos = 0;

    SoundPool soundPool;
    HashMap<Integer, Integer> soundPoolMap;
    int soundID = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setListeners();
        startGame();
        soundPool = new SoundPool(4, AudioManager.STREAM_MUSIC, 100);
        soundPoolMap = new HashMap<Integer, Integer>();
        soundPoolMap.put(soundID, soundPool.load("C:\\games\\MovingSquares\\app\\src\\main\\res\\audio\\balloon.mp3", 1));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    private void setListeners()
    {
        final ImageView blueImage = (ImageView) findViewById(R.id.blue);
        blueImage.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int eventAction = event.getAction();

                switch (eventAction) {

                    case MotionEvent.ACTION_DOWN:

                    case MotionEvent.ACTION_UP:
                        if(running) {
                            blueImage.setVisibility(View.INVISIBLE);
                            bluePos = 0;
                            Random rand = new Random();
                            int n = rand.nextInt(200) + 20;
                            bluePos = bluePos + n;
                            blueImage.setX(bluePos);
                            blueImage.setVisibility(View.VISIBLE);
                            score = score + 20;
                            updateScore();
                            break;
                        }
                }
                return true;
            }
        });

        final ImageView blackImage = (ImageView) findViewById(R.id.black);
        blackImage.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int eventAction = event.getAction();

                switch (eventAction) {

                    case MotionEvent.ACTION_DOWN:

                    case MotionEvent.ACTION_UP:
                        if(running) {
                                blackImage.setVisibility(View.INVISIBLE);
                                blackPos = 0;

                            AudioManager audioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
                            float curVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
                            float maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
                            float leftVolume = curVolume/maxVolume;
                            float rightVolume = curVolume/maxVolume;
                            int priority = 1;
                            int no_loop = 0;
                            float normal_playback_rate = 1f;
                            soundPool.play(soundID, leftVolume, rightVolume, priority, no_loop, normal_playback_rate);


                            Random rand = new Random();
                                int n = rand.nextInt(200) + 20;
                                blackPos = blackPos + n;
                                blackImage.setX(blackPos);
                                blackImage.setVisibility(View.VISIBLE);
                                score = score + 40;
                                updateScore();
                                break;
                        }
                }
                return true;
            }
        });

        final ImageView yellowImage = (ImageView) findViewById(R.id.yellow);
        yellowImage.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int eventAction = event.getAction();

                switch (eventAction) {

                    case MotionEvent.ACTION_DOWN:

                    case MotionEvent.ACTION_UP:
                        if(running) {
                            yellowImage.setVisibility(View.INVISIBLE);
                            yellowPos = 0;
                            Random rand = new Random();
                            int n = rand.nextInt(200) + 20;
                            yellowPos = yellowPos + n;
                            yellowImage.setX(yellowPos);
                            yellowImage.setVisibility(View.VISIBLE);
                            score = score + 80;
                            updateScore();
                            break;
                        }
                }
                return true;
            }
        });

        final ImageView greenImage = (ImageView) findViewById(R.id.green);
        greenImage.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int eventAction = event.getAction();

                switch (eventAction) {

                    case MotionEvent.ACTION_DOWN:

                    case MotionEvent.ACTION_UP:
                        if(running) {
                            greenImage.setVisibility(View.INVISIBLE);
                            greenPos = 0;
                            Random rand = new Random();
                            int n = rand.nextInt(200) + 20;
                            greenPos = greenPos + n;
                            greenImage.setX(greenPos);
                            greenImage.setVisibility(View.VISIBLE);
                            score = score + 120;
                            updateScore();
                            break;
                        }
                }
                return true;
            }
        });

        final ImageView redImage = (ImageView) findViewById(R.id.red);
        redImage.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int eventAction = event.getAction();

                switch (eventAction) {

                    case MotionEvent.ACTION_DOWN:

                    case MotionEvent.ACTION_UP:
                        if(running) {
                            redImage.setVisibility(View.INVISIBLE);
                            redPos = 0;
                            Random rand = new Random();
                            int n = rand.nextInt(200) + 20;
                            redPos = redPos + n;
                            redImage.setX(redPos);
                            redImage.setVisibility(View.VISIBLE);
                            score = score + 160;
                            updateScore();
                            break;
                        }
                }
                return true;
            }
        });

        final ImageView purpleImage = (ImageView) findViewById(R.id.purple);
        purpleImage.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int eventAction = event.getAction();

                switch (eventAction) {

                    case MotionEvent.ACTION_DOWN:

                    case MotionEvent.ACTION_UP:
                        if(running) {
                            purpleImage.setVisibility(View.INVISIBLE);
                            purplePos = 0;
                            Random rand = new Random();
                            int n = rand.nextInt(200) + 20;
                            purplePos = purplePos + n;
                            purpleImage.setX(purplePos);
                            purpleImage.setVisibility(View.VISIBLE);
                            score = score + 220;
                            updateScore();
                            break;
                        }
                }
                return true;
            }
        });
    }

    private static int getScore()
    {
        return score;
    }

    private void updateScore()
    {
        TextView scoreDisplay = (TextView) findViewById(R.id.scoreId);
        scoreDisplay.setText(Integer.toString(getScore()));

    }

    private void startGame()
    {
        TextView scoreDisplay = (TextView) findViewById(R.id.scoreId);
        scoreDisplay.setText("0");
        running = true;
        score = 0;

        new CountDownTimer(15000, 1000) {

            public void onTick(long millisUntilFinished) {
                ((TextView)findViewById(R.id.timerId)).setText(String.format("%d", millisUntilFinished / 1000));
                    moveImages();
                }

            public void onFinish() {
                ((TextView)findViewById(R.id.timerId)).setText("0");
                running = false;
                Context context = getApplicationContext();
                CharSequence text = "Game over! \n You scored : " + score + ".";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        }.start();
    }

    private void moveImages()
    {
        ImageView blueImage = (ImageView) findViewById(R.id.blue);

        if(blueImage.getX() >= 350)
        {
            bluePos = 30;

        }
        else
        {
            bluePos = blueImage.getX() + 30;
        }
        blueImage.setX(bluePos);

        ImageView blackImage = (ImageView) findViewById(R.id.black);

        if(blackImage.getX() >= 350)
        {
            blackPos = 40;

        }
        else
        {
            blackPos = blackImage.getX() + 40;
        }
        blackImage.setX(blackPos);

        ImageView yellowImage = (ImageView) findViewById(R.id.yellow);

        if(yellowImage.getX() >= 350)
        {
            yellowPos = 50;

        }
        else
        {
            yellowPos = yellowImage.getX() + 50;
        }
        yellowImage.setX(yellowPos);


        ImageView greenImage = (ImageView) findViewById(R.id.green);

        if(greenImage.getX() >= 350)
        {
            greenPos = 60;

        }
        else
        {
            greenPos = greenImage.getX() + 60;
        }
        greenImage.setX(greenPos);

        ImageView redImage = (ImageView) findViewById(R.id.red);

        if(redImage.getX() >= 350)
        {
            redPos = 70;

        }
        else
        {
            redPos = redImage.getX() + 70;
        }
        redImage.setX(redPos);

        ImageView purpleImage = (ImageView) findViewById(R.id.purple);
        if(purpleImage.getX() >= 350)
        {
            purplePos = 80;

        }
        else
        {
            purplePos = purpleImage.getX() + 80;
        }
        purpleImage.setX(purplePos);
    }
}
