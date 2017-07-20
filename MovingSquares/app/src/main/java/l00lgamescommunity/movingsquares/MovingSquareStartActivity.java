package l00lgamescommunity.movingsquares;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class MovingSquareStartActivity extends AppCompatActivity {
    public static int level = 1;
    MediaPlayer startSound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moving_square_start);
        addListenersOnButtons();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_moving_square_start, menu);
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

    public void addListenersOnButtons() {

        Button playButton = (Button) findViewById(R.id.playButton);

        playButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent gameStart = new Intent(MovingSquareStartActivity.this, MainActivity.class);
                MainActivity.setLevel(level);
                startActivity(gameStart);
            }
        });

        Button aboutButton = (Button) findViewById(R.id.aboutButton);

        aboutButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent about = new Intent(MovingSquareStartActivity.this, AboutActivity.class);
                startActivity(about);
            }
        });

    }

        public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.easyCheck:
                if (checked)
                {
                    level = 1;
                    break;
                }
            case R.id.mediumCheck:
                if (checked)
                {
                    level = 2;
                    break;
                }
            case R.id.expertCheck:
                if(checked)
                {
                    level = 3;
                }
        }
    }
}
