package l00lgamescommunity.movingsquares;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends Activity
{
    static int score = 0;
    static boolean running = false;
    static float blueYPos = 0;
    static float blackYPos = 0;
    static float yellowYPos = 0;
    static float greenYPos = 0;
    static float redYPos = 0;
    static float purpleYPos = 0;

    static float blueXPos = 0;
    static float blackXPos = 0;
    static float yellowXPos = 0;
    static float greenXPos = 0;
    static float redXPos = 0;
    static float purpleXPos = 0;

    static float blueInitialX = 0;
    static float blackInitialX = 0;
    static float greenInitialX = 0;
    static float yellowInitialX = 0;
    static float redInitialX = 0;
    static float purpleInitialX = 0;

    static boolean blueDead = false;
    static boolean blackDead = false;
    static boolean greenDead = false;
    static boolean yellowDead = false;
    static boolean redDead = false;
    static boolean purpleDead = false;
    static final int maxY = 410;

    static int level = 1;

    static int speed = 30;

    MediaPlayer mp;
    MediaPlayer startSound;
    MediaPlayer dieSound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setListeners();
        playStartSound();
        startGame();
        mp = MediaPlayer.create(this, R.raw.blop);
        startSound = MediaPlayer.create(this, R.raw.caramba);
        dieSound = MediaPlayer.create(this, R.raw.woosh);
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

    private void playStartSound()
    {
        mp.start();
    }
    private void playSound()
    {
        mp.start();
    }
    private void playDieSound()
    {
        dieSound.start();
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
                        if(running && !blueDead) {
                            playSound();
                            blueImage.setVisibility(View.INVISIBLE);
                            blueYPos = 0;
                            Random rand = new Random();
                            int n = 20;
                            blueYPos = blueYPos + n;
                            blueImage.setY(blueYPos);
                            blueImage.setVisibility(View.VISIBLE);
                            score = score + 30;
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
                        if(running && !blackDead) {
                            playSound();
                            blackImage.setVisibility(View.INVISIBLE);
                            blackYPos = 0;
                            Random rand = new Random();
                            int n = 20;
                            blackYPos = blackYPos + n;
                            blackImage.setY(blackYPos);
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
                        if(running && !yellowDead) {
                            playSound();
                            yellowImage.setVisibility(View.INVISIBLE);
                            yellowYPos = 0;
                            Random rand = new Random();
                            int n = 20;
                            yellowYPos = yellowYPos + n;
                            yellowImage.setY(yellowYPos);
                            yellowImage.setVisibility(View.VISIBLE);
                            score = score + 50;
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
                        if(running && !greenDead) {
                            playSound();
                            greenImage.setVisibility(View.INVISIBLE);
                            greenYPos = 0;
                            Random rand = new Random();
                            int n = 20;
                            greenYPos = greenYPos + n;
                            greenImage.setY(greenYPos);
                            greenImage.setVisibility(View.VISIBLE);
                            score = score + 60;
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
                        if(running && !redDead) {
                            playSound();
                            redImage.setVisibility(View.INVISIBLE);
                            redYPos = 0;
                            Random rand = new Random();
                            int n = 20;
                            redYPos = redYPos + n;
                            redImage.setY(redYPos);
                            redImage.setVisibility(View.VISIBLE);
                            score = score + 70;
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
                        if(running && !purpleDead) {
                            playSound();
                            purpleImage.setVisibility(View.INVISIBLE);
                            purpleYPos = 0;
                            Random rand = new Random();
                            int n = 20;
                            purpleYPos = purpleYPos + n;
                            purpleImage.setY(purpleYPos);
                            purpleImage.setVisibility(View.VISIBLE);
                            score = score + 80;
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

    private void initialize(){

        blueYPos = 0;
        blackYPos = 0;
        yellowYPos = 0;
        greenYPos = 0;
        redYPos = 0;
        purpleYPos = 0;

        blueXPos = 0;
        blackXPos = 0;
        yellowXPos = 0;
        greenXPos = 0;
        redXPos = 0;
        purpleXPos = 0;

        blueInitialX = 0;
        blackInitialX = 0;
        greenInitialX = 0;
        yellowInitialX = 0;
        redInitialX = 0;
        purpleInitialX = 0;

        blueDead = false;
        blackDead = false;
        greenDead = false;
        yellowDead = false;
        redDead = false;
        purpleDead = false;

    }

    private void startGame()
    {
        TextView scoreDisplay = (TextView) findViewById(R.id.scoreId);
        scoreDisplay.setText("0");
        running = true;
        score = 0;
        initialize();


        new CountDownTimer(25000, 1000) {

            public void onTick(long millisUntilFinished) {
                ((TextView)findViewById(R.id.timerId)).setText(String.format("%d", millisUntilFinished / 1000));
                moveImages();
            }

            public void onFinish() {
                ((TextView)findViewById(R.id.timerId)).setText("0");
                running = false;
              /*  blueYPos = 20;
                blueXPos = blueInitialX;
                (findViewById(R.id.blue)).setY(20);
                (findViewById(R.id.blue)).setX(blueXPos);
                blackYPos = 20;
                blackXPos = blackInitialX;
                (findViewById(R.id.black)).setY(20);
                (findViewById(R.id.black)).setX(blackXPos);
                yellowYPos = 20;
                yellowXPos = yellowInitialX;
                (findViewById(R.id.yellow)).setY(20);
                (findViewById(R.id.yellow)).setX(yellowXPos);
                redYPos = 20;
                redXPos = redInitialX;
                (findViewById(R.id.red)).setY(20);
                (findViewById(R.id.red)).setX(redInitialX);
                greenYPos = 20;
                greenXPos = greenInitialX;
                (findViewById(R.id.green)).setY(20);
                (findViewById(R.id.green)).setX(greenXPos);
                purpleYPos = 20;
                purpleXPos = purpleInitialX;
                (findViewById(R.id.purple)).setY(20);
                (findViewById(R.id.purple)).setX(purpleInitialX);
*/
                Context context = getApplicationContext();
                CharSequence text = "Game over! \n You scored : " + score + ".";
                int duration = Toast.LENGTH_LONG;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        }.start();
    }

    private void moveImages()
    {
        if(level == 2)
        {
            speed = 50;
        }
        else if(level == 3)
        {
            speed = 80;
        }

        ImageView blueImage = (ImageView) findViewById(R.id.blue);

        if(blueImage.getY() >= maxY && !blueDead)
        {
            System.out.println(blueImage.getY());
            blueDead = true;
            playDieSound();
            blueImage.setBackgroundResource(R.drawable.my_cow_dead_green);
            //   blueYPos = 20;
            // blueXPos = blueInitialX;
        }
        else if (!blueDead)
        {
            blueYPos = blueImage.getY() + speed;
            if(maxY < blueYPos)
            {
                blueYPos = maxY;
            }

            if(blueInitialX == 0)
            {
                blueInitialX = blueImage.getX();
            }
            if(blueImage.getX() > blueInitialX) {
                blueXPos = blueImage.getX() - 20;
            }
            else
            {
                blueXPos = blueImage.getX() + 20;
            }
            blueImage.setY(blueYPos);
            blueImage.setX(blueXPos);
        }

        ImageView blackImage = (ImageView) findViewById(R.id.black);

        if(blackImage.getY() >= maxY && !blackDead)
        {
            System.out.println(blackImage.getY());
            blackDead = true;
            playDieSound();
            blackImage.setBackgroundResource(R.drawable.my_cow2_dead_green);
            //  blackYPos = 20;
            //blackXPos = blackInitialX;
        }
        else if(!blackDead)
        {
            blackYPos = blackImage.getY() + speed;
            if(maxY < blackYPos)
            {
                blackYPos = maxY;
            }

            if(blackInitialX == 0)
            {
                blackInitialX = blackImage.getX();
            }
            if(blackImage.getX() > blackInitialX) {
                blackXPos = blackImage.getX() - 20;
            }
            else
            {
                blackXPos = blackImage.getX() + 20;
            }
            blackImage.setY(blackYPos);
            blackImage.setX(blackXPos);
        }

        ImageView yellowImage = (ImageView) findViewById(R.id.yellow);

        if(yellowImage.getY() >= maxY && !yellowDead)
        {
            System.out.println(yellowImage.getY());
            yellowDead = true;
            playDieSound();
            yellowImage.setBackgroundResource(R.drawable.my_cow3_dead_green);
            //  yellowYPos = 20;
            //yellowXPos = yellowInitialX;
        }
        else if(!yellowDead)
        {
            yellowYPos = yellowImage.getY() + speed;

            if(maxY < yellowYPos)
            {
                yellowYPos = maxY;
            }

            if(yellowInitialX == 0)
            {
                yellowInitialX = yellowImage.getX();
            }
            if(yellowImage.getX() > yellowInitialX) {
                yellowXPos = yellowImage.getX() - 20;
            }
            else
            {
                yellowXPos = yellowImage.getX() + 20;
            }
            yellowImage.setY(yellowYPos);
            yellowImage.setX(yellowXPos);
        }

        ImageView greenImage = (ImageView) findViewById(R.id.green);

        if(greenImage.getY() >= maxY && !greenDead)
        {
            System.out.println(greenImage.getY());
            greenDead = true;
            playDieSound();
            greenImage.setBackgroundResource(R.drawable.my_cow4_dead_green);
            // greenYPos = 20;
            //greenXPos = greenInitialX;
        }
        else if(!greenDead)
        {
            greenYPos = greenImage.getY() + speed;

            if(maxY < greenYPos)
            {
                greenYPos = maxY;
            }

            if(greenInitialX == 0)
            {
                greenInitialX = greenImage.getX();
            }
            if(greenImage.getX() > greenInitialX) {
                greenXPos = greenImage.getX() - 20;
            }
            else
            {
                greenXPos = greenImage.getX() + 20;
            }
            greenImage.setY(greenYPos);
            greenImage.setX(greenXPos);
        }


        ImageView redImage = (ImageView) findViewById(R.id.red);

        if(redImage.getY() >= maxY && !redDead)
        {
            System.out.println(redImage.getY());
            redDead = true;
            playDieSound();
            redImage.setBackgroundResource(R.drawable.my_cow5_dead_green);
            // redYPos = 20;
            //redXPos = redInitialX;
        }
        else if(!redDead)
        {
            redYPos = redImage.getY() + speed;

            if(maxY < redYPos)
            {
                redYPos = maxY;
            }

            if(redInitialX == 0)
            {
                redInitialX = redImage.getX();
            }
            if(redImage.getX() > redInitialX) {
                redXPos = redImage.getX() - 20;
            }
            else
            {
                redXPos = redImage.getX() + 20;
            }
            redImage.setY(redYPos);
            redImage.setX(redXPos);
        }


        ImageView purpleImage = (ImageView) findViewById(R.id.purple);
        if(purpleImage.getY() >= maxY && !purpleDead)
        {
            System.out.println(purpleImage.getY());
            purpleDead = true;
            playDieSound();
            purpleImage.setBackgroundResource(R.drawable.my_cow6_dead_green);
            // purpleYPos = 20;
            // purpleXPos = purpleInitialX;
        }
        else if(!purpleDead)
        {
            purpleYPos = purpleImage.getY() + speed;

            if(maxY < purpleYPos)
            {
                purpleYPos = maxY;
            }

            if(purpleInitialX == 0)
            {
                purpleInitialX = purpleImage.getX();
            }
            if(purpleImage.getX() > purpleInitialX) {
                purpleXPos = purpleImage.getX() - 20;
            }
            else
            {
                purpleXPos = purpleImage.getX() + 20;
            }
            purpleImage.setY(purpleYPos);
            purpleImage.setX(purpleXPos);
        }

    }
}
