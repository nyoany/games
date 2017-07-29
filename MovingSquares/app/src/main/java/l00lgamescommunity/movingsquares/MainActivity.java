package l00lgamescommunity.movingsquares;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    int score = 0;
    static boolean running = false;
    private Random rand = new Random();

    /**
     * A list of the cows in the game.
     */
    private List<Cow> cows = Arrays.asList(new Cow(R.id.blue, R.drawable.my_cow_dead_green, 30),
            new Cow(R.id.black, R.drawable.my_cow2_dead_green, 40),
            new Cow(R.id.yellow, R.drawable.my_cow3_dead_green, 50),
            new Cow(R.id.green, R.drawable.my_cow4_dead_green, 60),
            new Cow(R.id.red, R.drawable.my_cow5_dead_green, 70),
            new Cow(R.id.purple, R.drawable.my_cow6_dead_green, 80));

    final int maxY = 600;

    private static int level = 1;
    /** The minimum vertical speed of the cows (determined by the level). */
    private static int baseSpeed = 5;

    MediaPlayer mp;
    // MediaPlayer startSound;
    MediaPlayer dieSound;

    /**
     * Set the level and the base speed.
     *
     * @param level The level number (between 1 and 3).
     */
    public static void setLevel(int level) {
        MainActivity.level = level;
        baseSpeed = 3 + 2 * level;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setListeners();
        mp = MediaPlayer.create(this, R.raw.blop);
        // startSound = MediaPlayer.create(this, R.raw.caramba);
        dieSound = MediaPlayer.create(this, R.raw.woosh);
        // playStartSound();
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

    private void playStartSound() {
        mp.start();
    }

    private void playSound() {
        mp.start();
    }

    private void playDieSound() {
        dieSound.start();
    }

    private void setListeners() {
        Button backButton = (Button) findViewById(R.id.backButton);
        backButton.setEnabled(false);
        backButton.setClickable(false);

        backButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                if (!running) {
                    Intent back = new Intent(MainActivity.this, MovingSquareStartActivity.class);
                    startActivity(back);
                }
            }
        });

        for (Cow cow : cows) {
            setupCow(cow);
        }
    }

    /**
     * Initialise a cow with a click listener.
     *
     * @param cow The cow to set up.
     */
    private void setupCow(final Cow cow) {
        final ImageView image = (ImageView) findViewById(cow.getImageId());
        image.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int eventAction = event.getAction();

                switch (eventAction) {

                    case MotionEvent.ACTION_DOWN:
                        if (running && !cow.isDead()) {
                            playSound();
                            image.setVisibility(View.INVISIBLE);
                            cow.setYPos(0);
                            int n = 20;
                            cow.setYPos(cow.getYPos() + n);
                            image.setY(cow.getYPos());
                            image.setVisibility(View.VISIBLE);
                            score = score + cow.getScore();
                            updateScore();
                            break;
                        }
                }
                return true;
            }
        });
    }

    private int getScore() {
        return score;
    }

    private void updateScore() {
        TextView scoreDisplay = (TextView) findViewById(R.id.scoreId);
        scoreDisplay.setText(Integer.toString(getScore()));

    }

    private void initialize() {
        cows = Arrays.asList(new Cow(R.id.blue, R.drawable.my_cow_dead_green, 30),
                new Cow(R.id.black, R.drawable.my_cow2_dead_green, 40),
                new Cow(R.id.yellow, R.drawable.my_cow3_dead_green, 50),
                new Cow(R.id.green, R.drawable.my_cow4_dead_green, 60),
                new Cow(R.id.red, R.drawable.my_cow5_dead_green, 70),
                new Cow(R.id.purple, R.drawable.my_cow6_dead_green, 80));
    }

    private void startGame() {
        TextView scoreDisplay = (TextView) findViewById(R.id.scoreId);
        scoreDisplay.setText("0");
        running = true;
        score = 0;
        initialize();

        new CountDownTimer(25000, 100) {

            public void onTick(long millisUntilFinished) {
                ((TextView) findViewById(R.id.timerId)).setText(String.format("%d", millisUntilFinished / 100));
                boolean allDead = true;
                for (Cow cow : cows) {
                    if (!cow.isDead()) {
                        allDead = false;
                        break;
                    }
                }
                if (allDead) {
                    onFinish();
                    cancel();
                    return;
                }
                moveImages();
            }

            public void onFinish() {
                ((TextView) findViewById(R.id.timerId)).setText("0");

                running = false;

                Button backButton = (Button) findViewById(R.id.backButton);
                backButton.setEnabled(true);
                backButton.setClickable(true);

                Context context = getApplicationContext();
                CharSequence text = "You scored : " + score + ".";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        }.start();
    }

    private void moveImages() {
        for (Cow cow : cows) {
            moveCow(cow);
        }
    }

    /**
     * Update the state of the given cow.
     *
     * @param cow The cow to update.
     */
    private void moveCow(Cow cow) {
        ImageView image = (ImageView) findViewById(cow.getImageId());
        if (image.getY() >= maxY && !cow.isDead()) {
            System.out.println(image.getY());
            cow.setDead(true);
            playDieSound();
            image.setBackgroundResource(cow.getDeadImageId());
            image.setEnabled(false);
        } else if (!cow.isDead()) {
            cow.setSpeed(Math.min(Math.max(cow.getSpeed() + rand.nextInt(10) - 5, 0), baseSpeed));
            cow.setYPos(image.getY() + cow.getSpeed() + baseSpeed);
            if (maxY < cow.getYPos()) {
                cow.setYPos(maxY);
            }

            if (cow.getInitialX() == 0) {
                cow.setInitialX(image.getX());
            }
            if (image.getX() > cow.getInitialX()) {
                cow.setXPos(image.getX() - rand.nextInt(20));
            } else {
                cow.setXPos(image.getX() + rand.nextInt(20));
            }
            image.setY(cow.getYPos());
            image.setX(cow.getXPos());
        }
    }
}
