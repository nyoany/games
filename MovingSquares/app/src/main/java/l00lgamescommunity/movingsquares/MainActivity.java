package l00lgamescommunity.movingsquares;

import android.app.Activity;
import android.content.Context;
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

public class MainActivity extends Activity {

    static int score = 0;
    static boolean running = false;
    static float bluePos = 0;
    static int blackPos = 0;
    static int yellowPos = 0;
    static int greenPos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setListeners();
        startGame();
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
                                score = score + 20;
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
                            score = score + 20;
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
                            score = score + 20;
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
        bluePos = blueImage.getX() + 10;
        blueImage.setX(bluePos);
    }
}
