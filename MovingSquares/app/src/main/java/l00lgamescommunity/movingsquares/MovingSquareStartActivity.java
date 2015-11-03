package l00lgamescommunity.movingsquares;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import java.util.ArrayList;
import java.util.List;

public class MovingSquareStartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moving_square_start);
        addListenerOnButton();
        addListenerOnCheckboxes();
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

    public void addListenerOnButton() {

        Button playButton = (Button) findViewById(R.id.playButton);

        playButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent gameStart = new Intent(MovingSquareStartActivity.this, MainActivity.class);
                startActivity(gameStart);
            }
        });
    }

    public void addListenerOnCheckboxes()
    {
        CheckBox easyCheck = (CheckBox) findViewById(R.id.easyCheck);
        CheckBox mediumCheck = (CheckBox) findViewById(R.id.mediumCheck);
        CheckBox hardCheck = (CheckBox) findViewById(R.id.expertCheck);

        easyCheck.setChecked(true);
        easyCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

        public void onCheckedChanged(CompoundButton arg0, boolean isChecked) {
            unCheckOthers(R.id.easyCheck);
        }
    });

        mediumCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton arg0, boolean isChecked) {
                unCheckOthers(R.id.mediumCheck);
            }
        });

        hardCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton arg0, boolean isChecked) {
                unCheckOthers(R.id.expertCheck);
            }
        });
    }

    private void unCheckOthers(int selectedID)
    {
        List<CheckBox> checkboxes = new ArrayList<>();
        checkboxes.add((CheckBox) findViewById(R.id.easyCheck));
        checkboxes.add((CheckBox) findViewById(R.id.mediumCheck));
        checkboxes.add((CheckBox) findViewById(R.id.expertCheck));

        for(CheckBox check : checkboxes)
        {
            if(check.isSelected() && check.getId()!= selectedID)
            {
                check.setChecked(false);
            }
        }
    }

}
