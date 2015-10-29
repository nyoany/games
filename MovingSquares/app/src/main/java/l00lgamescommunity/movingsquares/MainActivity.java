package l00lgamescommunity.movingsquares;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setListeners();

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
                        blueImage.setVisibility(View.INVISIBLE);
                        break;

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
                        blackImage.setVisibility(View.INVISIBLE);
                        break;

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
                        yellowImage.setVisibility(View.INVISIBLE);
                        break;

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
                        greenImage.setVisibility(View.INVISIBLE);
                        break;

                }
                return true;
            }
        });
    }
}